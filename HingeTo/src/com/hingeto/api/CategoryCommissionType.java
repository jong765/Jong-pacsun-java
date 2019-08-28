package com.hingeto.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="CategoryCommissionType", propOrder={"categoryID", "categoryName", "commissionRate"})
public class CategoryCommissionType
{

  @XmlElement(name="CategoryID", required=true)
  protected String categoryID;

  @XmlElement(name="CategoryName", required=true)
  protected List<CategoryName> categoryName;

  @XmlElement(name="CommissionRate")
  protected BigDecimal commissionRate;

  public String getCategoryID()
  {
    return this.categoryID;
  }

  public void setCategoryID(String value)
  {
    this.categoryID = value;
  }

  public List<CategoryName> getCategoryName()
  {
    if (this.categoryName == null) {
      this.categoryName = new ArrayList();
    }
    return this.categoryName;
  }

  public BigDecimal getCommissionRate()
  {
    return this.commissionRate;
  }

  public void setCommissionRate(BigDecimal value)
  {
    this.commissionRate = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.CategoryCommissionType
 * JD-Core Version:    0.6.0
 */