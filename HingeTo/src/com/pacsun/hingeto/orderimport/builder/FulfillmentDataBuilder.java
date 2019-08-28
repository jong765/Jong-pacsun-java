package com.pacsun.hingeto.orderimport.builder;

import com.hingeto.api.FulfillmentData;
import com.hingeto.api.ObjectFactory;
import com.hingeto.api.SalesOrderMessage;
import com.pacsun.hingeto.orderimport.dto.OrderHeaderDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class FulfillmentDataBuilder
  implements Builder
{

  @Autowired
  private ObjectFactory objectFactory;
  private static final Logger log = Logger.getLogger(FulfillmentDataBuilder.class);

  public SalesOrderMessage build(SalesOrderMessage salesOrderMessage, OrderHeaderDto orderHeaderDto)
    throws Exception
  {
    try
    {
      FulfillmentData fulfillmentData = this.objectFactory.createFulfillmentData();
      fulfillmentData.setShippingOption(orderHeaderDto.getShippingOption());
      fulfillmentData.setFulfillmentAddress(getJaxbFulfillmentAddress(orderHeaderDto.getFulfillmentAddress(), 
        orderHeaderDto.getFulfillmentName()));
      salesOrderMessage.setFulfillmentData(fulfillmentData);
    } catch (Exception e) {
      log.error(getClass().getName() + " : " + "MessageID=" + orderHeaderDto.getMessageID() + ", " + "OrderID=" + 
        orderHeaderDto.getOrderID());
      throw new Exception(e);
    }
    return salesOrderMessage;
  }

  private com.hingeto.api.Address getJaxbFulfillmentAddress(com.pacsun.hingeto.orderimport.model.Address fulfillmentAddress, String fulfillmentName) {
    com.hingeto.api.Address jaxbFulfillmentAddress = this.objectFactory.createAddress();
    jaxbFulfillmentAddress.setName(fulfillmentName);
    jaxbFulfillmentAddress.setAddressFieldOne(fulfillmentAddress.getAddress1());
    jaxbFulfillmentAddress.setAddressFieldTwo(fulfillmentAddress.getAddress2());
    jaxbFulfillmentAddress.setAddressFieldThree(fulfillmentAddress.getAddress3());
    jaxbFulfillmentAddress.setCity(fulfillmentAddress.getCity());
    jaxbFulfillmentAddress.setCountryCode(fulfillmentAddress.getCountry());
    jaxbFulfillmentAddress.setPostalCode(fulfillmentAddress.getZipcode());
    jaxbFulfillmentAddress.setStateOrRegion(fulfillmentAddress.getState());
    jaxbFulfillmentAddress.setPhoneNumber(fulfillmentAddress.getPhoneNumber());
    return jaxbFulfillmentAddress;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderimport.jar
 * Qualified Name:     com.pacsun.hingeto.orderimport.builder.FulfillmentDataBuilder
 * JD-Core Version:    0.6.0
 */