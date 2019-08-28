package com.hingeto.api;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="InventoryData", propOrder={"quantity", "customAttributes"})
public class InventoryData
{

  @XmlElement(name="Quantity", required=true)
  protected BigInteger quantity;

  @XmlElement(name="CustomAttributes")
  protected CustomAttributes customAttributes;

  public BigInteger getQuantity()
  {
    return this.quantity;
  }

  public void setQuantity(BigInteger value)
  {
    this.quantity = value;
  }

  public CustomAttributes getCustomAttributes()
  {
    return this.customAttributes;
  }

  public void setCustomAttributes(CustomAttributes value)
  {
    this.customAttributes = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.InventoryData
 * JD-Core Version:    0.6.0
 */