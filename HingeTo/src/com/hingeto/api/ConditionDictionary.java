package com.hingeto.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="ConditionDictionary")
@XmlEnum
public enum ConditionDictionary
{
  NEW("New"), 

  USED_LIKE_NEW("UsedLikeNew"), 

  USED_VERY_GOOD("UsedVeryGood"), 

  USED_GOOD("UsedGood"), 

  USED_ACCEPTABLE("UsedAcceptable"), 

  REFURBISHED("Refurbished");

  private final String value;

  private ConditionDictionary(String v) { this.value = v; }

  public String value()
  {
    return this.value;
  }

  public static ConditionDictionary fromValue(String v) {
    for (ConditionDictionary c : values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ConditionDictionary
 * JD-Core Version:    0.6.0
 */