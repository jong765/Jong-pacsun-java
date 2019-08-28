package com.pacsun.hingeto.orderstatusexport.dto;

public class ItemDto
{
  private String orderItemCode;
  private String lineItemId;
  private String effectiveSupplierID;
  private String identifier;

  public String getOrderItemCode()
  {
    return this.orderItemCode;
  }

  public void setOrderItemCode(String orderItemCode) {
    this.orderItemCode = orderItemCode;
  }

  public String getLineItemId() {
    return this.lineItemId;
  }

  public void setLineItemId(String lineItemId) {
    this.lineItemId = lineItemId;
  }

  public String getEffectiveSupplierID() {
    return this.effectiveSupplierID;
  }

  public void setEffectiveSupplierID(String effectiveSupplierID) {
    this.effectiveSupplierID = effectiveSupplierID;
  }

  public String getIdentifier() {
    return this.identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderstatusexport.jar
 * Qualified Name:     com.pacsun.hingeto.orderstatusexport.dto.ItemDto
 * JD-Core Version:    0.6.0
 */