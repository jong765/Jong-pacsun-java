package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="StorefrontTree", propOrder={"preferredLanguage", "category"})
public class StorefrontTree extends Message
{

  @XmlElement(name="PreferredLanguage", required=true)
  protected String preferredLanguage;

  @XmlElement(name="Category")
  protected List<StorefrontCategory> category;

  public String getPreferredLanguage()
  {
    return this.preferredLanguage;
  }

  public void setPreferredLanguage(String value)
  {
    this.preferredLanguage = value;
  }

  public List<StorefrontCategory> getCategory()
  {
    if (this.category == null) {
      this.category = new ArrayList();
    }
    return this.category;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.StorefrontTree
 * JD-Core Version:    0.6.0
 */