package com.pacsun.hingeto.orderimport.builder;

import com.hingeto.api.ObjectFactory;
import com.hingeto.api.SalesOrderMessage;
import com.pacsun.hingeto.orderimport.dto.OrderHeaderDto;
import com.pacsun.util.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDataBuilder
  implements Builder
{

  @Autowired
  private ObjectFactory objectFactory;
  private static final Logger log = Logger.getLogger(BaseDataBuilder.class);

  public SalesOrderMessage build(SalesOrderMessage salesOrderMessage, OrderHeaderDto orderHeaderDto) throws Exception {
    salesOrderMessage = this.objectFactory.createSalesOrderMessage();
    salesOrderMessage.setMessageID(orderHeaderDto.getMessageID());
    salesOrderMessage.setOrderID(Integer.toString(orderHeaderDto.getOrderID()));
    try {
      salesOrderMessage.setOrderDate(DateUtil.getXmlDate(orderHeaderDto.getOrderDate(), "yyyy-MM-dd'T'HH:mm:ss'.0Z'"));
    } catch (Exception e) {
      log.error(getClass().getName() + " : " + "MessageID=" + orderHeaderDto.getMessageID() + ", " + "OrderID=" + 
        orderHeaderDto.getOrderID());
      throw new Exception(e);
    }
    salesOrderMessage.setCurrency(orderHeaderDto.getCurrency());
    return salesOrderMessage;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderimport.jar
 * Qualified Name:     com.pacsun.hingeto.orderimport.builder.BaseDataBuilder
 * JD-Core Version:    0.6.0
 */