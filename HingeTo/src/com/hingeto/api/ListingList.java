package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ListingList", propOrder={"listing"})
public class ListingList
{

  @XmlElement(name="Listing", required=true)
  protected List<ListingMessage> listing;

  public List<ListingMessage> getListing()
  {
    if (this.listing == null) {
      this.listing = new ArrayList();
    }
    return this.listing;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ListingList
 * JD-Core Version:    0.6.0
 */