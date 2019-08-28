package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="NamedLocalizedAttributeList", propOrder={"values"})
@XmlSeeAlso({ProductLocalizedAttributeList.class})
public class NamedLocalizedAttributeList
{

  @XmlElement(required=true)
  protected List<Values> values;

  public List<Values> getValues()
  {
    if (this.values == null) {
      this.values = new ArrayList();
    }
    return this.values;
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name="", propOrder={"value"})
  public static class Values
  {

    @XmlElement(required=true)
    protected List<String> value;

    @XmlAttribute(name="lang", required=true)
    protected String lang;

    public List<String> getValue()
    {
      if (this.value == null) {
        this.value = new ArrayList();
      }
      return this.value;
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
 * Qualified Name:     com.hingeto.api.NamedLocalizedAttributeList
 * JD-Core Version:    0.6.0
 */