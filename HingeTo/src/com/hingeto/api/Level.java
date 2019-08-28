package com.hingeto.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="level")
@XmlEnum
public enum Level
{
  ERROR("error"), 

  WARNING("warning"), 

  INFO("info");

  private final String value;

  private Level(String v) { this.value = v; }

  public String value()
  {
    return this.value;
  }

  public static Level fromValue(String v) {
    for (Level c : values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.Level
 * JD-Core Version:    0.6.0
 */