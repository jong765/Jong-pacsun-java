package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ListingIDType", propOrder={"effectiveSupplierID", "identifier"})
public class ListingIDType
{

  @XmlElement(name="EffectiveSupplierID", required=true)
  protected String effectiveSupplierID;

  @XmlElement(name="Identifier", required=true)
  protected String identifier;

  public String getEffectiveSupplierID()
  {
    return this.effectiveSupplierID;
  }

  public void setEffectiveSupplierID(String value)
  {
    this.effectiveSupplierID = value;
  }

  public String getIdentifier()
  {
    return this.identifier;
  }

  public void setIdentifier(String value)
  {
    this.identifier = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ListingIDType
 * JD-Core Version:    0.6.0
 */