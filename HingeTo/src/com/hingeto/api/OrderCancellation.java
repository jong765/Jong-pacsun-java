package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="OrderCancellation", propOrder={"cancelReason", "cancellationItem"})
public class OrderCancellation
{

  @XmlElement(name="CancelReason")
  protected String cancelReason;

  @XmlElement(name="CancellationItem", required=true)
  protected List<CancellationItem> cancellationItem;

  public String getCancelReason()
  {
    return this.cancelReason;
  }

  public void setCancelReason(String value)
  {
    this.cancelReason = value;
  }

  public List<CancellationItem> getCancellationItem()
  {
    if (this.cancellationItem == null) {
      this.cancellationItem = new ArrayList();
    }
    return this.cancellationItem;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.OrderCancellation
 * JD-Core Version:    0.6.0
 */