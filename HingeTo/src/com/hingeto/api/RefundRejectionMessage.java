package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="RefundRejectionMessage", propOrder={"reason", "refundAttributes"})
public class RefundRejectionMessage
{

  @XmlElement(name="Reason", required=true)
  protected String reason;

  @XmlElement(name="RefundAttributes")
  protected OrderAttributes refundAttributes;

  public String getReason()
  {
    return this.reason;
  }

  public void setReason(String value)
  {
    this.reason = value;
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
 * Qualified Name:     com.hingeto.api.RefundRejectionMessage
 * JD-Core Version:    0.6.0
 */