package com.pacsun.hingeto.listingexport.process;

import com.hingeto.api.CatalogProductReference;
import com.hingeto.api.Feed;
import com.hingeto.api.InventoryData;
import com.hingeto.api.ListingIDType;
import com.hingeto.api.ListingList;
import com.hingeto.api.ListingMessage;
import com.hingeto.api.ListingSource;
import com.pacsun.hingeto.exception.InvalidXmlException;
import com.pacsun.hingeto.listingexport.dao.InventoryDao;
import com.pacsun.hingeto.listingexport.dto.InventoryDto;
import com.pacsun.hingeto.process.ListingProcess;
import com.pacsun.util.EncodingUtil;
import com.pacsun.util.FileUtils;
import com.pacsun.util.JAXBUnmarshallerUtil;
import com.pacsun.util.SftpUtil;
import com.pacsun.util.StackTrace;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class ListingExportProcess extends ListingProcess
{

  @Autowired
  InventoryDao inventoryDao;

  @Value("${listingexport.file.queue.folder}")
  private String QUEUE_FOLDER;

  @Value("${listingexport.file.processed.folder}")
  private String PROCESSED_FOLDER;

  @Value("${listingexport.file.failed.folder}")
  private String FAILED_FOLDER;

  @Value("${listingexport.file.prefix}")
  private String LISTING_EXPORT_FILE_PREFIX;

  @Value("${sftp.user}")
  private String SFTP_USER;

  @Value("${sftp.password.encoded}")
  private String SFTP_PASSWORD_ENCODED;

  @Value("${sftp.listingexport.remote.folder}")
  private String LISTING_EXPORT_REMOTE_FOLDER;
  List<ListingMessage> listingMessageList;
  private static final Logger log = Logger.getLogger(ListingExportProcess.class);

  public void start() throws Exception
  {
    log.info("Hingeto listing export process has started.");

    File[] files = downloadFiles();

    if (files.length == 0)
      log.info("No hingeto listing export xml files to retrieve at this time.");
    else {
      processFiles(files);
    }
    log.info("Hingeto listing export process has completed successfully.");
  }

  public void processFiles(File[] files)
    throws Exception
  {
    FileUtils.sortFiles(files);
    boolean latest = true;

    for (File file : files)
    {
      if (latest) {
        latest = false;
        if (validXml(file)) {
          setListingMessageList(unMarshalListingExportXmlFile(file.getPath()));
          try {
            updateInventory(file.getName());
          } catch (Exception e) {
            moveFile(file.getName(), this.QUEUE_FOLDER, this.FAILED_FOLDER);
            throw new Exception(e);
          }
        } else {
          log.error("Validation error in file:" + file.getPath());
          moveFile(file.getName(), this.QUEUE_FOLDER, this.FAILED_FOLDER);
          throw new InvalidXmlException("Schema validation failed. ListingExport file is invalid.");
        }
      }
      moveFile(file.getName(), this.QUEUE_FOLDER, this.PROCESSED_FOLDER);
    }
  }

  public File[] downloadFiles() throws Exception
  {
    try {
      receiveFileSftp();
    } catch (Exception e) {
      errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
      log.error(errorMessage);
      throw new Exception(errorMessage);
    }

    return getQueuedFiles(this.QUEUE_FOLDER, this.LISTING_EXPORT_FILE_PREFIX, ".xml");
  }

  public void updateInventory(String xmlFileName) throws Exception {
    try {
      List inventoryDtoList = new ArrayList();
      for (ListingMessage listingMessage : this.listingMessageList) {
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setMessageId(listingMessage.getMessageID().trim());
        inventoryDto.setUpc(listingMessage.getProductReference().getProductSKU().trim());
        inventoryDto.setStoreFrontProductId(listingMessage.getProductReference().getStorefrontProductID().trim());
        inventoryDto.setQuantity(listingMessage.getInventoryData().getQuantity().intValue());
        inventoryDto.setEffectiveSupplierId(listingMessage.getListingSource().getListingID().getEffectiveSupplierID().trim());
        inventoryDto.setIdentifier(listingMessage.getListingSource().getListingID().getIdentifier().trim());

        inventoryDtoList.add(inventoryDto);
      }
      if (inventoryDtoList.size() > 0) {
        this.inventoryDao.deleteAll();
        this.inventoryDao.insertBatch(inventoryDtoList, xmlFileName);
      }
    } catch (Exception e) {
      errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
      log.error(errorMessage);
      throw new Exception(errorMessage);
    }
  }

  public List<ListingMessage> unMarshalListingExportXmlFile(String fullXmlFileName) throws Exception
  {
    JAXBUnmarshallerUtil jaxbUnmarshallerUtil = new JAXBUnmarshallerUtil();
    List listingMessageList = null;
    try {
      Feed feed = (Feed)jaxbUnmarshallerUtil.getJAXBObject(Feed.class, fullXmlFileName);
      listingMessageList = feed.getListings().getListing();
    }
    catch (JAXBException e) {
      errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
      log.error(errorMessage);
      throw new Exception(errorMessage);
    }
    return listingMessageList;
  }

  public void receiveFileSftp() throws Exception
  {
    log.debug("Begin: receiveFileSftp()");
    try {
      this.sftpUtil.setSftpDir(this.LISTING_EXPORT_REMOTE_FOLDER);
      this.sftpUtil.setSftpPassword(EncodingUtil.decode(this.SFTP_PASSWORD_ENCODED));
      this.sftpUtil.receiveFileList(this.QUEUE_FOLDER, this.LISTING_EXPORT_FILE_PREFIX + "*.xml");
      log.debug("End: receiveFileSftp()");
    } catch (Exception e) {
      errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
      log.error(errorMessage);
      throw new Exception(errorMessage);
    }
  }

  public List<ListingMessage> getListingMessageList() {
    return this.listingMessageList;
  }

  public void setListingMessageList(List<ListingMessage> listingMessageList) {
    this.listingMessageList = listingMessageList;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_listingexport.jar
 * Qualified Name:     com.pacsun.hingeto.listingexport.process.ListingExportProcess
 * JD-Core Version:    0.6.0
 */