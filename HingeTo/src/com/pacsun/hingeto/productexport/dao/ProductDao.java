package com.pacsun.hingeto.productexport.dao;

import com.pacsun.hingeto.productexport.dto.ProductDto;
import java.util.List;

public abstract interface ProductDao
{
  public abstract void insertBatch(List<ProductDto> paramList, String paramString)
    throws Exception;
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_productexport.jar
 * Qualified Name:     com.pacsun.hingeto.productexport.dao.ProductDao
 * JD-Core Version:    0.6.0
 */