package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="VariationChildren", propOrder={"variationSKU", "variationStorefrontProductID", "variationContent"})
public class VariationChildren
{

  @XmlElement(name="VariationSKU", required=true)
  protected String variationSKU;

  @XmlElement(name="VariationStorefrontProductID")
  protected String variationStorefrontProductID;

  @XmlElement(name="VariationContent")
  protected ProductContentType variationContent;

  public String getVariationSKU()
  {
    return this.variationSKU;
  }

  public void setVariationSKU(String value)
  {
    this.variationSKU = value;
  }

  public String getVariationStorefrontProductID()
  {
    return this.variationStorefrontProductID;
  }

  public void setVariationStorefrontProductID(String value)
  {
    this.variationStorefrontProductID = value;
  }

  public ProductContentType getVariationContent()
  {
    return this.variationContent;
  }

  public void setVariationContent(ProductContentType value)
  {
    this.variationContent = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.VariationChildren
 * JD-Core Version:    0.6.0
 */