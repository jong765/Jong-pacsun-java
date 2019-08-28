package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ShippingData", propOrder={"shippingPrice"})
public class ShippingData
{

  @XmlElement(name="ShippingPrice")
  protected List<ShippingPrice> shippingPrice;

  public List<ShippingPrice> getShippingPrice()
  {
    if (this.shippingPrice == null) {
      this.shippingPrice = new ArrayList();
    }
    return this.shippingPrice;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ShippingData
 * JD-Core Version:    0.6.0
 */