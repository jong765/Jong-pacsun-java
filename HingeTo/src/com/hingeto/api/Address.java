package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Address", propOrder={"name", "addressFieldOne", "addressFieldTwo", "addressFieldThree", "city", "stateOrRegion", "postalCode", "countryCode", "phoneNumber"})
public class Address
{

  @XmlElement(name="Name")
  protected String name;

  @XmlElement(name="AddressFieldOne")
  protected String addressFieldOne;

  @XmlElement(name="AddressFieldTwo")
  protected String addressFieldTwo;

  @XmlElement(name="AddressFieldThree")
  protected String addressFieldThree;

  @XmlElement(name="City")
  protected String city;

  @XmlElement(name="StateOrRegion")
  protected String stateOrRegion;

  @XmlElement(name="PostalCode")
  protected String postalCode;

  @XmlElement(name="CountryCode")
  protected String countryCode;

  @XmlElement(name="PhoneNumber")
  protected String phoneNumber;

  public String getName()
  {
    return this.name;
  }

  public void setName(String value)
  {
    this.name = value;
  }

  public String getAddressFieldOne()
  {
    return this.addressFieldOne;
  }

  public void setAddressFieldOne(String value)
  {
    this.addressFieldOne = value;
  }

  public String getAddressFieldTwo()
  {
    return this.addressFieldTwo;
  }

  public void setAddressFieldTwo(String value)
  {
    this.addressFieldTwo = value;
  }

  public String getAddressFieldThree()
  {
    return this.addressFieldThree;
  }

  public void setAddressFieldThree(String value)
  {
    this.addressFieldThree = value;
  }

  public String getCity()
  {
    return this.city;
  }

  public void setCity(String value)
  {
    this.city = value;
  }

  public String getStateOrRegion()
  {
    return this.stateOrRegion;
  }

  public void setStateOrRegion(String value)
  {
    this.stateOrRegion = value;
  }

  public String getPostalCode()
  {
    return this.postalCode;
  }

  public void setPostalCode(String value)
  {
    this.postalCode = value;
  }

  public String getCountryCode()
  {
    return this.countryCode;
  }

  public void setCountryCode(String value)
  {
    this.countryCode = value;
  }

  public String getPhoneNumber()
  {
    return this.phoneNumber;
  }

  public void setPhoneNumber(String value)
  {
    this.phoneNumber = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.Address
 * JD-Core Version:    0.6.0
 */