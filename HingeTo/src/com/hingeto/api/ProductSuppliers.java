package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ProductSuppliers", propOrder={"supplier"})
public class ProductSuppliers
{

  @XmlElement(name="Supplier", required=true)
  protected List<Supplier> supplier;

  public List<Supplier> getSupplier()
  {
    if (this.supplier == null) {
      this.supplier = new ArrayList();
    }
    return this.supplier;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ProductSuppliers
 * JD-Core Version:    0.6.0
 */