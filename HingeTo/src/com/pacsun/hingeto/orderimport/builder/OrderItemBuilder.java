package com.pacsun.hingeto.orderimport.builder;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.hingeto.api.ListingIDType;
import com.hingeto.api.ObjectFactory;
import com.hingeto.api.OrderAttribute;
import com.hingeto.api.OrderAttributes;
import com.hingeto.api.OrderItem;
import com.hingeto.api.OrderItemPrice;
import com.hingeto.api.OrderItemPriceType;
import com.hingeto.api.OrderItemPrices;
import com.pacsun.hingeto.orderimport.dto.OrderDetailDto;
import com.pacsun.hingeto.orderimport.dto.OrderItemAttributeDto;

public class OrderItemBuilder {

	@Autowired
	private ObjectFactory objectFactory;
	private OrderItem orderItem;
	private static final Logger log = Logger.getLogger(OrderItemBuilder.class);

	public OrderItem build(OrderDetailDto orderDetailDto) throws Exception {
		try {
			this.orderItem = this.objectFactory.createOrderItem();
			this.orderItem.setStoreFrontLineItemID(String.valueOf(orderDetailDto.getOrderLineNumber()));
			this.orderItem.setOrderItemCode(orderDetailDto.getOrderItemUPC());
			this.orderItem.setOrderItemStatus(orderDetailDto.getOrderItemStatus());
			ListingIDType listingIDType = this.objectFactory.createListingIDType();
			listingIDType.setEffectiveSupplierID(orderDetailDto.getEffectiveSupplierID());
			listingIDType.setIdentifier(orderDetailDto.getIdentifier());
			this.orderItem.setListingID(listingIDType);
			this.orderItem.setTitle(orderDetailDto.getTitle());
			this.orderItem.setQuantity(BigInteger.valueOf(orderDetailDto.getQuantity()));
			this.orderItem.setGiftWrapLevel(orderDetailDto.getGiftWrapLevel());
			this.orderItem.setGiftMessageText(orderDetailDto.getGiftMessageText());
			this.orderItem.setItemPrices(getOrderItemPrices(orderDetailDto));
			OrderAttributes orderAttributes = this.objectFactory.createOrderAttributes();
			for (OrderItemAttributeDto orderItemAttributeDto : orderDetailDto.getOrderItemAttributeDtoList()) {
				OrderAttribute orderAttribute = new OrderAttribute();
				orderAttribute.setName(orderItemAttributeDto.getName());
				orderAttribute.setValue(orderItemAttributeDto.getValue());
				orderAttributes.getOrderAttribute().add(orderAttribute);
			}
			this.orderItem.setItemAttributes(orderAttributes);
			this.orderItem.setItemDiscounts(getOrderItemDiscounts(orderDetailDto));
			this.orderItem.setShippingAddress(getShippingAddress(orderDetailDto));
		} catch (Exception e) {
			log.error(getClass().getName() + " : " + "MessageID=" + orderDetailDto.getMessageID() + ", " + "OrderID="
					+ orderDetailDto.getOrderID());
			throw new Exception(e);
		}
		return this.orderItem;
	}

	private com.hingeto.api.Address getShippingAddress(OrderDetailDto orderDetailDto) {
		com.hingeto.api.Address jaxbShippingAddress = this.objectFactory.createAddress();
		com.pacsun.hingeto.orderimport.model.Address shippingAddress = orderDetailDto.getShippingAddress();
		jaxbShippingAddress.setName(orderDetailDto.getShippingName());
		jaxbShippingAddress.setAddressFieldOne(shippingAddress.getAddress1());
		jaxbShippingAddress.setAddressFieldTwo(shippingAddress.getAddress2());
		jaxbShippingAddress.setAddressFieldThree(shippingAddress.getAddress3());
		jaxbShippingAddress.setCity(shippingAddress.getCity());
		jaxbShippingAddress.setStateOrRegion(shippingAddress.getState());
		jaxbShippingAddress.setPostalCode(shippingAddress.getZipcode());
		jaxbShippingAddress.setCountryCode(shippingAddress.getCountry());
		jaxbShippingAddress.setPhoneNumber(shippingAddress.getPhoneNumber());
		return jaxbShippingAddress;
	}

	private OrderItemPrices getOrderItemPrices(OrderDetailDto orderDetailDto) {
		OrderItemPrices orderItemPrices = this.objectFactory.createOrderItemPrices();
		orderItemPrices.getPrice().add(getOrderItemPrice(OrderItemPriceType.ITEM_PRICE, orderDetailDto.getItemPrice()));
		orderItemPrices.getPrice().add(getOrderItemPrice(OrderItemPriceType.ITEM_TAX, orderDetailDto.getItemTax()));
		orderItemPrices.getPrice().add(getOrderItemPrice(OrderItemPriceType.SHIPPING_PRICE, orderDetailDto.getShippingPrice()));
		orderItemPrices.getPrice().add(getOrderItemPrice(OrderItemPriceType.SHIPPING_TAX, orderDetailDto.getShippingTax()));
		return orderItemPrices;
	}

	public OrderItemPrices getOrderItemDiscounts(OrderDetailDto orderDetailDto) {
		OrderItemPrices orderItemPrices;
		if ((orderDetailDto.getDiscountPrice().compareTo(BigDecimal.ZERO) != 0)
				|| (orderDetailDto.getDiscountTax().compareTo(BigDecimal.ZERO) != 0)
				|| (orderDetailDto.getDiscountShipPrice().compareTo(BigDecimal.ZERO) != 0)
				|| (orderDetailDto.getDiscountShippingTax().compareTo(BigDecimal.ZERO) != 0)) {
			orderItemPrices = this.objectFactory.createOrderItemPrices();
			orderItemPrices.getPrice().add(getOrderItemPrice(OrderItemPriceType.ITEM_PRICE, orderDetailDto.getDiscountPrice()));
			orderItemPrices.getPrice().add(getOrderItemPrice(OrderItemPriceType.ITEM_TAX, orderDetailDto.getDiscountTax()));
			orderItemPrices.getPrice().add(getOrderItemPrice(OrderItemPriceType.SHIPPING_PRICE, orderDetailDto.getDiscountShipPrice()));
			orderItemPrices.getPrice().add(getOrderItemPrice(OrderItemPriceType.SHIPPING_TAX, orderDetailDto.getDiscountShippingTax()));
		} else {
			orderItemPrices = null;
		}
		return orderItemPrices;
	}

	public OrderItemPrice getOrderItemPrice(OrderItemPriceType priceType, BigDecimal price) {
		OrderItemPrice orderItemPrice = this.objectFactory.createOrderItemPrice();
		orderItemPrice.setType(priceType);
		orderItemPrice.setValue(price);
		return orderItemPrice;
	}
}

/*
 * Location: C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderimport.jar Qualified Name:
 * com.pacsun.hingeto.orderimport.builder.OrderItemBuilder JD-Core Version: 0.6.0
 */