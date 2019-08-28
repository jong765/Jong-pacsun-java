package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ListingMessage", propOrder={"productReference", "listingSource", "listingOnlineFlag", "inventoryData", "priceData", "shippingData"})
public class ListingMessage extends Message
{

  @XmlElement(name="ProductReference", required=true)
  protected CatalogProductReference productReference;

  @XmlElement(name="ListingSource", required=true)
  protected ListingSource listingSource;

  @XmlElement(name="ListingOnlineFlag")
  protected boolean listingOnlineFlag;

  @XmlElement(name="InventoryData")
  protected InventoryData inventoryData;

  @XmlElement(name="PriceData")
  protected PriceData priceData;

  @XmlElement(name="ShippingData")
  protected ShippingData shippingData;

  @XmlAttribute(name="action")
  protected MessageAction action;

  public CatalogProductReference getProductReference()
  {
    return this.productReference;
  }

  public void setProductReference(CatalogProductReference value)
  {
    this.productReference = value;
  }

  public ListingSource getListingSource()
  {
    return this.listingSource;
  }

  public void setListingSource(ListingSource value)
  {
    this.listingSource = value;
  }

  public boolean isListingOnlineFlag()
  {
    return this.listingOnlineFlag;
  }

  public void setListingOnlineFlag(boolean value)
  {
    this.listingOnlineFlag = value;
  }

  public InventoryData getInventoryData()
  {
    return this.inventoryData;
  }

  public void setInventoryData(InventoryData value)
  {
    this.inventoryData = value;
  }

  public PriceData getPriceData()
  {
    return this.priceData;
  }

  public void setPriceData(PriceData value)
  {
    this.priceData = value;
  }

  public ShippingData getShippingData()
  {
    return this.shippingData;
  }

  public void setShippingData(ShippingData value)
  {
    this.shippingData = value;
  }

  public MessageAction getAction()
  {
    if (this.action == null) {
      return MessageAction.UPDATE;
    }
    return this.action;
  }

  public void setAction(MessageAction value)
  {
    this.action = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ListingMessage
 * JD-Core Version:    0.6.0
 */