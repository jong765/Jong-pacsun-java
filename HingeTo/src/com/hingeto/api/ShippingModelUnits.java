package com.hingeto.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="ShippingModelUnits")
@XmlEnum
public enum ShippingModelUnits
{
  MM("MM"), 
  CM("CM"), 
  M("M"), 
  IN("IN"), 
  FT("FT"), 

  MM_3("MM^3"), 

  CM_3("CM^3"), 

  M_3("M^3"), 

  IN_3("IN^3"), 

  FT_3("FT^3"), 
  GR("GR"), 
  KG("KG"), 
  OZ("OZ"), 
  LB("LB"), 

  N_A("n/a");

  private final String value;

  private ShippingModelUnits(String v) { this.value = v; }

  public String value()
  {
    return this.value;
  }

  public static ShippingModelUnits fromValue(String v) {
    for (ShippingModelUnits c : values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ShippingModelUnits
 * JD-Core Version:    0.6.0
 */