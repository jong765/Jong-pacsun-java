package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="CategoryAssignmentMessage", propOrder={"categoryAssignmentData"})
public class CategoryAssignmentMessage extends ProductMessage
{

  @XmlElement(name="CategoryAssignmentData", required=true)
  protected CategoryAssignmentData categoryAssignmentData;

  public CategoryAssignmentData getCategoryAssignmentData()
  {
    return this.categoryAssignmentData;
  }

  public void setCategoryAssignmentData(CategoryAssignmentData value)
  {
    this.categoryAssignmentData = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.CategoryAssignmentMessage
 * JD-Core Version:    0.6.0
 */