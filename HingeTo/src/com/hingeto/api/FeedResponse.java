package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="FeedResponse", propOrder={"result", "error"})
public class FeedResponse
{

  @XmlElement(name="Result", required=true)
  protected ProcessingResult result;

  @XmlElement(name="Error", required=true)
  protected List<String> error;

  public ProcessingResult getResult()
  {
    return this.result;
  }

  public void setResult(ProcessingResult value)
  {
    this.result = value;
  }

  public List<String> getError()
  {
    if (this.error == null) {
      this.error = new ArrayList();
    }
    return this.error;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.FeedResponse
 * JD-Core Version:    0.6.0
 */