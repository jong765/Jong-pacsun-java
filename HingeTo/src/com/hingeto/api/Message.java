package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Message")
@XmlSeeAlso({StorefrontTree.class, ShippingOptionMessage.class, SupplierMessage.class, SalesOrderMessage.class, RefundMessage.class, ListingMessage.class, RMAMessage.class, RefundRequestMessage.class, OrderStatusMessage.class, ProductMessage.class, SupplierCommissionMessage.class, ReturnMessage.class})
public class Message
{

  @XmlAttribute(name="MessageID")
  protected String messageID;

  public String getMessageID()
  {
    return this.messageID;
  }

  public void setMessageID(String value)
  {
    this.messageID = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.Message
 * JD-Core Version:    0.6.0
 */