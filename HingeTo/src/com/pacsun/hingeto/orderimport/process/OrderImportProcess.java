package com.pacsun.hingeto.orderimport.process;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.hingeto.api.Feed;
import com.pacsun.hingeto.exception.InvalidXmlException;
import com.pacsun.hingeto.orderimport.builder.OrderMessageListBuilder;
import com.pacsun.hingeto.orderimport.dao.OrderHeaderDao;
import com.pacsun.hingeto.orderimport.dto.OrderHeaderDto;
import com.pacsun.hingeto.process.FileProcess;
import com.pacsun.util.DateFormatterUtil;
import com.pacsun.util.EncodingUtil;
import com.pacsun.util.FileUtils;
import com.pacsun.util.JAXBMarshallerUtil;
import com.pacsun.util.StackTrace;

public class OrderImportProcess extends FileProcess {
	private Feed feed;

	@Autowired
	private OrderMessageListBuilder orderMessageListBuilder;

	@Autowired
	private OrderHeaderDao orderHeaderDao;

	@Autowired
	private JAXBMarshallerUtil jaxbMarshallerUtil;

	@Value("${sftp.user}")
	protected String SFTP_USER;

	@Value("${sftp.password.encoded}")
	private String SFTP_PASSWORD_ENCODED;

	@Value("${orderimport.file.queue.folder}")
	private String QUEUE_FOLDER;

	@Value("${orderimport.file.processed.folder}")
	private String PROCESSED_FOLDER;

	@Value("${orderimport.file.failed.folder}")
	private String FAILED_FOLDER;

	@Value("${orderimport.file.prefix}")
	private String ORDER_IMPORT_FILE_PREFIX;

	@Value("${sftp.orderimport.remote.folder}")
	private String SFTP_ORDER_IMPORT_REMOTE_FOLDER;
	private static final Logger log = Logger.getLogger(OrderImportProcess.class);

	public void start() throws Exception {
		log.info("Hingeto order import process has started.");

		String xmlFileName = null;
		try {
			validateAndSendAllQueuedFilesSftp(this.QUEUE_FOLDER);
			this.feed = this.orderMessageListBuilder.build();
			if (this.feed != null) {
				xmlFileName = formatFileName();
				File xmlFile = createXmlFile(this.feed, xmlFileName);
				validateXml(xmlFile);
				log.info("Order import file " + xmlFileName + " was created.");
				updateOrderHeaderForProcessedOrders(this.orderMessageListBuilder.getOrderHeaderDtoList());
				this.sftpUtil.setSftpDir(this.SFTP_ORDER_IMPORT_REMOTE_FOLDER);
				this.sftpUtil.setSftpPassword(EncodingUtil.decode(this.SFTP_PASSWORD_ENCODED));
				this.sftpUtil.sendFile(new File(this.QUEUE_FOLDER + xmlFileName));
				moveFile(xmlFileName, this.QUEUE_FOLDER, this.PROCESSED_FOLDER);
				log.info(xmlFileName + " was successfully sent to Hingeto and moved to the processed folder.");
			} else {
				log.info("No oreders found to import at this time.");
			}
		} catch (InvalidXmlException e) {
			moveFile(xmlFileName, this.QUEUE_FOLDER, this.FAILED_FOLDER);
			log.error(getClass().getName() + ": Error found in xml file " + xmlFileName);
			throw new InvalidXmlException("Generated order import xml file is invalid.");
		}

		log.info("Hingeto order import process has completed successfully.");
	}

	public File createXmlFile(Feed feed, String xmlFileName) throws Exception {
		log.debug("Begin createXmlFile()");
		try {
			this.xmlString = generateOrderXml(feed);
		} catch (Exception e) {
			errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		}
		File xmlFile = FileUtils.writeFile(xmlFileName, this.QUEUE_FOLDER, this.xmlString, true);
		log.debug("End createXmlFile()");
		return xmlFile;
	}

	private void validateAndSendAllQueuedFilesSftp(String folderPath) throws Exception {
		String xmlFileName = null;
		try {
			File[] fileList = FileUtils.listFiles(folderPath, this.ORDER_IMPORT_FILE_PREFIX, "xml");
			for (File file : fileList) {
				xmlFileName = file.getName();
				validateXml(file);

				this.sftpUtil.setSftpDir(this.SFTP_ORDER_IMPORT_REMOTE_FOLDER);
				this.sftpUtil.setSftpPassword(EncodingUtil.decode(this.SFTP_PASSWORD_ENCODED));
				this.sftpUtil.sendFile(file);
				moveFile(xmlFileName, this.QUEUE_FOLDER, this.PROCESSED_FOLDER);
				log.info(xmlFileName + " was successfully sent to Hingeto via FTP and moved to the processed folder.");
			}
		} catch (Exception e) {
			errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			moveFile(xmlFileName, this.QUEUE_FOLDER, this.FAILED_FOLDER);
			throw new Exception(errorMessage);
		}
	}

	public void updateOrderHeaderForProcessedOrders(List<OrderHeaderDto> orderHeaderDtoList) throws Exception {
		try {
			this.orderHeaderDao.updateProcessedBatch(orderHeaderDtoList);
		} catch (Exception e) {
			errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		}
	}

	public String generateOrderXml(Feed feed) throws Exception {
		try {
			return this.jaxbMarshallerUtil.getXMLString(Feed.class, feed);
		} catch (JAXBException e) {
			log.error(getClass().getName() + " error occurred in marshalling order message: " + StackTrace.getStackTrace(e));
			throw new Exception(e);
		} catch (Exception e) {
			log.error(StackTrace.getStackTrace(e));
			throw new Exception(e);
		}
	}

	private String formatFileName() {
		return this.ORDER_IMPORT_FILE_PREFIX + DateFormatterUtil.getDateTimeStamp() + ".xml";
	}
}

/*
 * Location: C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderimport.jar Qualified Name:
 * com.pacsun.hingeto.orderimport.process.OrderImportProcess JD-Core Version: 0.6.0
 */