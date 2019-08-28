package com.hingeto.api;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="OrderItem", propOrder={"orderItemCode", "storeFrontLineItemID", "orderItemStatus", "listingID", "title", "quantity", "giftWrapLevel", "giftMessageText", "itemPrices", "itemDiscounts", "itemAttributes", "shippingAddress"})
public class OrderItem
{

  @XmlElement(name="OrderItemCode", required=true)
  protected String orderItemCode;

  @XmlElement(name="StoreFrontLineItemID", required=true)
  protected String storeFrontLineItemID;

  @XmlElement(name="OrderItemStatus")
  protected String orderItemStatus;

  @XmlElement(name="ListingID", required=true)
  protected ListingIDType listingID;

  @XmlElement(name="Title")
  protected String title;

  @XmlElement(name="Quantity", required=true)
  @XmlSchemaType(name="positiveInteger")
  protected BigInteger quantity;

  @XmlElement(name="GiftWrapLevel")
  protected String giftWrapLevel;

  @XmlElement(name="GiftMessageText")
  protected String giftMessageText;

  @XmlElement(name="ItemPrices", required=true)
  protected OrderItemPrices itemPrices;

  @XmlElement(name="ItemDiscounts")
  protected OrderItemPrices itemDiscounts;

  @XmlElement(name="ItemAttributes")
  protected OrderAttributes itemAttributes;

  @XmlElement(name="ShippingAddress")
  protected Address shippingAddress;

  public String getOrderItemCode()
  {
    return this.orderItemCode;
  }

  public void setOrderItemCode(String value)
  {
    this.orderItemCode = value;
  }

  public String getStoreFrontLineItemID()
  {
    return this.storeFrontLineItemID;
  }

  public void setStoreFrontLineItemID(String value)
  {
    this.storeFrontLineItemID = value;
  }

  public String getOrderItemStatus()
  {
    return this.orderItemStatus;
  }

  public void setOrderItemStatus(String value)
  {
    this.orderItemStatus = value;
  }

  public ListingIDType getListingID()
  {
    return this.listingID;
  }

  public void setListingID(ListingIDType value)
  {
    this.listingID = value;
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setTitle(String value)
  {
    this.title = value;
  }

  public BigInteger getQuantity()
  {
    return this.quantity;
  }

  public void setQuantity(BigInteger value)
  {
    this.quantity = value;
  }

  public String getGiftWrapLevel()
  {
    return this.giftWrapLevel;
  }

  public void setGiftWrapLevel(String value)
  {
    this.giftWrapLevel = value;
  }

  public String getGiftMessageText()
  {
    return this.giftMessageText;
  }

  public void setGiftMessageText(String value)
  {
    this.giftMessageText = value;
  }

  public OrderItemPrices getItemPrices()
  {
    return this.itemPrices;
  }

  public void setItemPrices(OrderItemPrices value)
  {
    this.itemPrices = value;
  }

  public OrderItemPrices getItemDiscounts()
  {
    return this.itemDiscounts;
  }

  public void setItemDiscounts(OrderItemPrices value)
  {
    this.itemDiscounts = value;
  }

  public OrderAttributes getItemAttributes()
  {
    return this.itemAttributes;
  }

  public void setItemAttributes(OrderAttributes value)
  {
    this.itemAttributes = value;
  }

  public Address getShippingAddress()
  {
    return this.shippingAddress;
  }

  public void setShippingAddress(Address value)
  {
    this.shippingAddress = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.OrderItem
 * JD-Core Version:    0.6.0
 */