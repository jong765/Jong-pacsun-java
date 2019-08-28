package com.hingeto.api;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="CurrencyPrice", propOrder={"value"})
public class CurrencyPrice
{

  @XmlValue
  protected BigDecimal value;

  @XmlAttribute(name="currency", required=true)
  protected String currency;

  @XmlAttribute(name="modifier")
  protected String modifier;

  public BigDecimal getValue()
  {
    return this.value;
  }

  public void setValue(BigDecimal value)
  {
    this.value = value;
  }

  public String getCurrency()
  {
    return this.currency;
  }

  public void setCurrency(String value)
  {
    this.currency = value;
  }

  public String getModifier()
  {
    return this.modifier;
  }

  public void setModifier(String value)
  {
    this.modifier = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.CurrencyPrice
 * JD-Core Version:    0.6.0
 */