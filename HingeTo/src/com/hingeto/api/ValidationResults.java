package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="validationResults", propOrder={"header", "validationResult"})
public class ValidationResults
{

  @XmlElement(required=true)
  protected ValidationHeader header;
  protected List<ValidationResult> validationResult;

  public ValidationHeader getHeader()
  {
    return this.header;
  }

  public void setHeader(ValidationHeader value)
  {
    this.header = value;
  }

  public List<ValidationResult> getValidationResult()
  {
    if (this.validationResult == null) {
      this.validationResult = new ArrayList();
    }
    return this.validationResult;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.ValidationResults
 * JD-Core Version:    0.6.0
 */