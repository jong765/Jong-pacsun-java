package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ShippingCalculationList", propOrder={"shippingOptionMessage"})
public class ShippingCalculationList
{

  @XmlElement(name="ShippingOptionMessage", required=true)
  protected List<ShippingOptionMessage> shippingOptionMessage;

  public List<ShippingOptionMessage> getShippingOptionMessage()
  {
    if (this.shippingOptionMessage == null) {
      this.shippingOptionMessage = new ArrayList();
    }
    return this.shippingOptionMessage;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ShippingCalculationList
 * JD-Core Version:    0.6.0
 */