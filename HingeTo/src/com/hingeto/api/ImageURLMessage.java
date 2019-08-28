package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ImageURLMessage", propOrder={"imageURLData"})
public class ImageURLMessage extends ProductMessage
{

  @XmlElement(name="ImageURLData", required=true)
  protected ImageURLData imageURLData;

  public ImageURLData getImageURLData()
  {
    return this.imageURLData;
  }

  public void setImageURLData(ImageURLData value)
  {
    this.imageURLData = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ImageURLMessage
 * JD-Core Version:    0.6.0
 */