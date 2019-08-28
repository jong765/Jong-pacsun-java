package com.hingeto.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SupplierCommissionMessage", propOrder={"supplierID", "supplierEffectiveID", "supplierName", "defaultCommission", "fullRefreshFlag", "categoryCommission"})
public class SupplierCommissionMessage extends Message
{

  @XmlElement(name="SupplierID", required=true)
  protected String supplierID;

  @XmlElement(name="SupplierEffectiveID", required=true)
  protected String supplierEffectiveID;

  @XmlElement(name="SupplierName")
  protected String supplierName;

  @XmlElement(name="DefaultCommission")
  protected BigDecimal defaultCommission;

  @XmlElement(name="FullRefreshFlag", defaultValue="true")
  protected boolean fullRefreshFlag;

  @XmlElement(name="CategoryCommission")
  protected List<CategoryCommissionType> categoryCommission;

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

  public BigDecimal getDefaultCommission()
  {
    return this.defaultCommission;
  }

  public void setDefaultCommission(BigDecimal value)
  {
    this.defaultCommission = value;
  }

  public boolean isFullRefreshFlag()
  {
    return this.fullRefreshFlag;
  }

  public void setFullRefreshFlag(boolean value)
  {
    this.fullRefreshFlag = value;
  }

  public List<CategoryCommissionType> getCategoryCommission()
  {
    if (this.categoryCommission == null) {
      this.categoryCommission = new ArrayList();
    }
    return this.categoryCommission;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.SupplierCommissionMessage
 * JD-Core Version:    0.6.0
 */