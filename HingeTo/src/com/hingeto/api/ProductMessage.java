package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ProductMessage")
@XmlSeeAlso({ContentMessage.class, ImageURLMessage.class, CategoryAssignmentMessage.class})
public class ProductMessage extends Message
{

  @XmlAttribute(name="SKU", required=true)
  protected String sku;

  @XmlAttribute(name="StorefrontProductID")
  protected String storefrontProductID;

  public String getSKU()
  {
    return this.sku;
  }

  public void setSKU(String value)
  {
    this.sku = value;
  }

  public String getStorefrontProductID()
  {
    return this.storefrontProductID;
  }

  public void setStorefrontProductID(String value)
  {
    this.storefrontProductID = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ProductMessage
 * JD-Core Version:    0.6.0
 */