package com.hingeto.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="WeightUnit")
@XmlEnum
public enum WeightUnit
{
  GR, 
  KG, 
  OZ, 
  LB;

  public String value() {
    return name();
  }

  public static WeightUnit fromValue(String v) {
    return valueOf(v);
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.WeightUnit
 * JD-Core Version:    0.6.0
 */