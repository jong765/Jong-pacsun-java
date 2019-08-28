package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ProductData", propOrder={"productIDs", "variationType", "variations", "title", "description", "shortDescription", "bulletPoints", "brand", "manufacturer", "mfrPartNumber", "dimensions", "attribute", "localizedAttribute", "attributeList", "localizedAttributeList"})
public class ProductData
{

  @XmlElement(name="ProductIDs")
  protected ProductIDs productIDs;

  @XmlElement(name="VariationType", required=true)
  protected VariationType variationType;

  @XmlElement(name="Variations")
  protected Variations variations;

  @XmlElement(name="Title", required=true)
  protected NamedLocalizedAttribute title;

  @XmlElement(name="Description")
  protected NamedLocalizedAttribute description;

  @XmlElement(name="ShortDescription")
  protected NamedLocalizedAttribute shortDescription;

  @XmlElement(name="BulletPoints")
  protected NamedLocalizedAttributeList bulletPoints;

  @XmlElement(name="Brand")
  protected NamedAttribute brand;

  @XmlElement(name="Manufacturer")
  protected NamedAttribute manufacturer;

  @XmlElement(name="MfrPartNumber")
  protected NamedAttribute mfrPartNumber;

  @XmlElement(name="Dimensions")
  protected Dimensions dimensions;

  @XmlElement(name="Attribute")
  protected List<ProductAttribute> attribute;

  @XmlElement(name="LocalizedAttribute")
  protected List<ProductLocalizedAttribute> localizedAttribute;

  @XmlElement(name="AttributeList")
  protected List<ProductAttributeList> attributeList;

  @XmlElement(name="LocalizedAttributeList")
  protected List<ProductLocalizedAttributeList> localizedAttributeList;

  public ProductIDs getProductIDs()
  {
    return this.productIDs;
  }

  public void setProductIDs(ProductIDs value)
  {
    this.productIDs = value;
  }

  public VariationType getVariationType()
  {
    return this.variationType;
  }

  public void setVariationType(VariationType value)
  {
    this.variationType = value;
  }

  public Variations getVariations()
  {
    return this.variations;
  }

  public void setVariations(Variations value)
  {
    this.variations = value;
  }

  public NamedLocalizedAttribute getTitle()
  {
    return this.title;
  }

  public void setTitle(NamedLocalizedAttribute value)
  {
    this.title = value;
  }

  public NamedLocalizedAttribute getDescription()
  {
    return this.description;
  }

  public void setDescription(NamedLocalizedAttribute value)
  {
    this.description = value;
  }

  public NamedLocalizedAttribute getShortDescription()
  {
    return this.shortDescription;
  }

  public void setShortDescription(NamedLocalizedAttribute value)
  {
    this.shortDescription = value;
  }

  public NamedLocalizedAttributeList getBulletPoints()
  {
    return this.bulletPoints;
  }

  public void setBulletPoints(NamedLocalizedAttributeList value)
  {
    this.bulletPoints = value;
  }

  public NamedAttribute getBrand()
  {
    return this.brand;
  }

  public void setBrand(NamedAttribute value)
  {
    this.brand = value;
  }

  public NamedAttribute getManufacturer()
  {
    return this.manufacturer;
  }

  public void setManufacturer(NamedAttribute value)
  {
    this.manufacturer = value;
  }

  public NamedAttribute getMfrPartNumber()
  {
    return this.mfrPartNumber;
  }

  public void setMfrPartNumber(NamedAttribute value)
  {
    this.mfrPartNumber = value;
  }

  public Dimensions getDimensions()
  {
    return this.dimensions;
  }

  public void setDimensions(Dimensions value)
  {
    this.dimensions = value;
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
 * Qualified Name:     com.hingeto.api.ProductData
 * JD-Core Version:    0.6.0
 */