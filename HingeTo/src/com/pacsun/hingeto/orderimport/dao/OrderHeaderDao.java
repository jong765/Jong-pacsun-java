package com.pacsun.hingeto.orderimport.dao;

import com.pacsun.hingeto.orderimport.dto.OrderHeaderDto;
import java.util.List;

public abstract interface OrderHeaderDao
{
  public abstract List<OrderHeaderDto> findUnprocessedOrders()
    throws Exception;

  public abstract void updateProcessedBatch(List<OrderHeaderDto> paramList)
    throws Exception;
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderimport.jar
 * Qualified Name:     com.pacsun.hingeto.orderimport.dao.OrderHeaderDao
 * JD-Core Version:    0.6.0
 */