package com.pacsun.hingeto.orderimport.dto;

import com.pacsun.hingeto.orderimport.model.Address;
import java.util.Date;

public class OrderHeaderDto
{
  private String messageID;
  private int orderID;
  private Date orderDate;
  private String currency;
  private String buyerName;
  private String buyerEmailAddress;
  private String billingName;
  private Address billingAddress;
  private String shippingOption;
  private String fulfillmentName;
  private Address fulfillmentAddress;
  private String orderAttributeName;
  private String orderAttributeValue;

  public OrderHeaderDto(String messageID, int orderID, Date orderDate, String currency, String buyerName, String buyerEmailAddress, String billingName, String billingAddress1, String billingAddress2, String billingAddress3, String billingCity, String billingState, String billingZipcode, String billingCountry, String billingPhoneNumber, String shippingOption, String fulfillmentName, String fulfillmentAddress1, String fulfillmentAddress2, String fulfillmentAddress3, String fulfillmentCity, String fulfillmentState, String fulfillmentZipcode, String fulfillmentCountry, String fulfillmentPhoneNumber, String orderAttributeName, String orderAttributeValue)
  {
    this.messageID = messageID;
    this.orderID = orderID;
    this.orderDate = orderDate;
    this.currency = currency;
    this.buyerName = buyerName;
    this.buyerEmailAddress = buyerEmailAddress;
    this.billingName = billingName;
    this.billingAddress = new Address();
    this.billingAddress.setAddress1(billingAddress1);
    this.billingAddress.setAddress2(billingAddress2);
    this.billingAddress.setAddress3(billingAddress3);
    this.billingAddress.setCity(billingCity);
    this.billingAddress.setState(billingState);
    this.billingAddress.setZipcode(billingZipcode);
    this.billingAddress.setCountry(billingCountry);
    this.billingAddress.setPhoneNumber(billingPhoneNumber);
    this.shippingOption = shippingOption;
    this.fulfillmentName = fulfillmentName;
    this.fulfillmentAddress = new Address();
    this.fulfillmentAddress.setAddress1(fulfillmentAddress1);
    this.fulfillmentAddress.setAddress2(fulfillmentAddress2);
    this.fulfillmentAddress.setAddress3(fulfillmentAddress3);
    this.fulfillmentAddress.setCity(fulfillmentCity);
    this.fulfillmentAddress.setState(fulfillmentState);
    this.fulfillmentAddress.setZipcode(fulfillmentZipcode);
    this.fulfillmentAddress.setCountry(fulfillmentCountry);
    this.fulfillmentAddress.setPhoneNumber(fulfillmentPhoneNumber);
    this.orderAttributeName = orderAttributeName;
    this.orderAttributeValue = orderAttributeValue;
  }

  public OrderHeaderDto()
  {
  }

  public String getMessageID() {
    return this.messageID;
  }

  public void setMessageID(String messageID) {
    this.messageID = messageID;
  }

  public int getOrderID() {
    return this.orderID;
  }

  public void setOrderID(int orderID) {
    this.orderID = orderID;
  }

  public Date getOrderDate() {
    return this.orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public String getCurrency() {
    return this.currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getBuyerName() {
    return this.buyerName;
  }

  public void setBuyerName(String buyerName) {
    this.buyerName = buyerName;
  }

  public String getBuyerEmailAddress() {
    return this.buyerEmailAddress;
  }

  public void setBuyerEmailAddress(String buyerEmailAddress) {
    this.buyerEmailAddress = buyerEmailAddress;
  }

  public String getBillingName() {
    return this.billingName;
  }

  public void setBillingName(String billingName) {
    this.billingName = billingName;
  }

  public Address getBillingAddress() {
    return this.billingAddress;
  }

  public void setBillingAddress(Address billingAddress) {
    this.billingAddress = billingAddress;
  }

  public String getShippingOption() {
    return this.shippingOption;
  }

  public void setShippingOption(String shippingOption) {
    this.shippingOption = shippingOption;
  }

  public String getFulfillmentName() {
    return this.fulfillmentName;
  }

  public void setFulfillmentName(String fulfillmentName) {
    this.fulfillmentName = fulfillmentName;
  }

  public Address getFulfillmentAddress() {
    return this.fulfillmentAddress;
  }

  public void setFulfillmentAddress(Address fulfillmentAddress) {
    this.fulfillmentAddress = fulfillmentAddress;
  }

  public String getOrderAttributeName() {
    return this.orderAttributeName;
  }

  public void setOrderAttributeName(String orderAttributeName) {
    this.orderAttributeName = orderAttributeName;
  }

  public String getOrderAttributeValue() {
    return this.orderAttributeValue;
  }

  public void setOrderAttributeValue(String orderAttributeValue) {
    this.orderAttributeValue = orderAttributeValue;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderimport.jar
 * Qualified Name:     com.pacsun.hingeto.orderimport.dto.OrderHeaderDto
 * JD-Core Version:    0.6.0
 */