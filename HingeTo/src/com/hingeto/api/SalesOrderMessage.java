package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SalesOrderMessage", propOrder={"orderID", "orderDate", "currency", "billingData", "fulfillmentData", "orderAttributes", "orderItem"})
public class SalesOrderMessage extends Message
{

  @XmlElement(name="OrderID", required=true)
  protected String orderID;

  @XmlElement(name="OrderDate", required=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar orderDate;

  @XmlElement(name="Currency", required=true)
  protected String currency;

  @XmlElement(name="BillingData")
  protected BillingData billingData;

  @XmlElement(name="FulfillmentData", required=true)
  protected FulfillmentData fulfillmentData;

  @XmlElement(name="OrderAttributes")
  protected OrderAttributes orderAttributes;

  @XmlElement(name="OrderItem", required=true)
  protected List<OrderItem> orderItem;

  public String getOrderID()
  {
    return this.orderID;
  }

  public void setOrderID(String value)
  {
    this.orderID = value;
  }

  public XMLGregorianCalendar getOrderDate()
  {
    return this.orderDate;
  }

  public void setOrderDate(XMLGregorianCalendar value)
  {
    this.orderDate = value;
  }

  public String getCurrency()
  {
    return this.currency;
  }

  public void setCurrency(String value)
  {
    this.currency = value;
  }

  public BillingData getBillingData()
  {
    return this.billingData;
  }

  public void setBillingData(BillingData value)
  {
    this.billingData = value;
  }

  public FulfillmentData getFulfillmentData()
  {
    return this.fulfillmentData;
  }

  public void setFulfillmentData(FulfillmentData value)
  {
    this.fulfillmentData = value;
  }

  public OrderAttributes getOrderAttributes()
  {
    return this.orderAttributes;
  }

  public void setOrderAttributes(OrderAttributes value)
  {
    this.orderAttributes = value;
  }

  public List<OrderItem> getOrderItem()
  {
    if (this.orderItem == null) {
      this.orderItem = new ArrayList();
    }
    return this.orderItem;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.SalesOrderMessage
 * JD-Core Version:    0.6.0
 */