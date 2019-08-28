package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ProductAttribute")
public class ProductAttribute extends NamedAttribute
{

  @XmlAttribute(name="domain", required=true)
  protected AttributeDomain domain;

  @XmlAttribute(name="name", required=true)
  protected String name;

  public AttributeDomain getDomain()
  {
    return this.domain;
  }

  public void setDomain(AttributeDomain value)
  {
    this.domain = value;
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
 * Qualified Name:     com.hingeto.api.ProductAttribute
 * JD-Core Version:    0.6.0
 */