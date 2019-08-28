package com.pacsun.hingeto.orderstatusexport.dto;

import java.util.List;

public class CancelTransactionDto extends TransactionDto
{
  private List<CancellationItemDto> cancellationItemDtoList;

  public List<CancellationItemDto> getCancellationItemDtoList()
  {
    return this.cancellationItemDtoList;
  }

  public void setCancellationItemDtoList(List<CancellationItemDto> cancellationItemDtoList) {
    this.cancellationItemDtoList = cancellationItemDtoList;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderstatusexport.jar
 * Qualified Name:     com.pacsun.hingeto.orderstatusexport.dto.CancelTransactionDto
 * JD-Core Version:    0.6.0
 */