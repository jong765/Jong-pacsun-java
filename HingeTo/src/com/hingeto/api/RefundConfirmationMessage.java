package com.hingeto.api;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="RefundConfirmationMessage", propOrder={"currency", "refundAmount", "refundAttributes"})
public class RefundConfirmationMessage
{

  @XmlElement(name="Currency", required=true)
  protected String currency;

  @XmlElement(name="RefundAmount", required=true)
  protected BigDecimal refundAmount;

  @XmlElement(name="RefundAttributes")
  protected OrderAttributes refundAttributes;

  public String getCurrency()
  {
    return this.currency;
  }

  public void setCurrency(String value)
  {
    this.currency = value;
  }

  public BigDecimal getRefundAmount()
  {
    return this.refundAmount;
  }

  public void setRefundAmount(BigDecimal value)
  {
    this.refundAmount = value;
  }

  public OrderAttributes getRefundAttributes()
  {
    return this.refundAttributes;
  }

  public void setRefundAttributes(OrderAttributes value)
  {
    this.refundAttributes = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.RefundConfirmationMessage
 * JD-Core Version:    0.6.0
 */