package com.pacsun.hingeto.listingexport.process;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.hingeto.api.Feed;
import com.pacsun.hingeto.exception.InvalidXmlException;
import com.pacsun.hingeto.exception.SFTPException;
import com.pacsun.hingeto.listingexport.dao.InventoryDao;
import com.pacsun.hingeto.listingresponseimport.builder.ListingResponseBuilder;
import com.pacsun.hingeto.process.ListingProcess;
import com.pacsun.util.DateFormatterUtil;
import com.pacsun.util.FileUtils;
import com.pacsun.util.JAXBMarshallerUtil;
import com.pacsun.util.StackTrace;

public class ListingResponseImportProcess extends ListingProcess {
	private Feed feed;

	@Autowired
	private ListingResponseBuilder listingResponseBuilder;

	@Autowired
	private InventoryDao expandedAssortmentInventoryDao;

	@Autowired
	private JAXBMarshallerUtil jaxbMarshallerUtil;

	@Value("${listingresponse.file.queue.folder}")
	private String QUEUE_FOLDER;

	@Value("${listingresponse.file.processed.folder}")
	private String PROCESSED_FOLDER;

	@Value("${listingresponse.file.failed.folder}")
	private String FAILED_FOLDER;

	@Value("${listingresponse.file.prefix}")
	private String LISTING_RESPONSE_FILE_PREFIX;

	@Value("${sftp.user}")
	protected String SFTP_USER;

	@Value("${sftp.key.location}")
	private String SFTP_KEY_LOCATION;

	@Value("${sftp.listingresponse.remote.folder}")
	private String SFTP_LISTING_RESPONSE_REMOTE_FOLDER;
	private static final Logger log = Logger.getLogger(ListingResponseImportProcess.class);

	public void start() throws Exception {
		log.info("Hingeto listing response import process has started.");
		String xmlFileName = null;
		try {
			sendFileSftp(this.QUEUE_FOLDER);
			this.feed = this.listingResponseBuilder.build();
			if (this.feed != null) {
				xmlFileName = formatFileName();
				File xmlFile = createXmlFile(this.feed, xmlFileName);
				if (validXml(xmlFile)) {
					log.info("Listing response import file " + xmlFileName + " was created.");
					if (sendCurrentFileSftp(xmlFileName)) {
						moveFile(xmlFileName, this.QUEUE_FOLDER, this.PROCESSED_FOLDER);
						log.info(xmlFileName + " was successfully sent to Hingeto via FTP and moved to the processed folder.");
					} else {
						log.error("FTP process for file " + xmlFileName + " has failed and the xml file moved to failed folder.");
						moveFile(xmlFileName, this.QUEUE_FOLDER, this.FAILED_FOLDER);
						throw new SFTPException("SFTP Process error.");
					}
				} else {
					moveFile(xmlFileName, this.QUEUE_FOLDER, this.FAILED_FOLDER);
					throw new InvalidXmlException("Generated listing response import xml file is invalid.");
				}
			} else {
				log.info("No listing response import records found at this time.");
			}
		} catch (InvalidXmlException e) {
			log.error(getClass().getName() + ": Error found in xml file " + xmlFileName);
			throw new InvalidXmlException("Generated listing response import xml file is invalid.");
		}
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
		log.debug("File " + xmlFile.getPath() + " was created.");
		log.debug("End createXmlFile()");
		return xmlFile;
	}

	private void sendFileSftp(String folderPath) throws Exception {
		File[] fileList = FileUtils.listFiles(folderPath, this.LISTING_RESPONSE_FILE_PREFIX, "xml");
		for (File file : fileList) {
			String xmlFileName = file.getName();
			try {
				if (validXml(file)) {
					if (sendCurrentFileSftp(xmlFileName)) {
						moveFile(xmlFileName, this.QUEUE_FOLDER, this.PROCESSED_FOLDER);
						log.info(xmlFileName + " was successfully sent to Hingeto via FTP and moved to the processed folder.");
					} else {
						log.error("FTP process for file " + xmlFileName + " has failed and the xml file moved to failed folder.");
						moveFile(xmlFileName, this.QUEUE_FOLDER, this.FAILED_FOLDER);
					}
				} else {
					moveFile(xmlFileName, this.QUEUE_FOLDER, this.FAILED_FOLDER);
					throw new InvalidXmlException("Generated listing response import xml file is invalid.");
				}
			} catch (Exception e) {
				errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
				log.error(errorMessage);
				throw new Exception(errorMessage);
			}
		}
	}

	public boolean sendCurrentFileSftp(String xmlFileName) throws Exception {
		log.debug("Begin sendCurrentFileSftp()");
		List fileList = new ArrayList();
		fileList.add(new File(this.QUEUE_FOLDER + xmlFileName));
		try {
			this.sftpUtil.setSftpDir(this.SFTP_LISTING_RESPONSE_REMOTE_FOLDER);
			this.sftpUtil.send(fileList);
		} catch (Exception e) {
			errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		}
		log.debug("End sendCurrentFileSftp()");
		return true;
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
		return this.LISTING_RESPONSE_FILE_PREFIX + DateFormatterUtil.getDateTimeStamp() + ".xml";
	}
}

/*
 * Location: C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_listingexport.jar Qualified Name:
 * com.pacsun.hingeto.listingexport.process.ListingResponseImportProcess JD-Core Version: 0.6.0
 */