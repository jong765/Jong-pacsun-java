package com.hingeto.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="ProcessingResult")
@XmlEnum
public enum ProcessingResult
{
  SUCCESS("Success"), 

  FAILURE("Failure"), 

  NOT_PROCESSED("Not processed");

  private final String value;

  private ProcessingResult(String v) { this.value = v; }

  public String value()
  {
    return this.value;
  }

  public static ProcessingResult fromValue(String v) {
    for (ProcessingResult c : values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ProcessingResult
 * JD-Core Version:    0.6.0
 */