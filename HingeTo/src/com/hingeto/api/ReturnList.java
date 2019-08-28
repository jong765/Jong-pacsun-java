package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ReturnList", propOrder={"_return"})
public class ReturnList
{

  @XmlElement(name="Return", required=true)
  protected List<ReturnMessage> _return;

  public List<ReturnMessage> getReturn()
  {
    if (this._return == null) {
      this._return = new ArrayList();
    }
    return this._return;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ReturnList
 * JD-Core Version:    0.6.0
 */