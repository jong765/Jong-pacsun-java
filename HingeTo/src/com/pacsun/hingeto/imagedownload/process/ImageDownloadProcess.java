package com.pacsun.hingeto.imagedownload.process;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.hingeto.api.CategoryAssignment;
import com.hingeto.api.CategoryAssignmentData;
import com.hingeto.api.ContentMessage;
import com.hingeto.api.Feed;
import com.hingeto.api.ImageURL;
import com.hingeto.api.ProductAttribute;
import com.hingeto.api.ProductContentType;
import com.hingeto.api.ProductData;
import com.pacsun.constants.EmailConstants;
import com.pacsun.hingeto.dao.SecurityDao;
import com.pacsun.hingeto.exception.InvalidXmlException;
import com.pacsun.hingeto.imagedownload.dto.ImageDto;
import com.pacsun.hingeto.process.ListingProcess;
import com.pacsun.util.HtmlEmail;
import com.pacsun.util.JAXBUnmarshallerUtil;
import com.pacsun.util.SftpUtil;
import com.pacsun.util.StackTrace;

public class ImageDownloadProcess extends ListingProcess implements EmailConstants {

	@Autowired
	SecurityDao securityDao;

	@Autowired
	protected SftpUtil imageSftpUtil;

	@Autowired
	protected HtmlEmail htmlEmail;

	@Value("${image.sftp.user}")
	protected String IMAGE_SFTP_USER;

	@Value("${productexport.imagefile.xml.queue.folder}")
	private String XML_QUEUE_FOLDER;

	@Value("${productexport.imagefile.xml.processed.folder}")
	private String XML_PROCESSED_FOLDER;

	@Value("${hingeto.host.name}")
	private String IMAGE_HOST_NAME;

	@Value("${productexport.imagefile.image.queue.folder}")
	private String IMAGE_QUEUE_FOLDER;

	@Value("${productexport.imagefile.image.processed.folder}")
	private String IMAGE_PROCESSED_FOLDER;

	@Value("${productexport.imagefile.xml.failed.folder}")
	private String XML_FAILED_FOLDER;

	@Value("${image.sftp.productexport.remote.folder}")
	private String IMAGE_REMOTE_FOLDER;

	@Value("${productexport.datafile.prefix}")
	private String PRODUCT_EXPORT_FILE_PREFIX;

	@Value("${email.recipients}")
	private String EMAIL_RECIPIENTS_VALUE;

	@Value("${smtp.host}")
	private String SMTP_HOST;

	@Value("${email.subject}")
	private String EMAIL_SUBJECT;

	@Value("${smtp.user}")
	private String SMTP_USER;

	@Value("${smtp.password}")
	private String SMTP_PASSWORD;

	@Value("${mail.smtp.auth}")
	private String SMTP_AUTH;

	@Value("${log4j.appender.imagedownload.File}")
	private String LOG_FILE;
	private List<ContentMessage> contentMessageList;
	private List<ImageDto> imageDtoList = new ArrayList();

	private HashMap<String, String> propMap = new HashMap();

	private static final Logger log = Logger.getLogger(ImageDownloadProcess.class);

	public void start() throws Exception {
		log.info("Hingeto product image download process has started.");

		File[] files = getXmlFilesToProcess();

		if (files.length == 0) {
			log.info("No hingeto image files to download at this time.");
		}
		for (File file : files) {
			if (validXml(file)) {
				setContentMessageList(unMarshalListingExportXmlFile(file.getPath()));
				try {
					loadImageDtoList(file.getName());
					moveFile(file.getName(), this.XML_QUEUE_FOLDER, this.XML_PROCESSED_FOLDER);
				} catch (Exception e) {
					moveFile(file.getName(), this.XML_QUEUE_FOLDER, this.XML_FAILED_FOLDER);
					throw new Exception(e);
				}
			} else {
				log.error("Validation error in file:" + file.getPath());
				moveFile(file.getName(), this.XML_QUEUE_FOLDER, this.XML_FAILED_FOLDER);
				throw new InvalidXmlException("Schema validation failed. Product export file for image download is invalid.");
			}
		}

		downloadImages();

		ftpImageFiles();

		log.info("Hingeto product image download process has completed successfully.");
	}

	public void downloadImages() throws Exception {
		ImageDownloader downloader1 = null;
		ImageDownloader downloader2 = null;
		ImageDownloader downloader3 = null;
		ImageDownloader downloader4 = null;
		ImageDownloader downloader5 = null;
		int listSize = this.imageDtoList.size();

		if (listSize == 0)
			return;
		if (listSize < 5) {
			downloader1 = new ImageDownloader(this.imageDtoList, this.IMAGE_HOST_NAME);
		} else {
			int increment = listSize / 5;
			int toIndex1 = increment;
			int toIndex2 = increment * 2;
			int toIndex3 = increment * 3;
			int toIndex4 = increment * 4;
			int toIndex5 = listSize;

			List imageDtoList1 = this.imageDtoList.subList(0, toIndex1);
			downloader1 = new ImageDownloader(imageDtoList1, this.IMAGE_HOST_NAME);

			List imageDtoList2 = this.imageDtoList.subList(toIndex1, toIndex2);
			downloader2 = new ImageDownloader(imageDtoList2, this.IMAGE_HOST_NAME);

			List imageDtoList3 = this.imageDtoList.subList(toIndex2, toIndex3);
			downloader3 = new ImageDownloader(imageDtoList3, this.IMAGE_HOST_NAME);

			List imageDtoList4 = this.imageDtoList.subList(toIndex3, toIndex4);
			downloader4 = new ImageDownloader(imageDtoList4, this.IMAGE_HOST_NAME);

			List imageDtoList5 = this.imageDtoList.subList(toIndex4, toIndex5);
			downloader5 = new ImageDownloader(imageDtoList5, this.IMAGE_HOST_NAME);
		}
		try {
			do {
				do
					Thread.sleep(3000L);
				while (((downloader1 != null) && (downloader1.t.isAlive())) || ((downloader2 != null) && (downloader2.t.isAlive()))
						|| ((downloader3 != null) && (downloader3.t.isAlive())) || ((downloader4 != null) && (downloader4.t.isAlive())));
				if (downloader5 == null)
					break;
			} while (downloader5.t.isAlive());
		} catch (Exception e) {
			errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		}

		if (((downloader1 != null) && (downloader1.isDownloadError())) || ((downloader2 != null) && (downloader2.isDownloadError()))
				|| ((downloader3 != null) && (downloader3.isDownloadError())) || ((downloader4 != null) && (downloader4.isDownloadError()))
				|| ((downloader5 != null) && (downloader5.isDownloadError()))) {
			String content = "<HTML><P><B>Unable to download some product image files from hingeto.</B> For specific error description, Please check the IFS log:</P>";
			content = content + "<P>" + this.LOG_FILE + "</P></HTML>";

			this.propMap.put("email.recipients", this.EMAIL_RECIPIENTS_VALUE);
			sendErrorEmail(this.EMAIL_SUBJECT, this.SMTP_HOST, this.SMTP_USER, this.SMTP_PASSWORD, this.SMTP_AUTH, content, this.propMap);
		}
	}

	public void sendErrorEmail(String subject, String smtpHost, String smtpUser, String smtpPassword, String smtpAuth, String content,
			HashMap<String, String> propMap) {
		System.out.println("Sending error email...");
		this.htmlEmail.setEmailSubject(subject);
		this.htmlEmail.setPropMap(propMap);
		this.htmlEmail.setAddressTo();
		this.htmlEmail.setSmtpHost(smtpHost);
		this.htmlEmail.setSmtpUser(smtpUser);
		this.htmlEmail.setSmtpPassword(smtpPassword);
		this.htmlEmail.setMailSmtpAuth(smtpAuth);
		this.htmlEmail.setContent(content);
		this.htmlEmail.sendEmail();
	}

	public void ftpImageFiles() throws Exception {
		try {
			this.imageSftpUtil.setSftpDir(this.IMAGE_REMOTE_FOLDER);
			this.imageSftpUtil.setSftpPassword(this.securityDao.getSftpPassword(this.IMAGE_SFTP_USER));
			List<File> imageFileList = getImageFileList();
			for (File imageFile : imageFileList) {
				this.imageSftpUtil.sendFile(imageFile);
				FileUtils.deleteQuietly(imageFile);
			}
		} catch (Exception e) {
			errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		}
	}

	public List<File> getImageFileList() {
		File[] fileArray = getQueuedFiles(this.IMAGE_QUEUE_FOLDER, "", null);
		return Arrays.asList(fileArray);
	}

	public File[] getXmlFilesToProcess() throws Exception {
		return getQueuedFiles(this.XML_QUEUE_FOLDER, this.PRODUCT_EXPORT_FILE_PREFIX, ".xml");
	}

	public void loadImageDtoList(String xmlFileName) throws Exception {
		try {
			for (ContentMessage contentMessage : this.contentMessageList) {
				ProductContentType productContentType = contentMessage.getProductContent();
				ProductData productData = productContentType.getProductData();
				CategoryAssignmentData categoryAssignmentData = productContentType.getCategoryAssignmentData();
				List productAttributeList = productData.getAttribute();

				int classz = 0;
				int vendor = 0;
				int style = 0;
				int color = 0;

				classz = Integer.parseInt(((CategoryAssignment) categoryAssignmentData.getCategoryAssignment().get(0)).getCategoryID());

				Iterator productAttributeIterator = productAttributeList.iterator();

				while (productAttributeIterator.hasNext()) {
					ProductAttribute productAttribute = (ProductAttribute) productAttributeIterator.next();
					String name = productAttribute.getName();

					if (name.equalsIgnoreCase("Vendor"))
						vendor = Integer.parseInt(productAttribute.getValue());
					else if (name.equalsIgnoreCase("Style"))
						style = Integer.parseInt(productAttribute.getValue());
					else if (name.equalsIgnoreCase("Color")) {
						color = Integer.parseInt(productAttribute.getValue());
					}

				}

				Iterator imageUrlIterator = productContentType.getImageURLData().getImageURL().iterator();
				while (imageUrlIterator.hasNext()) {
					ImageURL imageUrl = (ImageURL) imageUrlIterator.next();
					String url = imageUrl.getValue().split("\\?")[0];
					String destinationFile = getDestinationFile(url, classz, vendor, style, color);
					ImageDto imageDto = new ImageDto();
					imageDto.setUrl(url);
					imageDto.setDestinationFileName(destinationFile);
					this.imageDtoList.add(imageDto);
				}
			}
		} catch (Exception e) {
			errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		}
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

	public String getDestinationFile(String url, int classz, int vendor, int style, int color) {
		String fileName = FilenameUtils.getBaseName(url).trim();
		String view = "";

		if (Pattern.matches(".*[^-].", fileName))
			view = "F";
		else if (Pattern.matches(".*-1", fileName))
			view = "B";
		else {
			view = fileName.substring(fileName.indexOf("-") + 1);
		}

		return this.IMAGE_QUEUE_FOLDER + String.format("%04d", new Object[] { Integer.valueOf(classz) })
				+ String.format("%05d", new Object[] { Integer.valueOf(vendor) })
				+ String.format("%04d", new Object[] { Integer.valueOf(style) }) + "NEW-"
				+ String.format("%03d", new Object[] { Integer.valueOf(color) }) + "-" + view + "."
				+ FilenameUtils.getExtension(url).trim();
	}

	public List<ContentMessage> getContentMessageList() {
		return this.contentMessageList;
	}

	public void setContentMessageList(List<ContentMessage> contentMessageList) {
		this.contentMessageList = contentMessageList;
	}
}

/*
 * Location: C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_imagedownload.jar Qualified Name:
 * com.pacsun.hingeto.imagedownload.process.ImageDownloadProcess JD-Core Version: 0.6.0
 */