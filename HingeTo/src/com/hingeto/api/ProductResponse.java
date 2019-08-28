package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ProductResponse", propOrder={"productResponseItem"})
public class ProductResponse
{

  @XmlElement(name="ProductResponseItem", required=true)
  protected List<ProductResponseItem> productResponseItem;

  public List<ProductResponseItem> getProductResponseItem()
  {
    if (this.productResponseItem == null) {
      this.productResponseItem = new ArrayList();
    }
    return this.productResponseItem;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ProductResponse
 * JD-Core Version:    0.6.0
 */