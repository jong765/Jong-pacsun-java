package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="NamedLocalizedAttribute", propOrder={"value"})
@XmlSeeAlso({ProductLocalizedAttribute.class, CustomAttribute.class})
public class NamedLocalizedAttribute
{

  @XmlElement(required=true)
  protected List<Value> value;

  public List<Value> getValue()
  {
    if (this.value == null) {
      this.value = new ArrayList();
    }
    return this.value;
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name="", propOrder={"value"})
  public static class Value
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
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.NamedLocalizedAttribute
 * JD-Core Version:    0.6.0
 */