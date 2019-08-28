package com.hingeto.api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="CategoryAssignment", propOrder={"categoryID", "categoryName", "sortOrder"})
public class CategoryAssignment
{

  @XmlElement(name="CategoryID", required=true)
  protected String categoryID;

  @XmlElement(name="CategoryName", required=true)
  protected List<CategoryName> categoryName;

  @XmlElement(name="SortOrder")
  protected BigInteger sortOrder;

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

  public BigInteger getSortOrder()
  {
    return this.sortOrder;
  }

  public void setSortOrder(BigInteger value)
  {
    this.sortOrder = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.CategoryAssignment
 * JD-Core Version:    0.6.0
 */