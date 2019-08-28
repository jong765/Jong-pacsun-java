package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ImageURLData", propOrder={"imageURL"})
public class ImageURLData
{

  @XmlElement(name="ImageURL", required=true)
  protected List<ImageURL> imageURL;

  public List<ImageURL> getImageURL()
  {
    if (this.imageURL == null) {
      this.imageURL = new ArrayList();
    }
    return this.imageURL;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ImageURLData
 * JD-Core Version:    0.6.0
 */