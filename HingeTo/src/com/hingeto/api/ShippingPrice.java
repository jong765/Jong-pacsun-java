package com.hingeto.api;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ShippingPrice", propOrder={"shippingFee", "shippingOption", "destinationArea", "fulfillmentLatency", "deliveryMinDays", "deliveryMaxDays"})
public class ShippingPrice
{

  @XmlElement(name="ShippingFee", required=true)
  protected CurrencyPrice shippingFee;

  @XmlElement(name="ShippingOption", required=true)
  protected String shippingOption;

  @XmlElement(name="DestinationArea", required=true)
  protected String destinationArea;

  @XmlElement(name="FulfillmentLatency", required=true)
  protected String fulfillmentLatency;

  @XmlElement(name="DeliveryMinDays")
  protected BigInteger deliveryMinDays;

  @XmlElement(name="DeliveryMaxDays")
  protected BigInteger deliveryMaxDays;

  public CurrencyPrice getShippingFee()
  {
    return this.shippingFee;
  }

  public void setShippingFee(CurrencyPrice value)
  {
    this.shippingFee = value;
  }

  public String getShippingOption()
  {
    return this.shippingOption;
  }

  public void setShippingOption(String value)
  {
    this.shippingOption = value;
  }

  public String getDestinationArea()
  {
    return this.destinationArea;
  }

  public void setDestinationArea(String value)
  {
    this.destinationArea = value;
  }

  public String getFulfillmentLatency()
  {
    return this.fulfillmentLatency;
  }

  public void setFulfillmentLatency(String value)
  {
    this.fulfillmentLatency = value;
  }

  public BigInteger getDeliveryMinDays()
  {
    return this.deliveryMinDays;
  }

  public void setDeliveryMinDays(BigInteger value)
  {
    this.deliveryMinDays = value;
  }

  public BigInteger getDeliveryMaxDays()
  {
    return this.deliveryMaxDays;
  }

  public void setDeliveryMaxDays(BigInteger value)
  {
    this.deliveryMaxDays = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ShippingPrice
 * JD-Core Version:    0.6.0
 */