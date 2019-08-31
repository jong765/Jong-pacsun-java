package com.pacsun.hingeto.productexport.process;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.hingeto.api.CategoryAssignment;
import com.hingeto.api.CategoryAssignmentData;
import com.hingeto.api.ContentMessage;
import com.hingeto.api.Feed;
import com.hingeto.api.NamedLocalizedAttribute;
import com.hingeto.api.ProductAttribute;
import com.hingeto.api.ProductContentType;
import com.hingeto.api.ProductData;
import com.pacsun.hingeto.exception.InvalidXmlException;
import com.pacsun.hingeto.process.ListingProcess;
import com.pacsun.hingeto.productexport.dao.ProductDao;
import com.pacsun.hingeto.productexport.dto.ProductDto;
import com.pacsun.util.JAXBUnmarshallerUtil;
import com.pacsun.util.StackTrace;

public class ProductExportProcess extends ListingProcess {

	@Autowired
	ProductDao productDao;

	@Value("${sftp.user}")
	protected String SFTP_USER;

	@Value("${sftp.key.location}")
	private String SFTP_KEY_LOCATION;

	@Value("${productexport.datafile.queue.folder}")
	protected String DATA_QUEUE_FOLDER;

	@Value("${productexport.datafile.processed.folder}")
	protected String DATA_PROCESSED_FOLDER;

	@Value("${productexport.datafile.failed.folder}")
	protected String DATA_FAILED_FOLDER;

	@Value("${productexport.datafile.prefix}")
	private String PRODUCT_EXPORT_FILE_PREFIX;

	@Value("${sftp.productexport.remote.folder}")
	private String PRODUCT_EXPORT_REMOTE_FOLDER;

	@Value("${productexport.imagefile.xml.queue.folder}")
	private String IMAGE_QUEUE_FOLDER;
	private List<ContentMessage> contentMessageList;
	private static final Logger log = Logger.getLogger(ProductExportProcess.class);

	public void start() throws Exception {
		log.info("Hingeto product export process has started.");

		File[] files = getFilesToProcess();
		copyFilesForImageJob(files);

		if (files.length == 0) {
			log.info("No hingeto product export xml files to retrieve at this time.");
		}
		for (File file : files) {
			if (validXml(file)) {
				setContentMessageList(unMarshalListingExportXmlFile(file.getPath()));
				try {
					insertProducts(file.getName());
					moveFile(file.getName(), this.DATA_QUEUE_FOLDER, this.DATA_PROCESSED_FOLDER);
				} catch (Exception e) {
					moveFile(file.getName(), this.DATA_QUEUE_FOLDER, this.DATA_FAILED_FOLDER);
					throw new Exception(e);
				}
			} else {
				log.error("Validation error in file:" + file.getPath());
				moveFile(file.getName(), this.DATA_QUEUE_FOLDER, this.DATA_FAILED_FOLDER);
				throw new InvalidXmlException("Schema validation failed. Product export file is invalid.");
			}
		}

		log.info("Hingeto product export process has completed successfully.");
	}

	public void copyFilesForImageJob(File[] files) throws Exception {
		for (File srcFile : files) {
			String destFileString = this.IMAGE_QUEUE_FOLDER + srcFile.getName();
			File destFile = new File(destFileString);
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
				log.error(errorMessage);
				throw new Exception(errorMessage);
			}
		}
	}

	public File[] getFilesToProcess() throws Exception {
		try {
			receiveFileSftp();
		} catch (Exception e) {
			errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		}

		return getQueuedFiles(this.DATA_QUEUE_FOLDER, this.PRODUCT_EXPORT_FILE_PREFIX, ".xml");
	}

	public void insertProducts(String xmlFileName) throws Exception {
		try {
			List productDtoList = new ArrayList();
			for (ContentMessage contentMessage : this.contentMessageList) {
				ProductDto productDto = new ProductDto();
				ProductContentType productContentType = contentMessage.getProductContent();
				ProductData productData = productContentType.getProductData();
				CategoryAssignmentData categoryAssignmentData = productContentType.getCategoryAssignmentData();
				List productAttributeList = productData.getAttribute();

				int classz = 0;
				int vendor = 0;
				int style = 0;
				int color = 0;

				productDto.setSku(Integer.parseInt(contentMessage.getStorefrontProductID()));
				productDto.setTitle(((NamedLocalizedAttribute.Value) productData.getTitle().getValue().get(0)).getValue());
				Iterator productDescriptionIterator = productData.getDescription().getValue().iterator();

				String productDescription = "";
				while (productDescriptionIterator.hasNext()) {
					NamedLocalizedAttribute.Value value = (NamedLocalizedAttribute.Value) productDescriptionIterator.next();
					productDescription = productDescription + value.getValue();
				}
				productDto.setProductDescription(formatDescription(productDescription));
				classz = Integer.parseInt(((CategoryAssignment) categoryAssignmentData.getCategoryAssignment().get(0)).getCategoryID());
				productDto.setClassz(classz);

				Iterator productAttributeIterator = productAttributeList.iterator();

				while (productAttributeIterator.hasNext()) {
					ProductAttribute productAttribute = (ProductAttribute) productAttributeIterator.next();
					String name = productAttribute.getName();

					if (name.equalsIgnoreCase("SupplierContentProvider")) {
						productDto.setEffectiveSupplierId(productAttribute.getValue());
					} else if (name.equalsIgnoreCase("Vendor")) {
						vendor = Integer.parseInt(productAttribute.getValue());
						productDto.setVendor(vendor);
					} else if (name.equalsIgnoreCase("Style")) {
						style = Integer.parseInt(productAttribute.getValue());
						productDto.setStyle(style);
					} else if (name.equalsIgnoreCase("Color")) {
						color = Integer.parseInt(productAttribute.getValue());
						productDto.setColor(color);
					} else if (name.equalsIgnoreCase("Size")) {
						productDto.setSize(Integer.parseInt(productAttribute.getValue()));
					} else if (name.equalsIgnoreCase("Exclude From Gift Boxing")) {
						productDto.setExcludeGiftBox(productAttribute.getValue());
					} else if (name.equalsIgnoreCase("Exclusive Type")) {
						productDto.setExclusiveType(productAttribute.getValue());
					} else if (name.equalsIgnoreCase("Feed Processed")) {
						productDto.setFeedProcessed(productAttribute.getValue());
					} else if (name.equalsIgnoreCase("Is Reg?")) {
						productDto.setIsRegular(productAttribute.getValue());
					} else if (name.equalsIgnoreCase("Is Markdown?")) {
						productDto.setMarkdownFlag(productAttribute.getValue());
					} else if (name.equalsIgnoreCase("Online Exclusive")) {
						productDto.setOnlineExclusive(productAttribute.getValue());
					} else if (name.equalsIgnoreCase("Item Ticketing")) {
						productDto.setItemTicketing(productAttribute.getValue());
					} else if (name.equalsIgnoreCase("SupplierContentProviderSKU")) {
						productDto.setBarCode(productAttribute.getValue());
					} else if (name.equalsIgnoreCase("Exclude Class Map")) {
						productDto.setExcludeClassMap(productAttribute.getValue());
					} else if (name.equalsIgnoreCase("Drop Ship")) {
						productDto.setDropShip(productAttribute.getValue());
					}

				}

				productDtoList.add(productDto);
			}

			this.productDao.insertBatch(productDtoList, xmlFileName);
		} catch (Exception e) {
			errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		}
	}

	public String formatDescription(String productDescription) {
		if ((productDescription.toLowerCase().indexOf("&lt;p&gt;") == -1) && (productDescription.toLowerCase().indexOf("<p>") == -1)) {
			return "<p>" + productDescription.trim() + "</p>";
		}
		return productDescription;
	}

	public List<ContentMessage> unMarshalListingExportXmlFile(String fullXmlFileName) throws Exception {
		JAXBUnmarshallerUtil jaxbUnmarshallerUtil = new JAXBUnmarshallerUtil();
		List contentMessageList = null;
		try {
			Feed feed = (Feed) jaxbUnmarshallerUtil.getJAXBObject(Feed.class, fullXmlFileName);
			contentMessageList = feed.getProducts().getProductContentMessage();
		} catch (JAXBException e) {
			errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		}
		return contentMessageList;
	}

	public void receiveFileSftp() throws Exception {
		log.debug("Begin: receiveFileSftp()");
		try {
			this.sftpUtil.setSftpDir(this.PRODUCT_EXPORT_REMOTE_FOLDER);
			this.sftpUtil.receiveFileList(this.DATA_QUEUE_FOLDER, this.PRODUCT_EXPORT_FILE_PREFIX + "*.xml");
			log.debug("End: receiveFileSftp()");
		} catch (Exception e) {
			errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		}
	}

	public List<ContentMessage> getContentMessageList() {
		return this.contentMessageList;
	}

	public void setContentMessageList(List<ContentMessage> contentMessageList) {
		this.contentMessageList = contentMessageList;
	}
}

/*
 * Location: C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_productexport.jar Qualified Name:
 * com.pacsun.hingeto.productexport.process.ProductExportProcess JD-Core Version: 0.6.0
 */