package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="CatalogProductReference", propOrder={"productSKU", "storefrontProductID", "condition", "customAttributes"})
public class CatalogProductReference
{

  @XmlElement(name="ProductSKU", required=true)
  protected String productSKU;

  @XmlElement(name="StorefrontProductID")
  protected String storefrontProductID;

  @XmlElement(name="Condition")
  protected Condition condition;

  @XmlElement(name="CustomAttributes")
  protected CustomAttributes customAttributes;

  public String getProductSKU()
  {
    return this.productSKU;
  }

  public void setProductSKU(String value)
  {
    this.productSKU = value;
  }

  public String getStorefrontProductID()
  {
    return this.storefrontProductID;
  }

  public void setStorefrontProductID(String value)
  {
    this.storefrontProductID = value;
  }

  public Condition getCondition()
  {
    return this.condition;
  }

  public void setCondition(Condition value)
  {
    this.condition = value;
  }

  public CustomAttributes getCustomAttributes()
  {
    return this.customAttributes;
  }

  public void setCustomAttributes(CustomAttributes value)
  {
    this.customAttributes = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.CatalogProductReference
 * JD-Core Version:    0.6.0
 */