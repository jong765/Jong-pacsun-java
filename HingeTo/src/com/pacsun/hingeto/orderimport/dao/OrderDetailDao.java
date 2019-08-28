package com.pacsun.hingeto.orderimport.dao;

import com.pacsun.hingeto.orderimport.dto.OrderDetailDto;
import java.util.List;

public abstract interface OrderDetailDao
{
  public abstract List<OrderDetailDto> findByMessageIdAndOrderId(String paramString, int paramInt)
    throws Exception;
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderimport.jar
 * Qualified Name:     com.pacsun.hingeto.orderimport.dao.OrderDetailDao
 * JD-Core Version:    0.6.0
 */