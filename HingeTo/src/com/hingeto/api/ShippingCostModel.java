package com.hingeto.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="ShippingCostModel")
@XmlEnum
public enum ShippingCostModel
{
  DON_T_CALCULATE("Don't Calculate"), 

  FIXED("Fixed"), 

  WEIGHT("Weight"), 

  PRICE("Price"), 

  VOLUME("Volume"), 

  BY_SUPPLIER("BySupplier");

  private final String value;

  private ShippingCostModel(String v) { this.value = v; }

  public String value()
  {
    return this.value;
  }

  public static ShippingCostModel fromValue(String v) {
    for (ShippingCostModel c : values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ShippingCostModel
 * JD-Core Version:    0.6.0
 */