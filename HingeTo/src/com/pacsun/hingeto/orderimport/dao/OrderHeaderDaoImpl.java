package com.pacsun.hingeto.orderimport.dao;

import com.pacsun.hingeto.dao.PacSunDao;
import com.pacsun.hingeto.orderimport.dto.OrderHeaderDto;
import com.pacsun.util.DateFormatterUtil;
import com.pacsun.util.StackTrace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

public class OrderHeaderDaoImpl extends PacSunDao
  implements OrderHeaderDao
{

  @Value("${order.header.file}")
  private String ORDER_HEADER_FILE;
  private static final Logger log = Logger.getLogger(OrderHeaderDaoImpl.class);

  public List<OrderHeaderDto> findUnprocessedOrders() throws Exception {
    List orderHeaderDtoList = new ArrayList();
    this.sb = new StringBuilder();
    this.sb.append("SELECT TRIM(HMSGID) AS MessageID,");
    this.sb.append("HORDID AS OrderID,");
    this.sb.append("HORDDT AS OrderDate,");
    this.sb.append("TRIM(HORDCU) AS Currency,");
    this.sb.append("TRIM(HBNAME) AS BuyerName,");
    this.sb.append("TRIM(HBEMAD) AS BuyerEmailAddress,");
    this.sb.append("NULLIF(TRIM(HBLNAM),'') AS BillingName,");
    this.sb.append("TRIM(HBADR1) AS BillingAddress1,");
    this.sb.append("NULLIF(TRIM(HBADR2),'') AS BillingAddress2,");
    this.sb.append("NULLIF(TRIM(HBADR3),'') AS BillingAddress3,");
    this.sb.append("TRIM(HBCITY) AS BillingCity,");
    this.sb.append("TRIM(HBSTAT) AS BillingState,");
    this.sb.append("TRIM(HBZIPC) AS BillingZipcode,");
    this.sb.append("TRIM(HBCNTY) AS BillingCountry,");
    this.sb.append("NULLIF(TRIM(HBPHON),'') AS BillingPhoneNumber,");
    this.sb.append("TRIM(HFSVIA) AS ShippingOption,");
    this.sb.append("NULLIF(TRIM(HFNAME),'') AS FulfillmentName,");
    this.sb.append("NULLIF(TRIM(HFADR1),'') AS FulfillmentAddress1,");
    this.sb.append("NULLIF(TRIM(HFADR2),'') AS FulfillmentAddress2,");
    this.sb.append("NULLIF(TRIM(HFADR3),'') AS FulfillmentAddress3,");
    this.sb.append("NULLIF(TRIM(HFCITY),'') AS FulfillmentCity,");
    this.sb.append("NULLIF(TRIM(HFSTAT),'') AS FulfillmentState,");
    this.sb.append("NULLIF(TRIM(HFZIPC),'') AS FulfillmentZipcode,");
    this.sb.append("NULLIF(TRIM(HFCNTY),'') AS FulfillmentCountry,");
    this.sb.append("NULLIF(TRIM(HFPHON),'') AS FulfillmentPhoneNumber,");
    this.sb.append("NULLIF(TRIM(HOANAM),'') AS OrderAttributeName,");
    this.sb.append("NULLIF(TRIM(HOAVAL),'') AS OrderAttributeValue ");
    this.sb.append("FROM ");
    this.sb.append(this.ORDER_HEADER_FILE);
    this.sb.append(" WHERE HPROC = 'U'");
    this.sb.append(" ORDER BY HMSGID, HORDID");

    this.sql = this.sb.toString();
    try
    {
      this.ps = getConnection().prepareStatement(this.sql);
      OrderHeaderDto orderHeaderDto = null;
      this.rs = this.ps.executeQuery();

      while (this.rs.next()) {
        orderHeaderDto = new OrderHeaderDto(this.rs.getString("MessageID"), this.rs.getInt("OrderID"), 
          this.rs.getTimestamp("OrderDate"), this.rs.getString("Currency"), this.rs.getString("BuyerName"), 
          this.rs.getString("BuyerEmailAddress"), this.rs.getString("BillingName"), 
          this.rs.getString("BillingAddress1"), this.rs.getString("BillingAddress2"), 
          this.rs.getString("BillingAddress3"), this.rs.getString("BillingCity"), this.rs.getString("BillingState"), 
          this.rs.getString("BillingZipcode"), this.rs.getString("BillingCountry"), 
          this.rs.getString("BillingPhoneNumber"), this.rs.getString("ShippingOption"), 
          this.rs.getString("FulfillmentName"), this.rs.getString("FulfillmentAddress1"), 
          this.rs.getString("FulfillmentAddress2"), this.rs.getString("FulfillmentAddress3"), 
          this.rs.getString("FulfillmentCity"), this.rs.getString("FulfillmentState"), 
          this.rs.getString("FulfillmentZipcode"), this.rs.getString("FulfillmentCountry"), 
          this.rs.getString("FulfillmentPhoneNumber"), this.rs.getString("OrderAttributeName"), 
          this.rs.getString("OrderAttributeValue"));
        orderHeaderDtoList.add(orderHeaderDto);
      }
      this.rs.close();
      this.ps.close();
    }
    catch (SQLException e) {
      String errorMessage = getClass().getName() + StackTrace.getStackTrace(e);
      log.error(errorMessage);
      throw new Exception(errorMessage);
    }
    finally {
      closeAll();
    }

    return orderHeaderDtoList;
  }

  public void updateProcessedBatch(List<OrderHeaderDto> orderHeaderDtoList) throws Exception
  {
    this.sb = new StringBuilder();
    this.sb.append("UPDATE " + this.ORDER_HEADER_FILE);
    this.sb.append(" SET HPROC = 'P',");
    this.sb.append(" HPRDAT = ?,");
    this.sb.append(" HPRTIM = ?");
    this.sb.append(" WHERE HMSGID = ?");
    this.sb.append(" AND HORDID = ?");
    this.sb.append(" WITH NC");

    this.sql = this.sb.toString();
    try
    {
      PreparedStatement ps = getConnection().prepareStatement(this.sql);

      for (OrderHeaderDto orderHeaderDto : orderHeaderDtoList) {
        ps.setInt(1, Integer.parseInt(DateFormatterUtil.getCurrentDate()));
        ps.setInt(2, Integer.parseInt(DateFormatterUtil.getCurrentTime()));
        ps.setString(3, orderHeaderDto.getMessageID());
        ps.setInt(4, orderHeaderDto.getOrderID());
        ps.addBatch();
      }

      ps.executeBatch();
    }
    catch (SQLException e) {
      log.error(getClass().getName() + " : " + "Error in updateProcessedBatch().\n" + 
        StackTrace.getStackTrace(e));
      throw new RuntimeException(e);
    } finally {
      closeAll();
    }
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderimport.jar
 * Qualified Name:     com.pacsun.hingeto.orderimport.dao.OrderHeaderDaoImpl
 * JD-Core Version:    0.6.0
 */