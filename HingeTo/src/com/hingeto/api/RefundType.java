package com.hingeto.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="RefundType")
@XmlEnum
public enum RefundType
{
  RETURNED("Returned"), 

  MISSING("Missing"), 

  REFUSED("Refused"), 

  RESELLABLE("Resellable"), 

  NOT_SELLABLE("NotSellable"), 

  DAMAGED("Damaged"), 

  DEFECTIVE("Defective"), 

  OTHER("Other");

  private final String value;

  private RefundType(String v) { this.value = v; }

  public String value()
  {
    return this.value;
  }

  public static RefundType fromValue(String v) {
    for (RefundType c : values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.RefundType
 * JD-Core Version:    0.6.0
 */