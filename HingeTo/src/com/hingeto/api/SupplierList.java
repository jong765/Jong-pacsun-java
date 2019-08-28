package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SupplierList", propOrder={"supplier"})
public class SupplierList
{

  @XmlElement(name="Supplier", required=true)
  protected List<SupplierMessage> supplier;

  public List<SupplierMessage> getSupplier()
  {
    if (this.supplier == null) {
      this.supplier = new ArrayList();
    }
    return this.supplier;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.SupplierList
 * JD-Core Version:    0.6.0
 */