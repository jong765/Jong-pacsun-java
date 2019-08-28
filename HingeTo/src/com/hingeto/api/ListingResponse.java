package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ListingResponse", propOrder={"listingResponseItem"})
public class ListingResponse
{

  @XmlElement(name="ListingResponseItem", required=true)
  protected List<ListingResponseItemType> listingResponseItem;

  public List<ListingResponseItemType> getListingResponseItem()
  {
    if (this.listingResponseItem == null) {
      this.listingResponseItem = new ArrayList();
    }
    return this.listingResponseItem;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ListingResponse
 * JD-Core Version:    0.6.0
 */