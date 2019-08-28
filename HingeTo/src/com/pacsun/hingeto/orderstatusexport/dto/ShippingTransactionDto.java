package com.pacsun.hingeto.orderstatusexport.dto;

import java.util.List;

public class ShippingTransactionDto extends TransactionDto
{
  private String carrierCode;
  private String CarrierName;
  private String shippingMethod;
  private String trackingNumber;
  private List<FulfillmentItemDto> fulfillmentItemDtoList;

  public String getCarrierCode()
  {
    return this.carrierCode;
  }

  public void setCarrierCode(String carrierCode) {
    this.carrierCode = carrierCode;
  }

  public String getCarrierName() {
    return this.CarrierName;
  }

  public void setCarrierName(String carrierName) {
    this.CarrierName = carrierName;
  }

  public String getShippingMethod() {
    return this.shippingMethod;
  }

  public void setShippingMethod(String shippingMethod) {
    this.shippingMethod = shippingMethod;
  }

  public String getTrackingNumber() {
    return this.trackingNumber;
  }

  public void setTrackingNumber(String trackingNumber) {
    this.trackingNumber = trackingNumber;
  }

  public List<FulfillmentItemDto> getFulfillmentItemDtoList() {
    return this.fulfillmentItemDtoList;
  }

  public void setFulfillmentItemDtoList(List<FulfillmentItemDto> fulfillmentItemDtoList) {
    this.fulfillmentItemDtoList = fulfillmentItemDtoList;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderstatusexport.jar
 * Qualified Name:     com.pacsun.hingeto.orderstatusexport.dto.ShippingTransactionDto
 * JD-Core Version:    0.6.0
 */