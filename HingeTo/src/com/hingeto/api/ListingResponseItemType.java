package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ListingResponseItemType", propOrder={"listingID", "result", "message"})
public class ListingResponseItemType
{

  @XmlElement(name="ListingID", required=true)
  protected ListingIDType listingID;

  @XmlElement(name="Result", required=true)
  protected ProcessingResult result;

  @XmlElement(name="Message")
  protected String message;

  public ListingIDType getListingID()
  {
    return this.listingID;
  }

  public void setListingID(ListingIDType value)
  {
    this.listingID = value;
  }

  public ProcessingResult getResult()
  {
    return this.result;
  }

  public void setResult(ProcessingResult value)
  {
    this.result = value;
  }

  public String getMessage()
  {
    return this.message;
  }

  public void setMessage(String value)
  {
    this.message = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ListingResponseItemType
 * JD-Core Version:    0.6.0
 */