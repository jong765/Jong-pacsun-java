package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="RefundList", propOrder={"refund"})
public class RefundList
{

  @XmlElement(name="Refund", required=true)
  protected List<RefundMessage> refund;

  public List<RefundMessage> getRefund()
  {
    if (this.refund == null) {
      this.refund = new ArrayList();
    }
    return this.refund;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.RefundList
 * JD-Core Version:    0.6.0
 */