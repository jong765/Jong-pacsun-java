package com.pacsun.hingeto.orderimport.builder;

import com.hingeto.api.BillingData;
import com.hingeto.api.ObjectFactory;
import com.hingeto.api.SalesOrderMessage;
import com.pacsun.hingeto.orderimport.dto.OrderHeaderDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class BillingDataBuilder
  implements Builder
{

  @Autowired
  private ObjectFactory objectFactory;
  private static final Logger log = Logger.getLogger(BillingDataBuilder.class);

  public SalesOrderMessage build(SalesOrderMessage salesOrderMessage, OrderHeaderDto orderHeaderDto)
    throws Exception
  {
    try
    {
      BillingData billingData = this.objectFactory.createBillingData();
      billingData.setBuyerEmailAddress(orderHeaderDto.getBuyerEmailAddress());
      billingData.setBuyerName(orderHeaderDto.getBuyerName());
      billingData.setBillingAddress(getJaxbBillingAddress(orderHeaderDto.getBillingAddress(), orderHeaderDto.getBillingName()));
      salesOrderMessage.setBillingData(billingData);
    } catch (Exception e) {
      log.error(getClass().getName() + " : " + "MessageID=" + orderHeaderDto.getMessageID() + ", " + "OrderID=" + 
        orderHeaderDto.getOrderID());
      throw new Exception(e);
    }
    return salesOrderMessage;
  }

  private com.hingeto.api.Address getJaxbBillingAddress(com.pacsun.hingeto.orderimport.model.Address billingAddress, String billingName) {
    com.hingeto.api.Address jaxbBillingAddress = this.objectFactory.createAddress();
    jaxbBillingAddress.setName(billingName);
    jaxbBillingAddress.setAddressFieldOne(billingAddress.getAddress1());
    jaxbBillingAddress.setAddressFieldTwo(billingAddress.getAddress2());
    jaxbBillingAddress.setAddressFieldThree(billingAddress.getAddress3());
    jaxbBillingAddress.setCity(billingAddress.getCity());
    jaxbBillingAddress.setCountryCode(billingAddress.getCountry());
    jaxbBillingAddress.setPostalCode(billingAddress.getZipcode());
    jaxbBillingAddress.setStateOrRegion(billingAddress.getState());
    jaxbBillingAddress.setPhoneNumber(billingAddress.getPhoneNumber());
    return jaxbBillingAddress;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderimport.jar
 * Qualified Name:     com.pacsun.hingeto.orderimport.builder.BillingDataBuilder
 * JD-Core Version:    0.6.0
 */