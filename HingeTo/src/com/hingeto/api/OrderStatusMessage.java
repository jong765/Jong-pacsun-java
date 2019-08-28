package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="OrderStatusMessage", propOrder={"orderID", "statusUpdateDate", "orderFulfillment", "orderCancellation", "orderState", "orderStatusAttributes"})
public class OrderStatusMessage extends Message
{

  @XmlElement(name="OrderID", required=true)
  protected String orderID;

  @XmlElement(name="StatusUpdateDate", required=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar statusUpdateDate;

  @XmlElement(name="OrderFulfillment")
  protected OrderFulfillment orderFulfillment;

  @XmlElement(name="OrderCancellation")
  protected OrderCancellation orderCancellation;

  @XmlElement(name="OrderState")
  protected OrderState orderState;

  @XmlElement(name="OrderStatusAttributes")
  protected OrderAttributes orderStatusAttributes;

  public String getOrderID()
  {
    return this.orderID;
  }

  public void setOrderID(String value)
  {
    this.orderID = value;
  }

  public XMLGregorianCalendar getStatusUpdateDate()
  {
    return this.statusUpdateDate;
  }

  public void setStatusUpdateDate(XMLGregorianCalendar value)
  {
    this.statusUpdateDate = value;
  }

  public OrderFulfillment getOrderFulfillment()
  {
    return this.orderFulfillment;
  }

  public void setOrderFulfillment(OrderFulfillment value)
  {
    this.orderFulfillment = value;
  }

  public OrderCancellation getOrderCancellation()
  {
    return this.orderCancellation;
  }

  public void setOrderCancellation(OrderCancellation value)
  {
    this.orderCancellation = value;
  }

  public OrderState getOrderState()
  {
    return this.orderState;
  }

  public void setOrderState(OrderState value)
  {
    this.orderState = value;
  }

  public OrderAttributes getOrderStatusAttributes()
  {
    return this.orderStatusAttributes;
  }

  public void setOrderStatusAttributes(OrderAttributes value)
  {
    this.orderStatusAttributes = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.OrderStatusMessage
 * JD-Core Version:    0.6.0
 */