package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="FullProductMessage", propOrder={"priceData", "shippingData", "inventoryData"})
public class FullProductMessage extends ContentMessage
{

  @XmlElement(name="PriceData")
  protected PriceData priceData;

  @XmlElement(name="ShippingData")
  protected ShippingData shippingData;

  @XmlElement(name="InventoryData")
  protected InventoryData inventoryData;

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

  public InventoryData getInventoryData()
  {
    return this.inventoryData;
  }

  public void setInventoryData(InventoryData value)
  {
    this.inventoryData = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.FullProductMessage
 * JD-Core Version:    0.6.0
 */