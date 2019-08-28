package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SalePrice", propOrder={"price", "startDate", "endDate"})
public class SalePrice
{

  @XmlElement(name="Price", required=true)
  protected CurrencyPrice price;

  @XmlElement(name="StartDate", required=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar startDate;

  @XmlElement(name="EndDate", required=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar endDate;

  public CurrencyPrice getPrice()
  {
    return this.price;
  }

  public void setPrice(CurrencyPrice value)
  {
    this.price = value;
  }

  public XMLGregorianCalendar getStartDate()
  {
    return this.startDate;
  }

  public void setStartDate(XMLGregorianCalendar value)
  {
    this.startDate = value;
  }

  public XMLGregorianCalendar getEndDate()
  {
    return this.endDate;
  }

  public void setEndDate(XMLGregorianCalendar value)
  {
    this.endDate = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.SalePrice
 * JD-Core Version:    0.6.0
 */