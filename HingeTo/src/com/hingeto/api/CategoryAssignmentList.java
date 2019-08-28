package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="CategoryAssignmentList", propOrder={"categoryAssignment"})
public class CategoryAssignmentList
{

  @XmlElement(name="CategoryAssignment", required=true)
  protected List<CategoryAssignmentMessage> categoryAssignment;

  public List<CategoryAssignmentMessage> getCategoryAssignment()
  {
    if (this.categoryAssignment == null) {
      this.categoryAssignment = new ArrayList();
    }
    return this.categoryAssignment;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.CategoryAssignmentList
 * JD-Core Version:    0.6.0
 */