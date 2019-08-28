package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="FullProductList", propOrder={"fullProduct"})
public class FullProductList
{

  @XmlElement(name="FullProduct", required=true)
  protected List<FullProductMessage> fullProduct;

  public List<FullProductMessage> getFullProduct()
  {
    if (this.fullProduct == null) {
      this.fullProduct = new ArrayList();
    }
    return this.fullProduct;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.FullProductList
 * JD-Core Version:    0.6.0
 */