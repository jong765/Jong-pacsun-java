package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="NewProductAuthorizationResponse", propOrder={"productResponseItem"})
public class NewProductAuthorizationResponse
{

  @XmlElement(name="ProductResponseItem", required=true)
  protected List<NewProductAuthorizationResponseItem> productResponseItem;

  public List<NewProductAuthorizationResponseItem> getProductResponseItem()
  {
    if (this.productResponseItem == null) {
      this.productResponseItem = new ArrayList();
    }
    return this.productResponseItem;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.NewProductAuthorizationResponse
 * JD-Core Version:    0.6.0
 */