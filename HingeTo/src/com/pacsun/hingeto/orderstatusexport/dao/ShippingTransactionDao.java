package com.pacsun.hingeto.orderstatusexport.dao;

import com.pacsun.hingeto.orderstatusexport.dto.ShippingTransactionDto;
import java.util.List;

public abstract interface ShippingTransactionDao
{
  public abstract void insertBatch(List<ShippingTransactionDto> paramList, String paramString)
    throws Exception;
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderstatusexport.jar
 * Qualified Name:     com.pacsun.hingeto.orderstatusexport.dao.ShippingTransactionDao
 * JD-Core Version:    0.6.0
 */