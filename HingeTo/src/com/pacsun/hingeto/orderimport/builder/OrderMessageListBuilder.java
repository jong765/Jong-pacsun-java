package com.pacsun.hingeto.orderimport.builder;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.hingeto.api.Feed;
import com.hingeto.api.ObjectFactory;
import com.hingeto.api.OrderItem;
import com.hingeto.api.OrderList;
import com.hingeto.api.SalesOrderMessage;
import com.pacsun.hingeto.builder.HeaderDataBuilder;
import com.pacsun.hingeto.orderimport.dao.OrderDetailDao;
import com.pacsun.hingeto.orderimport.dao.OrderHeaderDao;
import com.pacsun.hingeto.orderimport.dto.OrderDetailDto;
import com.pacsun.hingeto.orderimport.dto.OrderHeaderDto;
import com.pacsun.util.StackTrace;

public class OrderMessageListBuilder {

	@Autowired
	private HeaderDataBuilder headerDataBuilder;

	@Autowired
	private BaseDataBuilder baseDataBuilder;

	@Autowired
	private BillingDataBuilder billingDataBuilder;

	@Autowired
	private FulfillmentDataBuilder fulfillmentDataBuilder;

	@Autowired
	private OrderItemBuilder orderItemBuilder;

	@Autowired
	private OrderAttributesBuilder orderAttributesBuilder;

	@Autowired
	private ObjectFactory objectFactory;
	private Feed feed = null;
	private List<Builder> builderList;

	@Autowired
	private OrderHeaderDao orderHeaderDao;

	@Autowired
	private OrderDetailDao orderDetailDao;
	List<OrderHeaderDto> orderHeaderDtoList;
	private static final Logger log = Logger.getLogger(OrderMessageListBuilder.class);

	private void initialize() {
		this.builderList = new ArrayList();
		this.builderList.add(this.baseDataBuilder);
		this.builderList.add(this.billingDataBuilder);
		this.builderList.add(this.fulfillmentDataBuilder);
		this.builderList.add(this.orderAttributesBuilder);
	}

	public Feed build() throws Exception {
		log.debug("Begin OrderMessageListBuilder.build()");
		initialize();
		try {
			this.orderHeaderDtoList = this.orderHeaderDao.findUnprocessedOrders();

			if (this.orderHeaderDtoList.size() > 0) {
				this.feed = this.objectFactory.createFeed();
				this.feed.setHeader(this.headerDataBuilder.build());
				OrderList orderList = new OrderList();
				SalesOrderMessage salesOrderMessage = null;

				for (OrderHeaderDto orderHeaderDto : this.orderHeaderDtoList) {
					String messageID = orderHeaderDto.getMessageID();
					int orderID = orderHeaderDto.getOrderID();

					for (Builder builder : this.builderList) {
						salesOrderMessage = builder.build(salesOrderMessage, orderHeaderDto);
					}

					salesOrderMessage.getOrderItem().addAll(getOrderItemList(messageID, orderID));
					orderList.getSalesOrder().add(salesOrderMessage);
				}

				this.feed.setOrders(orderList);
			} else {
				this.feed = null;
			}
		} catch (Exception e) {
			log.error(getClass().getName() + " : " + StackTrace.getStackTrace(e));
			throw new Exception(e);
		}
		log.debug("End OrderMessageListBuilder.build()");
		return this.feed;
	}

	private List<OrderItem> getOrderItemList(String messageID, int orderID) throws Exception {
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		List<OrderDetailDto> orderDetailDtoList = this.orderDetailDao.findByMessageIdAndOrderId(messageID, orderID);
		for (OrderDetailDto orderDetailDto : orderDetailDtoList) {
			try {
				OrderItem orderItem = this.orderItemBuilder.build(orderDetailDto);
				orderItemList.add(orderItem);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return orderItemList;
	}

	public Feed getFeed() {
		return this.feed;
	}

	public void setFeed(Feed feed) {
		this.feed = feed;
	}

	public List<OrderHeaderDto> getOrderHeaderDtoList() {
		return this.orderHeaderDtoList;
	}

	public void setOrderHeaderDtoList(List<OrderHeaderDto> orderHeaderDtoList) {
		this.orderHeaderDtoList = orderHeaderDtoList;
	}
}

/*
 * Location: C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderimport.jar Qualified Name:
 * com.pacsun.hingeto.orderimport.builder.OrderMessageListBuilder JD-Core Version: 0.6.0
 */