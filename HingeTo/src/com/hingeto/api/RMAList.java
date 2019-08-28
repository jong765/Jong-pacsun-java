package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="RMAList", propOrder={"rmaMessage"})
public class RMAList
{

  @XmlElement(name="RMAMessage", required=true)
  protected List<RMAMessage> rmaMessage;

  public List<RMAMessage> getRMAMessage()
  {
    if (this.rmaMessage == null) {
      this.rmaMessage = new ArrayList();
    }
    return this.rmaMessage;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.RMAList
 * JD-Core Version:    0.6.0
 */