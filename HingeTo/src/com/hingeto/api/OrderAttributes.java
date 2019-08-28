package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="OrderAttributes", propOrder={"orderAttribute"})
public class OrderAttributes
{

  @XmlElement(name="OrderAttribute", required=true)
  protected List<OrderAttribute> orderAttribute;

  public List<OrderAttribute> getOrderAttribute()
  {
    if (this.orderAttribute == null) {
      this.orderAttribute = new ArrayList();
    }
    return this.orderAttribute;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.OrderAttributes
 * JD-Core Version:    0.6.0
 */