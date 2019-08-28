package com.pacsun.hingeto.listingexport.dao;

import com.pacsun.hingeto.listingexport.dto.InventoryDto;
import com.pacsun.hingeto.listingexport.dto.ListingResponseDto;
import java.util.List;

public abstract interface InventoryDao
{
  public abstract void insertBatch(List<InventoryDto> paramList, String paramString)
    throws Exception;

  public abstract void deleteAll()
    throws Exception;

  public abstract List<ListingResponseDto> findInventoryRecordsForResponse()
    throws Exception;
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_listingexport.jar
 * Qualified Name:     com.pacsun.hingeto.listingexport.dao.InventoryDao
 * JD-Core Version:    0.6.0
 */