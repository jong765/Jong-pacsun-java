package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SupplierAttributes", propOrder={"supplierAttribute"})
public class SupplierAttributes
{

  @XmlElement(name="SupplierAttribute", required=true)
  protected List<SupplierAttribute> supplierAttribute;

  public List<SupplierAttribute> getSupplierAttribute()
  {
    if (this.supplierAttribute == null) {
      this.supplierAttribute = new ArrayList();
    }
    return this.supplierAttribute;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.SupplierAttributes
 * JD-Core Version:    0.6.0
 */