package com.hingeto.api;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="RMAItem", propOrder={"listingID", "orderItemCode", "quantity"})
public class RMAItem
{

  @XmlElement(name="ListingID")
  protected ListingIDType listingID;

  @XmlElement(name="OrderItemCode")
  protected String orderItemCode;

  @XmlElement(name="Quantity", required=true)
  @XmlSchemaType(name="nonNegativeInteger")
  protected BigInteger quantity;

  public ListingIDType getListingID()
  {
    return this.listingID;
  }

  public void setListingID(ListingIDType value)
  {
    this.listingID = value;
  }

  public String getOrderItemCode()
  {
    return this.orderItemCode;
  }

  public void setOrderItemCode(String value)
  {
    this.orderItemCode = value;
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
 * Qualified Name:     com.hingeto.api.RMAItem
 * JD-Core Version:    0.6.0
 */