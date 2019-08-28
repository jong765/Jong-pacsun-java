package com.pacsun.hingeto.orderimport.dto;

import com.pacsun.hingeto.orderimport.model.Address;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDto
{
  private String messageID;
  private int orderID;
  private int orderLineNumber;
  private String orderItemUPC;
  private String orderItemStatus;
  private String effectiveSupplierID;
  private String identifier;
  private String title;
  private int quantity;
  private String giftMessageText;
  private String giftWrapLevel;
  private BigDecimal itemPrice;
  private BigDecimal itemTax;
  private BigDecimal shippingPrice;
  private BigDecimal shippingTax;
  private BigDecimal discountPrice;
  private BigDecimal discountTax;
  private BigDecimal discountShipPrice;
  private BigDecimal discountShippingTax;
  private String shippingName;
  private Address shippingAddress;
  private List<OrderItemAttributeDto> orderItemAttributeDtoList = new ArrayList();

  public OrderDetailDto(String messageID, int orderID, int orderLineNumber, String orderItemUPC, String orderItemStatus, String effectiveSupplierID, String identifier, String title, int quantity, String giftMessageText, String giftWrapLevel, BigDecimal itemPrice, BigDecimal itemTax, BigDecimal shippingPrice, BigDecimal shippingTax, BigDecimal discountPrice, BigDecimal discountTax, BigDecimal discountShipPrice, BigDecimal discountShippingTax, String shippingName, String shippingAddress1, String shippingAddress2, String shippingAddress3, String shippingCity, String shippingState, String shippingZipcode, String shippingCountry, String shippingPhoneNumber, String orderItemAttributeName, String orderItemAttributeValue)
  {
    this.messageID = messageID;
    this.orderID = orderID;
    this.orderLineNumber = orderLineNumber;
    this.orderItemUPC = orderItemUPC;
    this.orderItemStatus = orderItemStatus;
    this.effectiveSupplierID = effectiveSupplierID;
    this.identifier = identifier;
    this.title = title;
    this.quantity = quantity;
    this.giftMessageText = giftMessageText;
    this.giftWrapLevel = giftWrapLevel;
    this.itemPrice = itemPrice;
    this.itemTax = itemTax;
    this.shippingPrice = shippingPrice;
    this.shippingTax = shippingTax;
    this.discountPrice = discountPrice;
    this.discountTax = discountTax;
    this.discountShipPrice = discountShipPrice;
    this.discountShippingTax = discountShippingTax;

    this.shippingName = shippingName;
    this.shippingAddress = new Address();
    this.shippingAddress.setAddress1(shippingAddress1);
    this.shippingAddress.setAddress2(shippingAddress2);
    this.shippingAddress.setAddress3(shippingAddress3);
    this.shippingAddress.setCity(shippingCity);
    this.shippingAddress.setState(shippingState);
    this.shippingAddress.setZipcode(shippingZipcode);
    this.shippingAddress.setCountry(shippingCountry);
    this.shippingAddress.setPhoneNumber(shippingPhoneNumber);

    OrderItemAttributeDto orderItemAttributeDto = new OrderItemAttributeDto();
    orderItemAttributeDto.setName(orderItemAttributeName);
    orderItemAttributeDto.setValue(orderItemAttributeValue);
    this.orderItemAttributeDtoList.add(orderItemAttributeDto);
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

  public int getOrderLineNumber() {
    return this.orderLineNumber;
  }

  public void setOrderLineNumber(int orderLineNumber) {
    this.orderLineNumber = orderLineNumber;
  }

  public String getOrderItemUPC() {
    return this.orderItemUPC;
  }

  public void setOrderItemUPC(String orderItemUPC) {
    this.orderItemUPC = orderItemUPC;
  }

  public String getOrderItemStatus() {
    return this.orderItemStatus;
  }

  public void setOrderItemStatus(String orderItemStatus) {
    this.orderItemStatus = orderItemStatus;
  }

  public String getEffectiveSupplierID() {
    return this.effectiveSupplierID;
  }

  public void setEffectiveSupplierID(String effectiveSupplierID) {
    this.effectiveSupplierID = effectiveSupplierID;
  }

  public String getIdentifier() {
    return this.identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getGiftMessageText() {
    return this.giftMessageText;
  }

  public void setGiftMessageText(String giftMessageText) {
    this.giftMessageText = giftMessageText;
  }

  public String getGiftWrapLevel() {
    return this.giftWrapLevel;
  }

  public void setGiftWrapLevel(String giftWrapLevel) {
    this.giftWrapLevel = giftWrapLevel;
  }

  public BigDecimal getItemPrice() {
    return this.itemPrice;
  }

  public void setItemPrice(BigDecimal itemPrice) {
    this.itemPrice = itemPrice;
  }

  public BigDecimal getItemTax() {
    return this.itemTax;
  }

  public void setItemTax(BigDecimal itemTax) {
    this.itemTax = itemTax;
  }

  public BigDecimal getShippingPrice() {
    return this.shippingPrice;
  }

  public void setShippingPrice(BigDecimal shippingPrice) {
    this.shippingPrice = shippingPrice;
  }

  public BigDecimal getShippingTax() {
    return this.shippingTax;
  }

  public void setShippingTax(BigDecimal shippingTax) {
    this.shippingTax = shippingTax;
  }

  public BigDecimal getDiscountPrice() {
    return this.discountPrice;
  }

  public void setDiscountPrice(BigDecimal discountPrice) {
    this.discountPrice = discountPrice;
  }

  public BigDecimal getDiscountTax() {
    return this.discountTax;
  }

  public void setDiscountTax(BigDecimal discountTax) {
    this.discountTax = discountTax;
  }

  public BigDecimal getDiscountShipPrice() {
    return this.discountShipPrice;
  }

  public void setDiscountShipPrice(BigDecimal discountShipPrice) {
    this.discountShipPrice = discountShipPrice;
  }

  public BigDecimal getDiscountShippingTax() {
    return this.discountShippingTax;
  }

  public void setDiscountShippingTax(BigDecimal discountShippingTax) {
    this.discountShippingTax = discountShippingTax;
  }

  public String getShippingName() {
    return this.shippingName;
  }

  public void setShippingName(String shippingName) {
    this.shippingName = shippingName;
  }

  public Address getShippingAddress() {
    return this.shippingAddress;
  }

  public void setShippingAddress(Address shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public List<OrderItemAttributeDto> getOrderItemAttributeDtoList() {
    return this.orderItemAttributeDtoList;
  }

  public void setOrderItemAttributeDtoList(List<OrderItemAttributeDto> orderItemAttributeDtoList) {
    this.orderItemAttributeDtoList = orderItemAttributeDtoList;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderimport.jar
 * Qualified Name:     com.pacsun.hingeto.orderimport.dto.OrderDetailDto
 * JD-Core Version:    0.6.0
 */