package com.hingeto.api;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ShippingBand", propOrder={"from", "to", "fee"})
public class ShippingBand
{

  @XmlElement(name="From", required=true)
  protected BigDecimal from;

  @XmlElement(name="To")
  protected BigDecimal to;

  @XmlElement(name="Fee", required=true)
  protected BigDecimal fee;

  public BigDecimal getFrom()
  {
    return this.from;
  }

  public void setFrom(BigDecimal value)
  {
    this.from = value;
  }

  public BigDecimal getTo()
  {
    return this.to;
  }

  public void setTo(BigDecimal value)
  {
    this.to = value;
  }

  public BigDecimal getFee()
  {
    return this.fee;
  }

  public void setFee(BigDecimal value)
  {
    this.fee = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ShippingBand
 * JD-Core Version:    0.6.0
 */