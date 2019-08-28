package com.hingeto.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="AttributeDomain")
@XmlEnum
public enum AttributeDomain
{
  COMMON_TAXONOMY("CommonTaxonomy"), 
  MPO("MPO");

  private final String value;

  private AttributeDomain(String v) { this.value = v; }

  public String value()
  {
    return this.value;
  }

  public static AttributeDomain fromValue(String v) {
    for (AttributeDomain c : values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.AttributeDomain
 * JD-Core Version:    0.6.0
 */