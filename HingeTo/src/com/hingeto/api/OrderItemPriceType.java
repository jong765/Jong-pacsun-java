package com.hingeto.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="OrderItemPriceType")
@XmlEnum
public enum OrderItemPriceType
{
  ITEM_PRICE("ItemPrice"), 

  ITEM_TAX("ItemTax"), 

  SHIPPING_PRICE("ShippingPrice"), 

  SHIPPING_TAX("ShippingTax");

  private final String value;

  private OrderItemPriceType(String v) { this.value = v; }

  public String value()
  {
    return this.value;
  }

  public static OrderItemPriceType fromValue(String v) {
    for (OrderItemPriceType c : values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.OrderItemPriceType
 * JD-Core Version:    0.6.0
 */