package com.pacsun.hingeto.orderimport.builder;

import com.hingeto.api.ObjectFactory;
import com.hingeto.api.OrderAttribute;
import com.hingeto.api.OrderAttributes;
import com.hingeto.api.SalesOrderMessage;
import com.pacsun.hingeto.orderimport.dto.OrderHeaderDto;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderAttributesBuilder
  implements Builder
{

  @Autowired
  private ObjectFactory objectFactory;
  private static final Logger log = Logger.getLogger(OrderAttributesBuilder.class);

  public SalesOrderMessage build(SalesOrderMessage salesOrderMessage, OrderHeaderDto orderHeaderDto)
    throws Exception
  {
    try
    {
      String orderAttributeName = orderHeaderDto.getOrderAttributeName();
      String orderAttributeValue = orderHeaderDto.getOrderAttributeValue();

      if (orderAttributeName != null) {
        OrderAttributes orderAttributes = this.objectFactory.createOrderAttributes();
        OrderAttribute orderAttribute = this.objectFactory.createOrderAttribute();
        orderAttribute.setName(orderAttributeName);
        orderAttribute.setValue(orderAttributeValue);
        orderAttributes.getOrderAttribute().add(orderAttribute);
        salesOrderMessage.setOrderAttributes(orderAttributes);
      }
    } catch (Exception e) {
      log.error(getClass().getName() + " : " + "MessageID=" + orderHeaderDto.getMessageID() + ", " + "OrderID=" + 
        orderHeaderDto.getOrderID());
      throw new Exception(e);
    }
    return salesOrderMessage;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderimport.jar
 * Qualified Name:     com.pacsun.hingeto.orderimport.builder.OrderAttributesBuilder
 * JD-Core Version:    0.6.0
 */