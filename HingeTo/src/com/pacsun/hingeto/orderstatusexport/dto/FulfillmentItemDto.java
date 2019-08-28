package com.pacsun.hingeto.orderstatusexport.dto;

public class FulfillmentItemDto extends ItemDto
{
  private int fulfilledQty;

  public int getFulfilledQty()
  {
    return this.fulfilledQty;
  }

  public void setFulfilledQty(int fulfilledQty) {
    this.fulfilledQty = fulfilledQty;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderstatusexport.jar
 * Qualified Name:     com.pacsun.hingeto.orderstatusexport.dto.FulfillmentItemDto
 * JD-Core Version:    0.6.0
 */