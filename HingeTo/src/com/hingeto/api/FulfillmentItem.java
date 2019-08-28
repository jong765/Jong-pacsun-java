package com.hingeto.api;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="FulfillmentItem", propOrder={"orderItemCode", "storeFrontLineItemID", "returnNumber", "listingID", "quantity"})
public class FulfillmentItem
{

  @XmlElement(name="OrderItemCode", required=true)
  protected String orderItemCode;

  @XmlElement(name="StoreFrontLineItemID", required=true)
  protected String storeFrontLineItemID;

  @XmlElement(name="ReturnNumber", required=true)
  protected String returnNumber;

  @XmlElement(name="ListingID", required=true)
  protected ListingIDType listingID;

  @XmlElement(name="Quantity", required=true)
  @XmlSchemaType(name="positiveInteger")
  protected BigInteger quantity;

  public String getOrderItemCode()
  {
    return this.orderItemCode;
  }

  public void setOrderItemCode(String value)
  {
    this.orderItemCode = value;
  }

  public String getStoreFrontLineItemID()
  {
    return this.storeFrontLineItemID;
  }

  public void setStoreFrontLineItemID(String value)
  {
    this.storeFrontLineItemID = value;
  }

  public String getReturnNumber()
  {
    return this.returnNumber;
  }

  public void setReturnNumber(String value)
  {
    this.returnNumber = value;
  }

  public ListingIDType getListingID()
  {
    return this.listingID;
  }

  public void setListingID(ListingIDType value)
  {
    this.listingID = value;
  }

  public BigInteger getQuantity()
  {
    return this.quantity;
  }

  public void setQuantity(BigInteger value)
  {
    this.quantity = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.FulfillmentItem
 * JD-Core Version:    0.6.0
 */