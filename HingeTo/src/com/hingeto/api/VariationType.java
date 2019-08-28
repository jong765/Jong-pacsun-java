package com.hingeto.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="VariationType")
@XmlEnum
public enum VariationType
{
  PARENT("Parent"), 

  PRODUCT("Product");

  private final String value;

  private VariationType(String v) { this.value = v; }

  public String value()
  {
    return this.value;
  }

  public static VariationType fromValue(String v) {
    for (VariationType c : values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.VariationType
 * JD-Core Version:    0.6.0
 */