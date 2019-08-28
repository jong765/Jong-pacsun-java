package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ProductResponseItem", propOrder={"sku", "storefrontProductID", "result", "message"})
public class ProductResponseItem
{

  @XmlElement(name="SKU")
  protected String sku;

  @XmlElement(name="StorefrontProductID")
  protected String storefrontProductID;

  @XmlElement(name="Result", required=true)
  protected ProcessingResult result;

  @XmlElement(name="Message")
  protected String message;

  public String getSKU()
  {
    return this.sku;
  }

  public void setSKU(String value)
  {
    this.sku = value;
  }

  public String getStorefrontProductID()
  {
    return this.storefrontProductID;
  }

  public void setStorefrontProductID(String value)
  {
    this.storefrontProductID = value;
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
 * Qualified Name:     com.hingeto.api.ProductResponseItem
 * JD-Core Version:    0.6.0
 */