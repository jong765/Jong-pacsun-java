package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="OrderList", propOrder={"salesOrder"})
public class OrderList
{

  @XmlElement(name="SalesOrder", required=true)
  protected List<SalesOrderMessage> salesOrder;

  public List<SalesOrderMessage> getSalesOrder()
  {
    if (this.salesOrder == null) {
      this.salesOrder = new ArrayList();
    }
    return this.salesOrder;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.OrderList
 * JD-Core Version:    0.6.0
 */