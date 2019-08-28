package com.pacsun.hingeto.orderimport.dao;

import com.pacsun.hingeto.dao.PacSunDao;
import com.pacsun.hingeto.orderimport.dto.OrderDetailDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

public class OrderDetailDaoImpl extends PacSunDao
  implements OrderDetailDao
{

  @Value("${order.detail.file}")
  private String ORDER_DETAIL_FILE;
  private static final Logger log = Logger.getLogger(OrderDetailDaoImpl.class);

  public List<OrderDetailDto> findByMessageIdAndOrderId(String messageID, int orderID) throws Exception {
    List orderDetailDtoList = new ArrayList();
    this.sb = new StringBuilder();
    this.sb.append("SELECT TRIM(DMSGID) AS MessageID,");
    this.sb.append("DORDID AS OrderID,");
    this.sb.append("DOLINE AS OrderLineNumber,");
    this.sb.append("TRIM(DOIUPC) AS OrderItemUPC,");
    this.sb.append("TRIM(DISTAT) AS OrderItemStatus,");
    this.sb.append("TRIM(DSUPID) AS EffectiveSupplierID,");
    this.sb.append("TRIM(DIDENT) AS Identifier,");
    this.sb.append("TRIM(DTITLE) AS Title,");
    this.sb.append("DOIQTY AS Quantity,");
    this.sb.append("NULLIF(TRIM(DGFMSG),'') AS GiftMessageText,");
    this.sb.append("NULLIF(TRIM(DGFWRP),'') AS GiftWrapLevel,");
    this.sb.append("DITPRC AS ItemPrice,");
    this.sb.append("DITTAX AS ItemTax,");
    this.sb.append("DSHPRC AS ShippingPrice,");
    this.sb.append("DSHTAX AS ShippingTax,");
    this.sb.append("DIDPRC AS DiscountPrice,");
    this.sb.append("DIDTAX AS DiscountTax,");
    this.sb.append("DDSPRC AS DiscountShipPrice,");
    this.sb.append("DDSTAX AS DiscountShippingTax,");
    this.sb.append("TRIM(DSNAME) AS ShippingName,");
    this.sb.append("NULLIF(TRIM(DSADR1),'') AS ShippingAddress1,");
    this.sb.append("NULLIF(TRIM(DSADR2),'') AS ShippingAddress2,");
    this.sb.append("NULLIF(TRIM(DSADR3),'') AS ShippingAddress3,");
    this.sb.append("TRIM(DSCITY) AS ShippingCity,");
    this.sb.append("TRIM(DSSTAT) AS ShippingState,");
    this.sb.append("TRIM(DSZIPC) AS ShippingZipcode,");
    this.sb.append("TRIM(DSCNTY) AS ShippingCountry,");
    this.sb.append("NULLIF(TRIM(DSPHON),'') AS ShippingPhoneNumber,");
    this.sb.append("NULLIF(TRIM(DOANAM),'') AS OrderItemAttributeName,");
    this.sb.append("NULLIF(TRIM(DOAVAL),'') AS OrderItemAttributeValue ");
    this.sb.append("FROM ");
    this.sb.append(this.ORDER_DETAIL_FILE);
    this.sb.append(" WHERE DMSGID = ? AND DORDID = ?");

    this.sql = this.sb.toString();
    try
    {
      this.connection = getConnection();
      this.ps = this.connection.prepareStatement(this.sql);
      this.ps.setString(1, messageID);
      this.ps.setInt(2, orderID);
      OrderDetailDto orderDetailDto = null;
      this.rs = this.ps.executeQuery();

      while (this.rs.next()) {
        orderDetailDto = new OrderDetailDto(this.rs.getString("MessageID"), this.rs.getInt("OrderID"), this.rs.getInt("OrderLineNumber"), 
          this.rs.getString("OrderItemUPC"), this.rs.getString("OrderItemStatus"), this.rs.getString("EffectiveSupplierID"), 
          this.rs.getString("Identifier"), this.rs.getString("Title"), this.rs.getInt("Quantity"), this.rs.getString("GiftMessageText"), 
          this.rs.getString("GiftWrapLevel"), this.rs.getBigDecimal("ItemPrice"), this.rs.getBigDecimal("ItemTax"), 
          this.rs.getBigDecimal("ShippingPrice"), this.rs.getBigDecimal("ShippingTax"), this.rs.getBigDecimal("DiscountPrice"), 
          this.rs.getBigDecimal("DiscountTax"), this.rs.getBigDecimal("DiscountShipPrice"), this.rs.getBigDecimal("DiscountShippingTax"), 
          this.rs.getString("ShippingName"), this.rs.getString("ShippingAddress1"), this.rs.getString("ShippingAddress2"), 
          this.rs.getString("ShippingAddress3"), this.rs.getString("ShippingCity"), this.rs.getString("ShippingState"), 
          this.rs.getString("ShippingZipcode"), this.rs.getString("ShippingCountry"), this.rs.getString("ShippingPhoneNumber"), 
          this.rs.getString("OrderItemAttributeName"), this.rs.getString("OrderItemAttributeValue"));
        orderDetailDtoList.add(orderDetailDto);
      }
    } catch (SQLException e) {
      log.error(getClass().getName() + " : " + "MessageID=" + this.rs.getInt("MessageID") + ", " + "OrderID=" + this.rs.getInt("OrderID"));
      throw new RuntimeException(e);
    } finally {
      closeAll();
    }

    return orderDetailDtoList;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderimport.jar
 * Qualified Name:     com.pacsun.hingeto.orderimport.dao.OrderDetailDaoImpl
 * JD-Core Version:    0.6.0
 */