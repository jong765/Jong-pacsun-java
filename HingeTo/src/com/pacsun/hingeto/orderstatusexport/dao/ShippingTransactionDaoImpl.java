package com.pacsun.hingeto.orderstatusexport.dao;

import com.pacsun.hingeto.dao.PacSunDao;
import com.pacsun.hingeto.orderstatusexport.dto.FulfillmentItemDto;
import com.pacsun.hingeto.orderstatusexport.dto.ShippingTransactionDto;
import com.pacsun.util.DateFormatterUtil;
import com.pacsun.util.StackTrace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

public class ShippingTransactionDaoImpl extends PacSunDao
  implements ShippingTransactionDao
{

  @Value("${order.shipping.transaction.file}")
  private String ORDER_SHIPPING_TRANSACTION_FILE;
  private static final Logger log = Logger.getLogger(ShippingTransactionDaoImpl.class);

  public void insertBatch(List<ShippingTransactionDto> shippingTransactionDtoList, String xmlFileName) throws Exception
  {
    this.sb = new StringBuilder();
    this.sb.append("INSERT INTO " + this.ORDER_SHIPPING_TRANSACTION_FILE);
    this.sb.append(" (SPROC,SPRDAT,SPRTIM,SMSGID,SORDID,SSTSDT,SCARCD,SCARNM,SFSVIA,SFTRKN,SOITEM,SSUPID,SIDENT,SOSQTY,SFNAME,SOLINE,SDATCR,STIMCR)");
    this.sb.append(" SELECT 'U', 0, 0, CAST(? as VARCHAR(30)), CAST(? as Int), CAST(? as Timestamp), CAST(? as VARCHAR(20)), CAST(? as VARCHAR(60)), CAST(? as VARCHAR(20)), CAST(? as VARCHAR(30)), CAST(? as VARCHAR(15)), CAST(? as VARCHAR(5)), CAST(? as VARCHAR(30)), CAST(? as Int), CAST(? as VARCHAR(60)),CAST(? as Int),CAST(? as Int), CAST(? as Int)");

    this.sb.append(" FROM SYSIBM.SYSDUMMY1");
    this.sb.append(" WHERE NOT EXISTS");
    this.sb.append(" (SELECT SMSGID, SORDID, SOLINE, SOITEM FROM ");
    this.sb.append(this.ORDER_SHIPPING_TRANSACTION_FILE);
    this.sb.append(" WHERE SMSGID = ?");
    this.sb.append(" AND SORDID = ?");
    this.sb.append(" AND SOLINE = ?");
    this.sb.append(" AND SOITEM = ?) WITH NC");

    this.sql = this.sb.toString();

    String messageID = "";
    int orderID = 0;
    try
    {
      PreparedStatement ps = getConnection().prepareStatement(this.sql);

      for (ShippingTransactionDto shippingTransactionDto : shippingTransactionDtoList) {
        messageID = shippingTransactionDto.getMessageID();
        orderID = shippingTransactionDto.getOrderID();

        ps.setString(1, messageID);
        ps.setInt(2, orderID);
        ps.setDate(3, shippingTransactionDto.getStatusUpdateDate());
        ps.setString(4, shippingTransactionDto.getCarrierCode());
        ps.setString(5, shippingTransactionDto.getCarrierName());
        ps.setString(6, shippingTransactionDto.getShippingMethod());
        ps.setString(7, shippingTransactionDto.getTrackingNumber());
        ps.setString(12, shippingTransactionDto.getOrderFeedFileName());
        ps.setString(16, messageID);
        ps.setInt(17, orderID);

        for (FulfillmentItemDto fulfillmentItemDto : shippingTransactionDto.getFulfillmentItemDtoList()) {
          ps.setString(8, fulfillmentItemDto.getOrderItemCode());
          ps.setString(9, fulfillmentItemDto.getEffectiveSupplierID());
          ps.setString(10, fulfillmentItemDto.getIdentifier());
          ps.setInt(11, fulfillmentItemDto.getFulfilledQty());
          ps.setInt(13, Integer.valueOf(fulfillmentItemDto.getLineItemId()).intValue());
          ps.setInt(14, Integer.parseInt(DateFormatterUtil.getCurrentDate()));
          ps.setInt(15, Integer.parseInt(DateFormatterUtil.getCurrentTime()));
          ps.setInt(18, Integer.valueOf(fulfillmentItemDto.getLineItemId()).intValue());
          ps.setString(19, fulfillmentItemDto.getOrderItemCode());
          ps.addBatch();
        }
      }

      int[] insertCount = ps.executeBatch();

      int recordsInserted = 0;
      for (int count : insertCount) {
        recordsInserted += count;
      }
      log.info("Processed " + xmlFileName + ". " + recordsInserted + " record(s) inserted in shipping transaction file.");
    } catch (SQLException e) {
      log.error(getClass().getName() + " : " + "Error in processing xml file " + xmlFileName + "\n" + " OrderID=" + orderID + 
        ", MessageID=" + messageID + ".\n" + StackTrace.getStackTrace(e));
      throw new SQLException(e);
    } finally {
      closeAll();
    }
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderstatusexport.jar
 * Qualified Name:     com.pacsun.hingeto.orderstatusexport.dao.ShippingTransactionDaoImpl
 * JD-Core Version:    0.6.0
 */