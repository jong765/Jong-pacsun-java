package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ProductContentType", propOrder={"onlineFlag", "productData", "imageURLData", "categoryAssignmentData"})
public class ProductContentType
{

  @XmlElement(name="OnlineFlag")
  protected boolean onlineFlag;

  @XmlElement(name="ProductData")
  protected ProductData productData;

  @XmlElement(name="ImageURLData")
  protected ImageURLData imageURLData;

  @XmlElement(name="CategoryAssignmentData")
  protected CategoryAssignmentData categoryAssignmentData;

  public boolean isOnlineFlag()
  {
    return this.onlineFlag;
  }

  public void setOnlineFlag(boolean value)
  {
    this.onlineFlag = value;
  }

  public ProductData getProductData()
  {
    return this.productData;
  }

  public void setProductData(ProductData value)
  {
    this.productData = value;
  }

  public ImageURLData getImageURLData()
  {
    return this.imageURLData;
  }

  public void setImageURLData(ImageURLData value)
  {
    this.imageURLData = value;
  }

  public CategoryAssignmentData getCategoryAssignmentData()
  {
    return this.categoryAssignmentData;
  }

  public void setCategoryAssignmentData(CategoryAssignmentData value)
  {
    this.categoryAssignmentData = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ProductContentType
 * JD-Core Version:    0.6.0
 */