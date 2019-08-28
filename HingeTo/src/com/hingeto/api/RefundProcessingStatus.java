package com.hingeto.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="RefundProcessingStatus")
@XmlEnum
public enum RefundProcessingStatus
{
  REFUNDED("Refunded"), 

  REJECTED("Rejected"), 

  PROCESSING("Processing");

  private final String value;

  private RefundProcessingStatus(String v) { this.value = v; }

  public String value()
  {
    return this.value;
  }

  public static RefundProcessingStatus fromValue(String v) {
    for (RefundProcessingStatus c : values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.RefundProcessingStatus
 * JD-Core Version:    0.6.0
 */