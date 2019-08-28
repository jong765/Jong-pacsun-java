package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ProcessingResponse", propOrder={"responseItem", "feedResponse"})
public class ProcessingResponse
{

  @XmlElement(name="ResponseItem")
  protected List<ResponseItem> responseItem;

  @XmlElement(name="FeedResponse")
  protected FeedResponse feedResponse;

  public List<ResponseItem> getResponseItem()
  {
    if (this.responseItem == null) {
      this.responseItem = new ArrayList();
    }
    return this.responseItem;
  }

  public FeedResponse getFeedResponse()
  {
    return this.feedResponse;
  }

  public void setFeedResponse(FeedResponse value)
  {
    this.feedResponse = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ProcessingResponse
 * JD-Core Version:    0.6.0
 */