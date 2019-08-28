package com.hingeto.api;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Dimensions", propOrder={"itemDimensionsLength", "itemDimensionsWidth", "itemDimensionsHeight", "dimensionsUnit", "shippingWeight", "weightUnit"})
public class Dimensions
{

  @XmlElement(name="ItemDimensionsLength")
  protected BigDecimal itemDimensionsLength;

  @XmlElement(name="ItemDimensionsWidth")
  protected BigDecimal itemDimensionsWidth;

  @XmlElement(name="ItemDimensionsHeight")
  protected BigDecimal itemDimensionsHeight;

  @XmlElement(name="DimensionsUnit", required=true)
  protected DimensionsUnit dimensionsUnit;

  @XmlElement(name="ShippingWeight")
  protected BigDecimal shippingWeight;

  @XmlElement(name="WeightUnit", required=true)
  protected WeightUnit weightUnit;

  public BigDecimal getItemDimensionsLength()
  {
    return this.itemDimensionsLength;
  }

  public void setItemDimensionsLength(BigDecimal value)
  {
    this.itemDimensionsLength = value;
  }

  public BigDecimal getItemDimensionsWidth()
  {
    return this.itemDimensionsWidth;
  }

  public void setItemDimensionsWidth(BigDecimal value)
  {
    this.itemDimensionsWidth = value;
  }

  public BigDecimal getItemDimensionsHeight()
  {
    return this.itemDimensionsHeight;
  }

  public void setItemDimensionsHeight(BigDecimal value)
  {
    this.itemDimensionsHeight = value;
  }

  public DimensionsUnit getDimensionsUnit()
  {
    return this.dimensionsUnit;
  }

  public void setDimensionsUnit(DimensionsUnit value)
  {
    this.dimensionsUnit = value;
  }

  public BigDecimal getShippingWeight()
  {
    return this.shippingWeight;
  }

  public void setShippingWeight(BigDecimal value)
  {
    this.shippingWeight = value;
  }

  public WeightUnit getWeightUnit()
  {
    return this.weightUnit;
  }

  public void setWeightUnit(WeightUnit value)
  {
    this.weightUnit = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.Dimensions
 * JD-Core Version:    0.6.0
 */