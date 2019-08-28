package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="OrderStatusList", propOrder={"orderStatus"})
public class OrderStatusList
{

  @XmlElement(name="OrderStatus", required=true)
  protected List<OrderStatusMessage> orderStatus;

  public List<OrderStatusMessage> getOrderStatus()
  {
    if (this.orderStatus == null) {
      this.orderStatus = new ArrayList();
    }
    return this.orderStatus;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.OrderStatusList
 * JD-Core Version:    0.6.0
 */