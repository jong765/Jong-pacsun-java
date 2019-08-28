package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="OrderState", propOrder={"state", "message", "stateItem"})
public class OrderState
{

  @XmlElement(name="State", required=true)
  protected String state;

  @XmlElement(name="Message")
  protected String message;

  @XmlElement(name="StateItem")
  protected List<StateItem> stateItem;

  public String getState()
  {
    return this.state;
  }

  public void setState(String value)
  {
    this.state = value;
  }

  public String getMessage()
  {
    return this.message;
  }

  public void setMessage(String value)
  {
    this.message = value;
  }

  public List<StateItem> getStateItem()
  {
    if (this.stateItem == null) {
      this.stateItem = new ArrayList();
    }
    return this.stateItem;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.OrderState
 * JD-Core Version:    0.6.0
 */