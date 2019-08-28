package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SupplierCommissionList", propOrder={"supplierCommission"})
public class SupplierCommissionList
{

  @XmlElement(name="SupplierCommission", required=true)
  protected List<SupplierCommissionMessage> supplierCommission;

  public List<SupplierCommissionMessage> getSupplierCommission()
  {
    if (this.supplierCommission == null) {
      this.supplierCommission = new ArrayList();
    }
    return this.supplierCommission;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.SupplierCommissionList
 * JD-Core Version:    0.6.0
 */