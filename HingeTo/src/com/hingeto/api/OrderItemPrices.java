package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="OrderItemPrices", propOrder={"price"})
public class OrderItemPrices
{

  @XmlElement(name="Price", required=true)
  protected List<OrderItemPrice> price;

  public List<OrderItemPrice> getPrice()
  {
    if (this.price == null) {
      this.price = new ArrayList();
    }
    return this.price;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.OrderItemPrices
 * JD-Core Version:    0.6.0
 */