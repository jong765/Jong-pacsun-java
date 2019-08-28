package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="OrderFulfillment", propOrder={"carrierCode", "carrierName", "shippingMethod", "trackingNumber", "trackingURL", "fulfillmentItem"})
public class OrderFulfillment
{

  @XmlElement(name="CarrierCode")
  protected String carrierCode;

  @XmlElement(name="CarrierName")
  protected String carrierName;

  @XmlElement(name="ShippingMethod")
  protected String shippingMethod;

  @XmlElement(name="TrackingNumber")
  protected String trackingNumber;

  @XmlElement(name="TrackingURL")
  protected String trackingURL;

  @XmlElement(name="FulfillmentItem", required=true)
  protected List<FulfillmentItem> fulfillmentItem;

  public String getCarrierCode()
  {
    return this.carrierCode;
  }

  public void setCarrierCode(String value)
  {
    this.carrierCode = value;
  }

  public String getCarrierName()
  {
    return this.carrierName;
  }

  public void setCarrierName(String value)
  {
    this.carrierName = value;
  }

  public String getShippingMethod()
  {
    return this.shippingMethod;
  }

  public void setShippingMethod(String value)
  {
    this.shippingMethod = value;
  }

  public String getTrackingNumber()
  {
    return this.trackingNumber;
  }

  public void setTrackingNumber(String value)
  {
    this.trackingNumber = value;
  }

  public String getTrackingURL()
  {
    return this.trackingURL;
  }

  public void setTrackingURL(String value)
  {
    this.trackingURL = value;
  }

  public List<FulfillmentItem> getFulfillmentItem()
  {
    if (this.fulfillmentItem == null) {
      this.fulfillmentItem = new ArrayList();
    }
    return this.fulfillmentItem;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.OrderFulfillment
 * JD-Core Version:    0.6.0
 */