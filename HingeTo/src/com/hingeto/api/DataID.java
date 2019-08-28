package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="DataID", propOrder={"value"})
public class DataID
{

  @XmlValue
  protected String value;

  @XmlAttribute(name="IDType")
  protected String idType;

  public String getValue()
  {
    return this.value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public String getIDType()
  {
    return this.idType;
  }

  public void setIDType(String value)
  {
    this.idType = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.DataID
 * JD-Core Version:    0.6.0
 */