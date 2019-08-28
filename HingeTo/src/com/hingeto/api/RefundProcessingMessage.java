package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="RefundProcessingMessage", propOrder={"message"})
public class RefundProcessingMessage
{

  @XmlElement(name="Message", required=true)
  protected String message;

  public String getMessage()
  {
    return this.message;
  }

  public void setMessage(String value)
  {
    this.message = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.RefundProcessingMessage
 * JD-Core Version:    0.6.0
 */