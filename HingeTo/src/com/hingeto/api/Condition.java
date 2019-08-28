package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Condition", propOrder={"conditionValue", "conditionFreeText"})
public class Condition
{

  @XmlElement(name="ConditionValue")
  protected ConditionDictionary conditionValue;

  @XmlElement(name="ConditionFreeText")
  protected String conditionFreeText;

  public ConditionDictionary getConditionValue()
  {
    return this.conditionValue;
  }

  public void setConditionValue(ConditionDictionary value)
  {
    this.conditionValue = value;
  }

  public String getConditionFreeText()
  {
    return this.conditionFreeText;
  }

  public void setConditionFreeText(String value)
  {
    this.conditionFreeText = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.Condition
 * JD-Core Version:    0.6.0
 */