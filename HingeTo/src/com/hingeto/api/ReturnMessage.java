package com.hingeto.api;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ReturnMessage", propOrder={"orderID", "orderItemID", "returnId", "returnDate", "rma", "listingID", "rmaDate", "returnReason", "quantity", "returnAttributes"})
public class ReturnMessage extends Message
{

  @XmlElement(name="OrderID", required=true)
  protected String orderID;

  @XmlElement(name="OrderItemID", required=true)
  protected String orderItemID;

  @XmlElement(name="ReturnId", required=true)
  protected String returnId;

  @XmlElement(name="ReturnDate", required=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar returnDate;

  @XmlElement(name="RMA", required=true)
  protected String rma;

  @XmlElement(name="ListingID", required=true)
  protected ListingIDType listingID;

  @XmlElement(name="RMADate")
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar rmaDate;

  @XmlElement(name="ReturnReason")
  protected String returnReason;

  @XmlElement(name="Quantity", required=true)
  @XmlSchemaType(name="nonNegativeInteger")
  protected BigInteger quantity;

  @XmlElement(name="ReturnAttributes")
  protected OrderAttributes returnAttributes;

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

  public String getReturnId()
  {
    return this.returnId;
  }

  public void setReturnId(String value)
  {
    this.returnId = value;
  }

  public XMLGregorianCalendar getReturnDate()
  {
    return this.returnDate;
  }

  public void setReturnDate(XMLGregorianCalendar value)
  {
    this.returnDate = value;
  }

  public String getRMA()
  {
    return this.rma;
  }

  public void setRMA(String value)
  {
    this.rma = value;
  }

  public ListingIDType getListingID()
  {
    return this.listingID;
  }

  public void setListingID(ListingIDType value)
  {
    this.listingID = value;
  }

  public XMLGregorianCalendar getRMADate()
  {
    return this.rmaDate;
  }

  public void setRMADate(XMLGregorianCalendar value)
  {
    this.rmaDate = value;
  }

  public String getReturnReason()
  {
    return this.returnReason;
  }

  public void setReturnReason(String value)
  {
    this.returnReason = value;
  }

  public BigInteger getQuantity()
  {
    return this.quantity;
  }

  public void setQuantity(BigInteger value)
  {
    this.quantity = value;
  }

  public OrderAttributes getReturnAttributes()
  {
    return this.returnAttributes;
  }

  public void setReturnAttributes(OrderAttributes value)
  {
    this.returnAttributes = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ReturnMessage
 * JD-Core Version:    0.6.0
 */