package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="NamedAttributeList", propOrder={"values"})
@XmlSeeAlso({ProductAttributeList.class})
public class NamedAttributeList
{

  @XmlElement(required=true)
  protected Values values;

  public Values getValues()
  {
    return this.values;
  }

  public void setValues(Values value)
  {
    this.values = value;
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name="", propOrder={"value"})
  public static class Values
  {

    @XmlElement(required=true)
    protected List<String> value;

    public List<String> getValue()
    {
      if (this.value == null) {
        this.value = new ArrayList();
      }
      return this.value;
    }
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.NamedAttributeList
 * JD-Core Version:    0.6.0
 */