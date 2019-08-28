package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="RefundMessage", propOrder={"requestId", "refundDate", "orderID", "orderItemID", "processingStatus", "refundConfirmation", "refundRejection", "refundProcessingMessage"})
public class RefundMessage extends Message
{

  @XmlElement(name="RequestId", required=true)
  protected String requestId;

  @XmlElement(name="RefundDate", required=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar refundDate;

  @XmlElement(name="OrderID", required=true)
  protected String orderID;

  @XmlElement(name="OrderItemID", required=true)
  protected String orderItemID;

  @XmlElement(name="ProcessingStatus", required=true)
  protected RefundProcessingStatus processingStatus;

  @XmlElement(name="RefundConfirmation")
  protected RefundConfirmationMessage refundConfirmation;

  @XmlElement(name="RefundRejection")
  protected RefundRejectionMessage refundRejection;

  @XmlElement(name="RefundProcessingMessage")
  protected RefundProcessingMessage refundProcessingMessage;

  public String getRequestId()
  {
    return this.requestId;
  }

  public void setRequestId(String value)
  {
    this.requestId = value;
  }

  public XMLGregorianCalendar getRefundDate()
  {
    return this.refundDate;
  }

  public void setRefundDate(XMLGregorianCalendar value)
  {
    this.refundDate = value;
  }

  public String getOrderID()
  {
    return this.orderID;
  }

  public void setOrderID(String value)
  {
    this.orderID = value;
  }

  public String getOrderItemID()
  {
    return this.orderItemID;
  }

  public void setOrderItemID(String value)
  {
    this.orderItemID = value;
  }

  public RefundProcessingStatus getProcessingStatus()
  {
    return this.processingStatus;
  }

  public void setProcessingStatus(RefundProcessingStatus value)
  {
    this.processingStatus = value;
  }

  public RefundConfirmationMessage getRefundConfirmation()
  {
    return this.refundConfirmation;
  }

  public void setRefundConfirmation(RefundConfirmationMessage value)
  {
    this.refundConfirmation = value;
  }

  public RefundRejectionMessage getRefundRejection()
  {
    return this.refundRejection;
  }

  public void setRefundRejection(RefundRejectionMessage value)
  {
    this.refundRejection = value;
  }

  public RefundProcessingMessage getRefundProcessingMessage()
  {
    return this.refundProcessingMessage;
  }

  public void setRefundProcessingMessage(RefundProcessingMessage value)
  {
    this.refundProcessingMessage = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.RefundMessage
 * JD-Core Version:    0.6.0
 */