package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="NewProductAuthorizationResponseItem", propOrder={"sku", "result", "message", "content"})
public class NewProductAuthorizationResponseItem
{

  @XmlElement(name="SKU", required=true)
  protected String sku;

  @XmlElement(name="Result", required=true)
  protected ProcessingResult result;

  @XmlElement(name="Message")
  protected String message;

  @XmlElement(name="Content")
  protected NewProductAuthorizationResponseContent content;

  public String getSKU()
  {
    return this.sku;
  }

  public void setSKU(String value)
  {
    this.sku = value;
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

  public NewProductAuthorizationResponseContent getContent()
  {
    return this.content;
  }

  public void setContent(NewProductAuthorizationResponseContent value)
  {
    this.content = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.NewProductAuthorizationResponseItem
 * JD-Core Version:    0.6.0
 */