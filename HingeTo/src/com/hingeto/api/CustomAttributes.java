package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="CustomAttributes", propOrder={"attribute"})
public class CustomAttributes
{

  @XmlElement(name="Attribute", required=true)
  protected List<CustomAttribute> attribute;

  public List<CustomAttribute> getAttribute()
  {
    if (this.attribute == null) {
      this.attribute = new ArrayList();
    }
    return this.attribute;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.CustomAttributes
 * JD-Core Version:    0.6.0
 */