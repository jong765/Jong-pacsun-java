package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="CategoryName", propOrder={"value"})
public class CategoryName
{

  @XmlValue
  protected String value;

  @XmlAttribute(name="lang", required=true)
  protected String lang;

  public String getValue()
  {
    return this.value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public String getLang()
  {
    return this.lang;
  }

  public void setLang(String value)
  {
    this.lang = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.CategoryName
 * JD-Core Version:    0.6.0
 */