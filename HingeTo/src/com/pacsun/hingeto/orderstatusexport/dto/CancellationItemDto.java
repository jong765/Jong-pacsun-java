package com.pacsun.hingeto.orderstatusexport.dto;

public class CancellationItemDto extends ItemDto
{
  private String cancelReason;

  public String getCancelReason()
  {
    return this.cancelReason == null ? "" : this.cancelReason;
  }

  public void setCancelReason(String cancelReason) {
    this.cancelReason = cancelReason;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderstatusexport.jar
 * Qualified Name:     com.pacsun.hingeto.orderstatusexport.dto.CancellationItemDto
 * JD-Core Version:    0.6.0
 */