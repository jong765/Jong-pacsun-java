package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="BillingData", propOrder={"buyerEmailAddress", "buyerName", "buyerPhoneNumber", "paymentInfo", "billingAddress"})
public class BillingData
{

  @XmlElement(name="BuyerEmailAddress")
  @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
  protected String buyerEmailAddress;

  @XmlElement(name="BuyerName")
  protected String buyerName;

  @XmlElement(name="BuyerPhoneNumber")
  protected String buyerPhoneNumber;

  @XmlElement(name="PaymentInfo")
  protected String paymentInfo;

  @XmlElement(name="BillingAddress")
  protected Address billingAddress;

  public String getBuyerEmailAddress()
  {
    return this.buyerEmailAddress;
  }

  public void setBuyerEmailAddress(String value)
  {
    this.buyerEmailAddress = value;
  }

  public String getBuyerName()
  {
    return this.buyerName;
  }

  public void setBuyerName(String value)
  {
    this.buyerName = value;
  }

  public String getBuyerPhoneNumber()
  {
    return this.buyerPhoneNumber;
  }

  public void setBuyerPhoneNumber(String value)
  {
    this.buyerPhoneNumber = value;
  }

  public String getPaymentInfo()
  {
    return this.paymentInfo;
  }

  public void setPaymentInfo(String value)
  {
    this.paymentInfo = value;
  }

  public Address getBillingAddress()
  {
    return this.billingAddress;
  }

  public void setBillingAddress(Address value)
  {
    this.billingAddress = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.BillingData
 * JD-Core Version:    0.6.0
 */