package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="validationMessage", propOrder={"value"})
public class ValidationMessage
{

  @XmlValue
  protected String value;

  @XmlAttribute(name="level")
  protected Level level;

  public String getValue()
  {
    return this.value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public Level getLevel()
  {
    return this.level;
  }

  public void setLevel(Level value)
  {
    this.level = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ValidationMessage
 * JD-Core Version:    0.6.0
 */