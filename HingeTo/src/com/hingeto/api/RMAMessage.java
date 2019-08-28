package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="RMAMessage", propOrder={"orderID", "rma", "rmaDate", "returnReason", "rmaItem", "rmaAttributes"})
public class RMAMessage extends Message
{

  @XmlElement(name="OrderID", required=true)
  protected String orderID;

  @XmlElement(name="RMA", required=true)
  protected String rma;

  @XmlElement(name="RMADate")
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar rmaDate;

  @XmlElement(name="ReturnReason")
  protected String returnReason;

  @XmlElement(name="RMAItem", required=true)
  protected List<RMAItem> rmaItem;

  @XmlElement(name="RMAAttributes")
  protected OrderAttributes rmaAttributes;

  public String getOrderID()
  {
    return this.orderID;
  }

  public void setOrderID(String value)
  {
    this.orderID = value;
  }

  public String getRMA()
  {
    return this.rma;
  }

  public void setRMA(String value)
  {
    this.rma = value;
  }

  public XMLGregorianCalendar getRMADate()
  {
    return this.rmaDate;
  }

  public void setRMADate(XMLGregorianCalendar value)
  {
    this.rmaDate = value;
  }

  public String getReturnReason()
  {
    return this.returnReason;
  }

  public void setReturnReason(String value)
  {
    this.returnReason = value;
  }

  public List<RMAItem> getRMAItem()
  {
    if (this.rmaItem == null) {
      this.rmaItem = new ArrayList();
    }
    return this.rmaItem;
  }

  public OrderAttributes getRMAAttributes()
  {
    return this.rmaAttributes;
  }

  public void setRMAAttributes(OrderAttributes value)
  {
    this.rmaAttributes = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.RMAMessage
 * JD-Core Version:    0.6.0
 */