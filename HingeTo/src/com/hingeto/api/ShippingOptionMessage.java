package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ShippingOptionMessage", propOrder={"optionName", "daysRange", "shippingCostModel", "modelUnit", "shippingModel"})
public class ShippingOptionMessage extends Message
{

  @XmlElement(name="OptionName", required=true)
  protected String optionName;

  @XmlElement(name="DaysRange", required=true)
  protected String daysRange;

  @XmlElement(name="ShippingCostModel", required=true)
  protected ShippingCostModel shippingCostModel;

  @XmlElement(name="ModelUnit")
  protected ShippingModelUnits modelUnit;

  @XmlElement(name="ShippingModel")
  protected List<ShippingModel> shippingModel;

  public String getOptionName()
  {
    return this.optionName;
  }

  public void setOptionName(String value)
  {
    this.optionName = value;
  }

  public String getDaysRange()
  {
    return this.daysRange;
  }

  public void setDaysRange(String value)
  {
    this.daysRange = value;
  }

  public ShippingCostModel getShippingCostModel()
  {
    return this.shippingCostModel;
  }

  public void setShippingCostModel(ShippingCostModel value)
  {
    this.shippingCostModel = value;
  }

  public ShippingModelUnits getModelUnit()
  {
    return this.modelUnit;
  }

  public void setModelUnit(ShippingModelUnits value)
  {
    this.modelUnit = value;
  }

  public List<ShippingModel> getShippingModel()
  {
    if (this.shippingModel == null) {
      this.shippingModel = new ArrayList();
    }
    return this.shippingModel;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ShippingOptionMessage
 * JD-Core Version:    0.6.0
 */