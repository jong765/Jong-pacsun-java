package com.pacsun.hingeto.orderimport.builder;

import com.hingeto.api.SalesOrderMessage;
import com.pacsun.hingeto.orderimport.dto.OrderHeaderDto;

public abstract interface Builder
{
  public abstract SalesOrderMessage build(SalesOrderMessage paramSalesOrderMessage, OrderHeaderDto paramOrderHeaderDto)
    throws Exception;
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderimport.jar
 * Qualified Name:     com.pacsun.hingeto.orderimport.builder.Builder
 * JD-Core Version:    0.6.0
 */