package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Supplier", propOrder={"supplierName", "supplierID", "supplierConditionNote"})
public class Supplier
{

  @XmlElement(name="SupplierName", required=true)
  protected String supplierName;

  @XmlElement(name="SupplierID", required=true)
  protected String supplierID;

  @XmlElement(name="SupplierConditionNote")
  protected String supplierConditionNote;

  public String getSupplierName()
  {
    return this.supplierName;
  }

  public void setSupplierName(String value)
  {
    this.supplierName = value;
  }

  public String getSupplierID()
  {
    return this.supplierID;
  }

  public void setSupplierID(String value)
  {
    this.supplierID = value;
  }

  public String getSupplierConditionNote()
  {
    return this.supplierConditionNote;
  }

  public void setSupplierConditionNote(String value)
  {
    this.supplierConditionNote = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.Supplier
 * JD-Core Version:    0.6.0
 */