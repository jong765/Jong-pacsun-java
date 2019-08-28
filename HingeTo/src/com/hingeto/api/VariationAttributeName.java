package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="VariationAttributeName", propOrder={"value"})
public class VariationAttributeName
{

  @XmlValue
  protected String value;

  @XmlAttribute(name="localized")
  protected Boolean localized;

  @XmlAttribute(name="displayName")
  protected String displayName;

  public String getValue()
  {
    return this.value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public boolean isLocalized()
  {
    if (this.localized == null) {
      return false;
    }
    return this.localized.booleanValue();
  }

  public void setLocalized(Boolean value)
  {
    this.localized = value;
  }

  public String getDisplayName()
  {
    return this.displayName;
  }

  public void setDisplayName(String value)
  {
    this.displayName = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.VariationAttributeName
 * JD-Core Version:    0.6.0
 */