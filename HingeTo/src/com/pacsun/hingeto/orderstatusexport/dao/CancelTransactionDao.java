package com.pacsun.hingeto.orderstatusexport.dao;

import com.pacsun.hingeto.orderstatusexport.dto.CancelTransactionDto;
import java.util.List;

public abstract interface CancelTransactionDao
{
  public abstract void insertBatch(List<CancelTransactionDto> paramList, String paramString)
    throws Exception;
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderstatusexport.jar
 * Qualified Name:     com.pacsun.hingeto.orderstatusexport.dao.CancelTransactionDao
 * JD-Core Version:    0.6.0
 */