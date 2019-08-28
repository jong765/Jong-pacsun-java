package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="VariationTheme", propOrder={"variationAttributeName"})
public class VariationTheme
{

  @XmlElement(name="VariationAttributeName", required=true)
  protected List<VariationAttributeName> variationAttributeName;

  public List<VariationAttributeName> getVariationAttributeName()
  {
    if (this.variationAttributeName == null) {
      this.variationAttributeName = new ArrayList();
    }
    return this.variationAttributeName;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.VariationTheme
 * JD-Core Version:    0.6.0
 */