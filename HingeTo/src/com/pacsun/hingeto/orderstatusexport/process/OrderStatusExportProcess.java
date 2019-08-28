package com.pacsun.hingeto.orderstatusexport.process;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.hingeto.api.CancellationItem;
import com.hingeto.api.Feed;
import com.hingeto.api.FulfillmentItem;
import com.hingeto.api.OrderAttribute;
import com.hingeto.api.OrderCancellation;
import com.hingeto.api.OrderFulfillment;
import com.hingeto.api.OrderState;
import com.hingeto.api.OrderStatusMessage;
import com.hingeto.api.StateItem;
import com.pacsun.hingeto.exception.InvalidXmlException;
import com.pacsun.hingeto.orderstatusexport.dao.CancelTransactionDao;
import com.pacsun.hingeto.orderstatusexport.dao.ShippingTransactionDao;
import com.pacsun.hingeto.orderstatusexport.dto.CancelTransactionDto;
import com.pacsun.hingeto.orderstatusexport.dto.CancellationItemDto;
import com.pacsun.hingeto.orderstatusexport.dto.FulfillmentItemDto;
import com.pacsun.hingeto.orderstatusexport.dto.OrderStatusAttributeDto;
import com.pacsun.hingeto.orderstatusexport.dto.ShippingTransactionDto;
import com.pacsun.hingeto.process.FileProcess;
import com.pacsun.util.DateUtil;
import com.pacsun.util.EncodingUtil;
import com.pacsun.util.JAXBUnmarshallerUtil;
import com.pacsun.util.StackTrace;

public class OrderStatusExportProcess extends FileProcess {

	@Autowired
	private CancelTransactionDao cancelTransactionDao;

	@Autowired
	private ShippingTransactionDao shippingTransactionDao;

	@Value("${sftp.user}")
	protected String SFTP_USER;

	@Value("${sftp.password.encoded}")
	private String SFTP_PASSWORD_ENCODED;

	@Value("${orderstatusexport.file.queue.folder}")
	protected String QUEUE_FOLDER;

	@Value("${orderstatusexport.file.processed.folder}")
	protected String PROCESSED_FOLDER;

	@Value("${orderstatusexport.file.failed.folder}")
	protected String FAILED_FOLDER;

	@Value("${orderfulfillments.file.prefix}")
	private String ORDER_FULFILLMENTS_FILE_PREFIX;

	@Value("${ordercancellation.file.prefix}")
	private String ORDER_CANCELLATION_FILE_PREFIX;

	@Value("${orderstatus.file.prefix}")
	private String ORDER_STATUS_FILE_PREFIX;

	@Value("${sftp.orderstatusexport.remote.folder}")
	private String ORDER_STATUS_EXPORT_REMOTE_FOLDER;

	@Value("${file.move.retrial.attempt}")
	private String RETRIAL_ATTEMPT;

	@Value("${file.move.retrial.interval}")
	private String RETRIAL_INTERVAL;
	private List<OrderStatusMessage> orderStatusMessageList;
	private List<ShippingTransactionDto> shippingTransactionDtoList;
	private List<CancelTransactionDto> cancelTransactionDtoList;
	private String messageID = "";
	private int orderID = 0;

	private static final Logger log = Logger.getLogger(OrderStatusExportProcess.class);

	public void start() throws Exception {
		log.info("Hingeto order status update process has started.");

		File[] files = getFilesToProcess();
		if (files.length > 0) {
			for (File file : files)
				try {
					validateXml(file);
					setOrderStatusMessageList(unMarshalOrderStatusXmlFile(file.getPath()));
					updateOrderStatus(file.getName());
					moveFile(file.getName(), this.QUEUE_FOLDER, this.PROCESSED_FOLDER);
				} catch (Exception e) {
					log.error("Validation error in file:" + file.getPath());
					moveFile(file.getName(), this.QUEUE_FOLDER, this.FAILED_FOLDER);
					throw new InvalidXmlException("Schema validation failed. OrderStatusExport file is invalid.");
				}
		} else {
			log.info("There were no files to process.");
		}

		log.info("Hingeto order status update process has completed successfully.");
	}

	public File[] getFilesToProcess() throws Exception {
		try {
			receiveFileSftp();
		} catch (Exception e) {
			errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		}

		File[] fileArray1 = getQueuedFiles(this.QUEUE_FOLDER, this.ORDER_FULFILLMENTS_FILE_PREFIX, ".xml");
		File[] fileArray2 = getQueuedFiles(this.QUEUE_FOLDER, this.ORDER_CANCELLATION_FILE_PREFIX, ".xml");
		File[] fileArray3 = getQueuedFiles(this.QUEUE_FOLDER, this.ORDER_STATUS_FILE_PREFIX, ".xml");
		return (File[]) ArrayUtils.addAll((File[]) ArrayUtils.addAll(fileArray1, fileArray2), fileArray3);
	}

	public void updateOrderStatus(String xmlFileName) throws Exception {
		try {
			this.shippingTransactionDtoList = new ArrayList<ShippingTransactionDto>();
			this.cancelTransactionDtoList = new ArrayList<CancelTransactionDto>();
			for (OrderStatusMessage orderStatusMessage : this.orderStatusMessageList) {
				OrderFulfillment orderFulfillment = orderStatusMessage.getOrderFulfillment();
				OrderCancellation orderCancellation = orderStatusMessage.getOrderCancellation();
				OrderState orderState = orderStatusMessage.getOrderState();

				if (orderStatusMessage.getMessageID() != null)
					this.messageID = orderStatusMessage.getMessageID();
				else {
					this.messageID = "";
				}

				this.orderID = Integer.parseInt(orderStatusMessage.getOrderID());
				java.sql.Date statusUpdateDate = new java.sql.Date(DateUtil.xmlGregorianCalendarToDate(
						orderStatusMessage.getStatusUpdateDate()).getTime());
				if (orderFulfillment != null) {
					ShippingTransactionDto transactionDto = new ShippingTransactionDto();
					transactionDto.setMessageID(this.messageID);
					transactionDto.setOrderID(this.orderID);
					transactionDto.setStatusUpdateDate(statusUpdateDate);
					transactionDto.setCarrierCode(orderFulfillment.getCarrierCode());
					transactionDto.setCarrierName(orderFulfillment.getCarrierName());
					transactionDto.setShippingMethod(orderFulfillment.getShippingMethod());
					transactionDto.setTrackingNumber(orderFulfillment.getTrackingNumber());
					transactionDto.setOrderFeedFileName(xmlFileName);
					List<FulfillmentItem> fulfillmentItemList = orderFulfillment.getFulfillmentItem();
					List<FulfillmentItemDto> fulfillmentItemDtoList = new ArrayList<FulfillmentItemDto>();
					for (FulfillmentItem fulfillmentItem : fulfillmentItemList) {
						FulfillmentItemDto fulfillmentItemDto = new FulfillmentItemDto();
						fulfillmentItemDto.setEffectiveSupplierID(fulfillmentItem.getListingID().getEffectiveSupplierID());
						fulfillmentItemDto.setFulfilledQty(new BigDecimal(fulfillmentItem.getQuantity()).intValue());
						fulfillmentItemDto.setLineItemId(fulfillmentItem.getStoreFrontLineItemID());
						fulfillmentItemDto.setIdentifier(fulfillmentItem.getListingID().getIdentifier());
						fulfillmentItemDto.setOrderItemCode(fulfillmentItem.getOrderItemCode());
						fulfillmentItemDtoList.add(fulfillmentItemDto);
					}
					transactionDto.setFulfillmentItemDtoList(fulfillmentItemDtoList);
					this.shippingTransactionDtoList.add(transactionDto);
				} else if (orderCancellation != null) {
					CancelTransactionDto transactionDto = new CancelTransactionDto();
					transactionDto.setMessageID(this.messageID);
					transactionDto.setOrderID(this.orderID);
					transactionDto.setStatusUpdateDate(statusUpdateDate);
					transactionDto.setOrderFeedFileName(xmlFileName);
					if (orderStatusMessage.getOrderStatusAttributes() != null) {
						List<OrderStatusAttributeDto> orderStatusAttributeDtoList = new ArrayList<OrderStatusAttributeDto>();
						List<OrderAttribute> orderAttribueList = orderStatusMessage.getOrderStatusAttributes().getOrderAttribute();
						for (OrderAttribute orderAttribute : orderAttribueList) {
							OrderStatusAttributeDto orderStatusAttributeDto = new OrderStatusAttributeDto();
							orderStatusAttributeDto.setOrderAttributeName(orderAttribute.getName());
							orderStatusAttributeDto.setOrderAttributeValue(orderAttribute.getValue());
							orderStatusAttributeDtoList.add(orderStatusAttributeDto);
						}
						transactionDto.setOrderStatusAttributeDtoList(orderStatusAttributeDtoList);
					} else {
						transactionDto.setOrderStatusAttributeDtoList(null);
					}
					List<CancellationItem> cancellationItemList = orderCancellation.getCancellationItem();
					List<CancellationItemDto> cancellationItemDtoList = new ArrayList<CancellationItemDto>();
					for (CancellationItem cancellationItem : cancellationItemList) {
						CancellationItemDto cancellationItemDto = new CancellationItemDto();
						cancellationItemDto.setCancelReason(cancellationItem.getCancelReason());
						cancellationItemDto.setEffectiveSupplierID(cancellationItem.getListingID().getEffectiveSupplierID());
						cancellationItemDto.setLineItemId(cancellationItem.getStoreFrontLineItemID());
						cancellationItemDto.setOrderItemCode(cancellationItem.getOrderItemCode());
						cancellationItemDto.setIdentifier(cancellationItem.getListingID().getIdentifier());
						cancellationItemDtoList.add(cancellationItemDto);
					}
					transactionDto.setCancellationItemDtoList(cancellationItemDtoList);
					this.cancelTransactionDtoList.add(transactionDto);
				} else if (orderState != null) {
					CancelTransactionDto transactionDto = new CancelTransactionDto();
					transactionDto.setMessageID(this.messageID);
					transactionDto.setOrderID(this.orderID);
					transactionDto.setStatusUpdateDate(statusUpdateDate);
					transactionDto.setOrderFeedFileName(xmlFileName);
					List<StateItem> stateItemList = orderState.getStateItem();
					List<CancellationItemDto> cancellationItemDtoList = new ArrayList<CancellationItemDto>();
					for (StateItem stateItem : stateItemList) {
						if (stateItem.getState().equalsIgnoreCase("Canceled")) {
							CancellationItemDto cancellationItemDto = new CancellationItemDto();
							cancellationItemDto.setEffectiveSupplierID(stateItem.getListingID().getEffectiveSupplierID());
							cancellationItemDto.setOrderItemCode(stateItem.getOrderItemCode());
							cancellationItemDto.setIdentifier(stateItem.getListingID().getIdentifier());
							cancellationItemDtoList.add(cancellationItemDto);
						}
					}
					transactionDto.setCancellationItemDtoList(cancellationItemDtoList);
					this.cancelTransactionDtoList.add(transactionDto);
				}
			}

			if (this.shippingTransactionDtoList.size() > 0)
				writeShippingTransaction(this.shippingTransactionDtoList, xmlFileName);
			if (this.cancelTransactionDtoList.size() > 0)
				writeCancelTransaction(this.cancelTransactionDtoList, xmlFileName);
		} catch (Exception e) {
			errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		}
	}

	public void writeCancelTransaction(List<CancelTransactionDto> cancelTransactionDtoList, String xmlFileName) throws Exception {
		try {
			this.cancelTransactionDao.insertBatch(cancelTransactionDtoList, xmlFileName);
		} catch (Exception e) {
			errorMessage = getClass().getName() + " : " + "Error in processing xml file " + xmlFileName + "\n" + " OrderID=" + this.orderID
					+ ", MessageID=" + this.messageID + ".\n" + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		}
	}

	public void writeShippingTransaction(List<ShippingTransactionDto> shippingTransactionDtoList, String xmlFileName) throws Exception {
		try {
			this.shippingTransactionDao.insertBatch(shippingTransactionDtoList, xmlFileName);
		} catch (Exception e) {
			errorMessage = getClass().getName() + " : " + "Error in processing xml file " + xmlFileName + "\n" + " OrderID=" + this.orderID
					+ ", MessageID=" + this.messageID + ".\n" + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		}
	}

	public List<OrderStatusMessage> unMarshalOrderStatusXmlFile(String fullXmlFileName) throws Exception {
		JAXBUnmarshallerUtil jaxbUnmarshallerUtil = new JAXBUnmarshallerUtil();
		try {
			Feed feed = (Feed) jaxbUnmarshallerUtil.getJAXBObject(Feed.class, fullXmlFileName);
			this.orderStatusMessageList = feed.getOrderStatus().getOrderStatus();
		} catch (JAXBException e) {
			errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		}
		return this.orderStatusMessageList;
	}

	public void receiveFileSftp() throws Exception {
		log.debug("Begin: receiveFileSftp()");
		try {
			this.sftpUtil.setSftpDir(this.ORDER_STATUS_EXPORT_REMOTE_FOLDER);
			this.sftpUtil.setSftpPassword(EncodingUtil.decode(this.SFTP_PASSWORD_ENCODED));
			this.sftpUtil.receiveFiles(this.QUEUE_FOLDER, this.ORDER_FULFILLMENTS_FILE_PREFIX + "*.xml");
			this.sftpUtil.receiveFiles(this.QUEUE_FOLDER, this.ORDER_CANCELLATION_FILE_PREFIX + "*.xml");
			this.sftpUtil.receiveFiles(this.QUEUE_FOLDER, this.ORDER_STATUS_FILE_PREFIX + "*.xml");
			log.debug("End: receiveFileSftp()");
		} catch (Exception e) {
			errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		}
	}

	public List<OrderStatusMessage> getOrderStatusMessageList() {
		return this.orderStatusMessageList;
	}

	public void setOrderStatusMessageList(List<OrderStatusMessage> orderStatusMessageList) {
		this.orderStatusMessageList = orderStatusMessageList;
	}

	public List<ShippingTransactionDto> getShippingTransactionDtoList() {
		return this.shippingTransactionDtoList;
	}

	public void setShippingTransactionDtoList(List<ShippingTransactionDto> shippingTransactionDtoList) {
		this.shippingTransactionDtoList = shippingTransactionDtoList;
	}

	public List<CancelTransactionDto> getCancelTransactionDtoList() {
		return this.cancelTransactionDtoList;
	}

	public void setCancelTransactionDtoList(List<CancelTransactionDto> cancelTransactionDtoList) {
		this.cancelTransactionDtoList = cancelTransactionDtoList;
	}
}

/*
 * Location: C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderstatusexport.jar Qualified Name:
 * com.pacsun.hingeto.orderstatusexport.process.OrderStatusExportProcess JD-Core Version: 0.6.0
 */