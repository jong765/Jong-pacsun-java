package com.hingeto.api;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ListingSource", propOrder={"listingID", "supplierName", "supplierConditionNote", "commissionRate"})
public class ListingSource
{

  @XmlElement(name="ListingID", required=true)
  protected ListingIDType listingID;

  @XmlElement(name="SupplierName", required=true)
  protected String supplierName;

  @XmlElement(name="SupplierConditionNote")
  protected String supplierConditionNote;

  @XmlElement(name="CommissionRate")
  protected BigDecimal commissionRate;

  @XmlAttribute(name="OwnListing")
  protected Boolean ownListing;

  public ListingIDType getListingID()
  {
    return this.listingID;
  }

  public void setListingID(ListingIDType value)
  {
    this.listingID = value;
  }

  public String getSupplierName()
  {
    return this.supplierName;
  }

  public void setSupplierName(String value)
  {
    this.supplierName = value;
  }

  public String getSupplierConditionNote()
  {
    return this.supplierConditionNote;
  }

  public void setSupplierConditionNote(String value)
  {
    this.supplierConditionNote = value;
  }

  public BigDecimal getCommissionRate()
  {
    return this.commissionRate;
  }

  public void setCommissionRate(BigDecimal value)
  {
    this.commissionRate = value;
  }

  public boolean isOwnListing()
  {
    if (this.ownListing == null) {
      return false;
    }
    return this.ownListing.booleanValue();
  }

  public void setOwnListing(Boolean value)
  {
    this.ownListing = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ListingSource
 * JD-Core Version:    0.6.0
 */