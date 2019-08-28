package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Variations", propOrder={"variationTheme", "variation"})
public class Variations
{

  @XmlElement(name="VariationTheme", required=true)
  protected VariationTheme variationTheme;

  @XmlElement(name="Variation")
  protected List<VariationChildren> variation;

  public VariationTheme getVariationTheme()
  {
    return this.variationTheme;
  }

  public void setVariationTheme(VariationTheme value)
  {
    this.variationTheme = value;
  }

  public List<VariationChildren> getVariation()
  {
    if (this.variation == null) {
      this.variation = new ArrayList();
    }
    return this.variation;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.Variations
 * JD-Core Version:    0.6.0
 */