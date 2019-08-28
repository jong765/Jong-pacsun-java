package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ResponseItem", propOrder={"feedMessageID", "id", "result", "error"})
public class ResponseItem
{

  @XmlElement(name="FeedMessageID", required=true)
  protected String feedMessageID;

  @XmlElement(name="ID", required=true)
  protected List<DataID> id;

  @XmlElement(name="Result", required=true)
  protected ProcessingResult result;

  @XmlElement(name="Error")
  protected List<String> error;

  public String getFeedMessageID()
  {
    return this.feedMessageID;
  }

  public void setFeedMessageID(String value)
  {
    this.feedMessageID = value;
  }

  public List<DataID> getID()
  {
    if (this.id == null) {
      this.id = new ArrayList();
    }
    return this.id;
  }

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
 * Qualified Name:     com.hingeto.api.ResponseItem
 * JD-Core Version:    0.6.0
 */