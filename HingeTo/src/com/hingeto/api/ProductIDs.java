package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ProductIDs", propOrder={"upc", "ean", "gtin", "isbn"})
public class ProductIDs
{

  @XmlElement(name="UPC")
  protected String upc;

  @XmlElement(name="EAN")
  protected String ean;

  @XmlElement(name="GTIN")
  protected String gtin;

  @XmlElement(name="ISBN")
  protected String isbn;

  public String getUPC()
  {
    return this.upc;
  }

  public void setUPC(String value)
  {
    this.upc = value;
  }

  public String getEAN()
  {
    return this.ean;
  }

  public void setEAN(String value)
  {
    this.ean = value;
  }

  public String getGTIN()
  {
    return this.gtin;
  }

  public void setGTIN(String value)
  {
    this.gtin = value;
  }

  public String getISBN()
  {
    return this.isbn;
  }

  public void setISBN(String value)
  {
    this.isbn = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ProductIDs
 * JD-Core Version:    0.6.0
 */