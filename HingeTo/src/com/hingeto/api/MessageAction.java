package com.hingeto.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="MessageAction")
@XmlEnum
public enum MessageAction
{
  UPDATE("update"), 

  DELETE("delete");

  private final String value;

  private MessageAction(String v) { this.value = v; }

  public String value()
  {
    return this.value;
  }

  public static MessageAction fromValue(String v) {
    for (MessageAction c : values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.MessageAction
 * JD-Core Version:    0.6.0
 */