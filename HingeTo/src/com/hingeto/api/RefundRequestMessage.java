package com.hingeto.api;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="RefundRequestMessage", propOrder={"requestId", "refundDate", "orderID", "orderItemID", "currency", "refundAmount", "refundType", "refundRequestAttributes", "listingID"})
public class RefundRequestMessage extends Message
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

  @XmlElement(name="Currency", required=true)
  protected String currency;

  @XmlElement(name="RefundAmount", required=true)
  protected BigDecimal refundAmount;

  @XmlElement(name="RefundType", required=true)
  protected RefundType refundType;

  @XmlElement(name="RefundRequestAttributes")
  protected OrderAttributes refundRequestAttributes;

  @XmlElement(name="ListingID")
  protected ListingIDType listingID;

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

  public String getCurrency()
  {
    return this.currency;
  }

  public void setCurrency(String value)
  {
    this.currency = value;
  }

  public BigDecimal getRefundAmount()
  {
    return this.refundAmount;
  }

  public void setRefundAmount(BigDecimal value)
  {
    this.refundAmount = value;
  }

  public RefundType getRefundType()
  {
    return this.refundType;
  }

  public void setRefundType(RefundType value)
  {
    this.refundType = value;
  }

  public OrderAttributes getRefundRequestAttributes()
  {
    return this.refundRequestAttributes;
  }

  public void setRefundRequestAttributes(OrderAttributes value)
  {
    this.refundRequestAttributes = value;
  }

  public ListingIDType getListingID()
  {
    return this.listingID;
  }

  public void setListingID(ListingIDType value)
  {
    this.listingID = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.RefundRequestMessage
 * JD-Core Version:    0.6.0
 */