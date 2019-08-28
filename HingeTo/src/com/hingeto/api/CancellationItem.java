package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="CancellationItem", propOrder={"orderItemCode", "storeFrontLineItemID", "listingID", "cancelReason"})
public class CancellationItem
{

  @XmlElement(name="OrderItemCode", required=true)
  protected String orderItemCode;

  @XmlElement(name="StoreFrontLineItemID", required=true)
  protected String storeFrontLineItemID;

  @XmlElement(name="ListingID", required=true)
  protected ListingIDType listingID;

  @XmlElement(name="CancelReason")
  protected String cancelReason;

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

  public String getCancelReason()
  {
    return this.cancelReason;
  }

  public void setCancelReason(String value)
  {
    this.cancelReason = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.CancellationItem
 * JD-Core Version:    0.6.0
 */