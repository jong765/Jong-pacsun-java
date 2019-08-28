package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="StorefrontCategory", propOrder={"parentID", "id", "categoryName"})
public class StorefrontCategory
{

  @XmlElement(name="ParentID")
  protected String parentID;

  @XmlElement(name="ID", required=true)
  protected String id;

  @XmlElement(name="CategoryName", required=true)
  protected List<CategoryName> categoryName;

  public String getParentID()
  {
    return this.parentID;
  }

  public void setParentID(String value)
  {
    this.parentID = value;
  }

  public String getID()
  {
    return this.id;
  }

  public void setID(String value)
  {
    this.id = value;
  }

  public List<CategoryName> getCategoryName()
  {
    if (this.categoryName == null) {
      this.categoryName = new ArrayList();
    }
    return this.categoryName;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.StorefrontCategory
 * JD-Core Version:    0.6.0
 */