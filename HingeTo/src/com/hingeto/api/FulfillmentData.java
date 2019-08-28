package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="FulfillmentData", propOrder={"shippingOption", "fulfillmentAddress"})
public class FulfillmentData
{

  @XmlElement(name="ShippingOption", required=true)
  protected String shippingOption;

  @XmlElement(name="FulfillmentAddress")
  protected Address fulfillmentAddress;

  public String getShippingOption()
  {
    return this.shippingOption;
  }

  public void setShippingOption(String value)
  {
    this.shippingOption = value;
  }

  public Address getFulfillmentAddress()
  {
    return this.fulfillmentAddress;
  }

  public void setFulfillmentAddress(Address value)
  {
    this.fulfillmentAddress = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.FulfillmentData
 * JD-Core Version:    0.6.0
 */