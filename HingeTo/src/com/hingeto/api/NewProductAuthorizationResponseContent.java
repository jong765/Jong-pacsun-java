package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="NewProductAuthorizationResponseContent", propOrder={"storefrontProductID", "attribute", "localizedAttribute", "attributeList", "localizedAttributeList"})
public class NewProductAuthorizationResponseContent
{

  @XmlElement(name="StorefrontProductID")
  protected String storefrontProductID;

  @XmlElement(name="Attribute")
  protected List<ProductAttribute> attribute;

  @XmlElement(name="LocalizedAttribute")
  protected List<ProductLocalizedAttribute> localizedAttribute;

  @XmlElement(name="AttributeList")
  protected List<ProductAttributeList> attributeList;

  @XmlElement(name="LocalizedAttributeList")
  protected List<ProductLocalizedAttributeList> localizedAttributeList;

  public String getStorefrontProductID()
  {
    return this.storefrontProductID;
  }

  public void setStorefrontProductID(String value)
  {
    this.storefrontProductID = value;
  }

  public List<ProductAttribute> getAttribute()
  {
    if (this.attribute == null) {
      this.attribute = new ArrayList();
    }
    return this.attribute;
  }

  public List<ProductLocalizedAttribute> getLocalizedAttribute()
  {
    if (this.localizedAttribute == null) {
      this.localizedAttribute = new ArrayList();
    }
    return this.localizedAttribute;
  }

  public List<ProductAttributeList> getAttributeList()
  {
    if (this.attributeList == null) {
      this.attributeList = new ArrayList();
    }
    return this.attributeList;
  }

  public List<ProductLocalizedAttributeList> getLocalizedAttributeList()
  {
    if (this.localizedAttributeList == null) {
      this.localizedAttributeList = new ArrayList();
    }
    return this.localizedAttributeList;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.NewProductAuthorizationResponseContent
 * JD-Core Version:    0.6.0
 */