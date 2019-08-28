package com.hingeto.api;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SupplierMessage", propOrder={"supplierID", "supplierEffectiveID", "supplierName", "supplierDescription", "fullBusinessName", "companyAddress", "contactFirstName", "contactLastName", "contactPhone", "contactEmail", "notificationEmail", "contentRank", "performanceRank", "defaultCommission", "shipWindow", "supplierAttributes"})
public class SupplierMessage extends Message
{

  @XmlElement(name="SupplierID", required=true)
  protected String supplierID;

  @XmlElement(name="SupplierEffectiveID", required=true)
  protected String supplierEffectiveID;

  @XmlElement(name="SupplierName")
  protected String supplierName;

  @XmlElement(name="SupplierDescription")
  protected String supplierDescription;

  @XmlElement(name="FullBusinessName")
  protected String fullBusinessName;

  @XmlElement(name="CompanyAddress")
  protected Address companyAddress;

  @XmlElement(name="ContactFirstName")
  protected String contactFirstName;

  @XmlElement(name="ContactLastName")
  protected String contactLastName;

  @XmlElement(name="ContactPhone")
  protected String contactPhone;

  @XmlElement(name="ContactEmail")
  protected String contactEmail;

  @XmlElement(name="NotificationEmail")
  protected String notificationEmail;

  @XmlElement(name="ContentRank")
  protected BigDecimal contentRank;

  @XmlElement(name="PerformanceRank")
  protected String performanceRank;

  @XmlElement(name="DefaultCommission")
  protected BigDecimal defaultCommission;

  @XmlElement(name="ShipWindow")
  protected String shipWindow;

  @XmlElement(name="SupplierAttributes")
  protected SupplierAttributes supplierAttributes;

  public String getSupplierID()
  {
    return this.supplierID;
  }

  public void setSupplierID(String value)
  {
    this.supplierID = value;
  }

  public String getSupplierEffectiveID()
  {
    return this.supplierEffectiveID;
  }

  public void setSupplierEffectiveID(String value)
  {
    this.supplierEffectiveID = value;
  }

  public String getSupplierName()
  {
    return this.supplierName;
  }

  public void setSupplierName(String value)
  {
    this.supplierName = value;
  }

  public String getSupplierDescription()
  {
    return this.supplierDescription;
  }

  public void setSupplierDescription(String value)
  {
    this.supplierDescription = value;
  }

  public String getFullBusinessName()
  {
    return this.fullBusinessName;
  }

  public void setFullBusinessName(String value)
  {
    this.fullBusinessName = value;
  }

  public Address getCompanyAddress()
  {
    return this.companyAddress;
  }

  public void setCompanyAddress(Address value)
  {
    this.companyAddress = value;
  }

  public String getContactFirstName()
  {
    return this.contactFirstName;
  }

  public void setContactFirstName(String value)
  {
    this.contactFirstName = value;
  }

  public String getContactLastName()
  {
    return this.contactLastName;
  }

  public void setContactLastName(String value)
  {
    this.contactLastName = value;
  }

  public String getContactPhone()
  {
    return this.contactPhone;
  }

  public void setContactPhone(String value)
  {
    this.contactPhone = value;
  }

  public String getContactEmail()
  {
    return this.contactEmail;
  }

  public void setContactEmail(String value)
  {
    this.contactEmail = value;
  }

  public String getNotificationEmail()
  {
    return this.notificationEmail;
  }

  public void setNotificationEmail(String value)
  {
    this.notificationEmail = value;
  }

  public BigDecimal getContentRank()
  {
    return this.contentRank;
  }

  public void setContentRank(BigDecimal value)
  {
    this.contentRank = value;
  }

  public String getPerformanceRank()
  {
    return this.performanceRank;
  }

  public void setPerformanceRank(String value)
  {
    this.performanceRank = value;
  }

  public BigDecimal getDefaultCommission()
  {
    return this.defaultCommission;
  }

  public void setDefaultCommission(BigDecimal value)
  {
    this.defaultCommission = value;
  }

  public String getShipWindow()
  {
    return this.shipWindow;
  }

  public void setShipWindow(String value)
  {
    this.shipWindow = value;
  }

  public SupplierAttributes getSupplierAttributes()
  {
    return this.supplierAttributes;
  }

  public void setSupplierAttributes(SupplierAttributes value)
  {
    this.supplierAttributes = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.SupplierMessage
 * JD-Core Version:    0.6.0
 */