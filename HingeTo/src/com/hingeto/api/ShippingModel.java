package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ShippingModel", propOrder={"currency", "shippingBand"})
public class ShippingModel
{

  @XmlElement(name="Currency", required=true)
  protected String currency;

  @XmlElement(name="ShippingBand")
  protected List<ShippingBand> shippingBand;

  public String getCurrency()
  {
    return this.currency;
  }

  public void setCurrency(String value)
  {
    this.currency = value;
  }

  public List<ShippingBand> getShippingBand()
  {
    if (this.shippingBand == null) {
      this.shippingBand = new ArrayList();
    }
    return this.shippingBand;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ShippingModel
 * JD-Core Version:    0.6.0
 */