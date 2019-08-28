package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="PriceData", propOrder={"taxClass", "disposalFee", "listPrice", "msrp", "salePrice", "basicCost", "strikeThroughPrice", "mapPrice", "dropshipFee", "customAttributes"})
public class PriceData
{

  @XmlElement(name="TaxClass")
  protected String taxClass;

  @XmlElement(name="DisposalFee")
  protected List<DisposalFeeType> disposalFee;

  @XmlElement(name="ListPrice")
  protected List<CurrencyPrice> listPrice;

  @XmlElement(name="MSRP")
  protected List<CurrencyPrice> msrp;

  @XmlElement(name="SalePrice")
  protected List<SalePrice> salePrice;

  @XmlElement(name="BasicCost")
  protected List<CurrencyPrice> basicCost;

  @XmlElement(name="StrikeThroughPrice")
  protected List<CurrencyPrice> strikeThroughPrice;

  @XmlElement(name="MAPPrice")
  protected List<CurrencyPrice> mapPrice;

  @XmlElement(name="DropshipFee")
  protected List<CurrencyPrice> dropshipFee;

  @XmlElement(name="CustomAttributes")
  protected CustomAttributes customAttributes;

  public String getTaxClass()
  {
    return this.taxClass;
  }

  public void setTaxClass(String value)
  {
    this.taxClass = value;
  }

  public List<DisposalFeeType> getDisposalFee()
  {
    if (this.disposalFee == null) {
      this.disposalFee = new ArrayList();
    }
    return this.disposalFee;
  }

  public List<CurrencyPrice> getListPrice()
  {
    if (this.listPrice == null) {
      this.listPrice = new ArrayList();
    }
    return this.listPrice;
  }

  public List<CurrencyPrice> getMSRP()
  {
    if (this.msrp == null) {
      this.msrp = new ArrayList();
    }
    return this.msrp;
  }

  public List<SalePrice> getSalePrice()
  {
    if (this.salePrice == null) {
      this.salePrice = new ArrayList();
    }
    return this.salePrice;
  }

  public List<CurrencyPrice> getBasicCost()
  {
    if (this.basicCost == null) {
      this.basicCost = new ArrayList();
    }
    return this.basicCost;
  }

  public List<CurrencyPrice> getStrikeThroughPrice()
  {
    if (this.strikeThroughPrice == null) {
      this.strikeThroughPrice = new ArrayList();
    }
    return this.strikeThroughPrice;
  }

  public List<CurrencyPrice> getMAPPrice()
  {
    if (this.mapPrice == null) {
      this.mapPrice = new ArrayList();
    }
    return this.mapPrice;
  }

  public List<CurrencyPrice> getDropshipFee()
  {
    if (this.dropshipFee == null) {
      this.dropshipFee = new ArrayList();
    }
    return this.dropshipFee;
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
 * Qualified Name:     com.hingeto.api.PriceData
 * JD-Core Version:    0.6.0
 */