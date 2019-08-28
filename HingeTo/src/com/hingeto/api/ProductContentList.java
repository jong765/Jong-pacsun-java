package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ProductContentList", propOrder={"productContentMessage"})
public class ProductContentList
{

  @XmlElement(name="ProductContentMessage", required=true)
  protected List<ContentMessage> productContentMessage;

  public List<ContentMessage> getProductContentMessage()
  {
    if (this.productContentMessage == null) {
      this.productContentMessage = new ArrayList();
    }
    return this.productContentMessage;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ProductContentList
 * JD-Core Version:    0.6.0
 */