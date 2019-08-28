package com.pacsun.hingeto.orderstatusexport.dto;

import java.sql.Date;
import java.util.List;

public class TransactionDto
{
  private String messageID;
  private int orderID;
  private Date statusUpdateDate;
  private List<OrderStatusAttributeDto> orderStatusAttributeDtoList;
  private String orderFeedFileName;

  public String getMessageID()
  {
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

  public Date getStatusUpdateDate() {
    return this.statusUpdateDate;
  }

  public void setStatusUpdateDate(Date statusUpdateDate) {
    this.statusUpdateDate = statusUpdateDate;
  }

  public List<OrderStatusAttributeDto> getOrderStatusAttributeDtoList() {
    return this.orderStatusAttributeDtoList;
  }

  public void setOrderStatusAttributeDtoList(List<OrderStatusAttributeDto> orderStatusAttributeDtoList) {
    this.orderStatusAttributeDtoList = orderStatusAttributeDtoList;
  }

  public String getOrderFeedFileName() {
    return this.orderFeedFileName;
  }

  public void setOrderFeedFileName(String orderFeedFileName) {
    this.orderFeedFileName = orderFeedFileName;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderstatusexport.jar
 * Qualified Name:     com.pacsun.hingeto.orderstatusexport.dto.TransactionDto
 * JD-Core Version:    0.6.0
 */