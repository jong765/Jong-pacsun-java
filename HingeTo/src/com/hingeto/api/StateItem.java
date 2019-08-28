package com.hingeto.api;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="StateItem", propOrder={"orderItemCode", "storeFrontLineItemID", "listingID", "quantity", "state", "message"})
public class StateItem
{

  @XmlElement(name="OrderItemCode", required=true)
  protected String orderItemCode;

  @XmlElement(name="StoreFrontLineItemID", required=true)
  protected String storeFrontLineItemID;

  @XmlElement(name="ListingID", required=true)
  protected ListingIDType listingID;

  @XmlElement(name="Quantity", required=true)
  @XmlSchemaType(name="positiveInteger")
  protected BigInteger quantity;

  @XmlElement(name="State", required=true)
  protected String state;

  @XmlElement(name="Message")
  protected String message;

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

  public String getState()
  {
    return this.state;
  }

  public void setState(String value)
  {
    this.state = value;
  }

  public String getMessage()
  {
    return this.message;
  }

  public void setMessage(String value)
  {
    this.message = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.StateItem
 * JD-Core Version:    0.6.0
 */