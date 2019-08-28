package com.hingeto.api;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="OrderItemPrice", propOrder={"value"})
public class OrderItemPrice
{

  @XmlValue
  protected BigDecimal value;

  @XmlAttribute(name="type", required=true)
  protected OrderItemPriceType type;

  public BigDecimal getValue()
  {
    return this.value;
  }

  public void setValue(BigDecimal value)
  {
    this.value = value;
  }

  public OrderItemPriceType getType()
  {
    return this.type;
  }

  public void setType(OrderItemPriceType value)
  {
    this.type = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.OrderItemPrice
 * JD-Core Version:    0.6.0
 */