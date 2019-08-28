package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="validationResult", propOrder={"message"})
public class ValidationResult
{
  protected List<ValidationMessage> message;

  @XmlAttribute(name="objId")
  protected String objId;

  @XmlAttribute(name="storefrontProductId")
  protected String storefrontProductId;

  public List<ValidationMessage> getMessage()
  {
    if (this.message == null) {
      this.message = new ArrayList();
    }
    return this.message;
  }

  public String getObjId()
  {
    return this.objId;
  }

  public void setObjId(String value)
  {
    this.objId = value;
  }

  public String getStorefrontProductId()
  {
    return this.storefrontProductId;
  }

  public void setStorefrontProductId(String value)
  {
    this.storefrontProductId = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ValidationResult
 * JD-Core Version:    0.6.0
 */