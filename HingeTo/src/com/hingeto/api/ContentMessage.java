package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ContentMessage", propOrder={"productContent"})
@XmlSeeAlso({FullProductMessage.class})
public class ContentMessage extends ProductMessage
{

  @XmlElement(name="ProductContent", required=true)
  protected ProductContentType productContent;

  @XmlAttribute(name="action")
  protected MessageAction action;

  public ProductContentType getProductContent()
  {
    return this.productContent;
  }

  public void setProductContent(ProductContentType value)
  {
    this.productContent = value;
  }

  public MessageAction getAction()
  {
    if (this.action == null) {
      return MessageAction.UPDATE;
    }
    return this.action;
  }

  public void setAction(MessageAction value)
  {
    this.action = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ContentMessage
 * JD-Core Version:    0.6.0
 */