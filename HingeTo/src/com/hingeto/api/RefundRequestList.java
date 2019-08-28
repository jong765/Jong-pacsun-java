package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="RefundRequestList", propOrder={"refundRequest"})
public class RefundRequestList
{

  @XmlElement(name="RefundRequest", required=true)
  protected List<RefundRequestMessage> refundRequest;

  public List<RefundRequestMessage> getRefundRequest()
  {
    if (this.refundRequest == null) {
      this.refundRequest = new ArrayList();
    }
    return this.refundRequest;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.RefundRequestList
 * JD-Core Version:    0.6.0
 */