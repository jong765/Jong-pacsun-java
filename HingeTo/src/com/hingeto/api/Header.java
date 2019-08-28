package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Header", propOrder={"documentGUID", "documentCreationDate", "senderID", "senderName", "sourceChannelID", "receiverID", "destinationChannelID"})
public class Header
{

  @XmlElement(name="DocumentGUID", required=true)
  protected String documentGUID;

  @XmlElement(name="DocumentCreationDate", required=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar documentCreationDate;

  @XmlElement(name="SenderID", required=true)
  protected String senderID;

  @XmlElement(name="SenderName", required=true)
  protected String senderName;

  @XmlElement(name="SourceChannelID", required=true)
  protected String sourceChannelID;

  @XmlElement(name="ReceiverID", required=true)
  protected String receiverID;

  @XmlElement(name="DestinationChannelID", required=true)
  protected String destinationChannelID;

  public String getDocumentGUID()
  {
    return this.documentGUID;
  }

  public void setDocumentGUID(String value)
  {
    this.documentGUID = value;
  }

  public XMLGregorianCalendar getDocumentCreationDate()
  {
    return this.documentCreationDate;
  }

  public void setDocumentCreationDate(XMLGregorianCalendar value)
  {
    this.documentCreationDate = value;
  }

  public String getSenderID()
  {
    return this.senderID;
  }

  public void setSenderID(String value)
  {
    this.senderID = value;
  }

  public String getSenderName()
  {
    return this.senderName;
  }

  public void setSenderName(String value)
  {
    this.senderName = value;
  }

  public String getSourceChannelID()
  {
    return this.sourceChannelID;
  }

  public void setSourceChannelID(String value)
  {
    this.sourceChannelID = value;
  }

  public String getReceiverID()
  {
    return this.receiverID;
  }

  public void setReceiverID(String value)
  {
    this.receiverID = value;
  }

  public String getDestinationChannelID()
  {
    return this.destinationChannelID;
  }

  public void setDestinationChannelID(String value)
  {
    this.destinationChannelID = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.Header
 * JD-Core Version:    0.6.0
 */