package com.hingeto.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="DimensionsUnit")
@XmlEnum
public enum DimensionsUnit
{
  MM, 
  CM, 
  M, 
  IN, 
  FT;

  public String value() {
    return name();
  }

  public static DimensionsUnit fromValue(String v) {
    return valueOf(v);
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.DimensionsUnit
 * JD-Core Version:    0.6.0
 */