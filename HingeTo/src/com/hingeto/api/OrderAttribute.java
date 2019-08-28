package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="OrderAttribute", propOrder={"value"})
public class OrderAttribute
{

  @XmlValue
  protected String value;

  @XmlAttribute(name="name", required=true)
  protected String name;

  public String getValue()
  {
    return this.value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String value)
  {
    this.name = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.OrderAttribute
 * JD-Core Version:    0.6.0
 */