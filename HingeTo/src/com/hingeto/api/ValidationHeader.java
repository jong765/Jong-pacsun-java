package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="validationHeader")
public class ValidationHeader
{

  @XmlAttribute(name="documentId")
  protected String documentId;

  public String getDocumentId()
  {
    return this.documentId;
  }

  public void setDocumentId(String value)
  {
    this.documentId = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ValidationHeader
 * JD-Core Version:    0.6.0
 */