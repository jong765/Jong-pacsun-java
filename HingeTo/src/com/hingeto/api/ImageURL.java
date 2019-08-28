package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ImageURL", propOrder={"value"})
public class ImageURL
{

  @XmlValue
  protected String value;

  @XmlAttribute(name="imageType", required=true)
  protected String imageType;

  public String getValue()
  {
    return this.value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public String getImageType()
  {
    return this.imageType;
  }

  public void setImageType(String value)
  {
    this.imageType = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ImageURL
 * JD-Core Version:    0.6.0
 */