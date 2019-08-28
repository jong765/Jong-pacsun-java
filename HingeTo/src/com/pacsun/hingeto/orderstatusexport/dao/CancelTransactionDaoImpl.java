package com.pacsun.hingeto.orderstatusexport.dao;

import com.pacsun.hingeto.dao.PacSunDao;
import com.pacsun.hingeto.orderimport.dto.OrderHeaderDto;
import com.pacsun.hingeto.orderstatusexport.dto.CancelTransactionDto;
import com.pacsun.hingeto.orderstatusexport.dto.CancellationItemDto;
import com.pacsun.util.DateFormatterUtil;
import com.pacsun.util.StackTrace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

public class CancelTransactionDaoImpl extends PacSunDao
  implements CancelTransactionDao
{

  @Value("${order.cancel.transaction.file}")
  private String ORDER_CANCEL_TRANSACTION_FILE;
  private static final Logger log = Logger.getLogger(CancelTransactionDaoImpl.class);

  public void insertBatch(List<CancelTransactionDto> cancelTransactionDtoList, String xmlFileName) throws Exception
  {
    this.sb = new StringBuilder();
    this.sb.append("INSERT INTO " + this.ORDER_CANCEL_TRANSACTION_FILE);
    this.sb.append("( CPROC,CPRDAT,CPRTIM,CMSGID,CORDID,CSTSDT,CCANRS,COITEM,CSUPID,CIDENT,CFNAME,COLINE,CDATCR,CTIMCR)");
    this.sb.append(" SELECT 'U', 0, 0, CAST(? as VARCHAR(30)), CAST(? as Int), CAST(? as Timestamp), CAST(? as VARCHAR(225)), CAST(? as VARCHAR(15)), CAST(? as VARCHAR(5)), CAST(? as VARCHAR(30)), CAST(? as VARCHAR(60)), CAST(? as Int), CAST(? as Int), CAST(? as Int)");

    this.sb.append(" FROM SYSIBM.SYSDUMMY1");
    this.sb.append(" WHERE NOT EXISTS");
    this.sb.append(" (SELECT CMSGID, CORDID, COITEM FROM ");
    this.sb.append(this.ORDER_CANCEL_TRANSACTION_FILE);
    this.sb.append(" WHERE CMSGID = ?");
    this.sb.append(" AND CORDID = ?");
    this.sb.append(" AND COITEM = ?) WITH NC");

    this.sql = this.sb.toString();
    try
    {
      PreparedStatement ps = getConnection().prepareStatement(this.sql);

      for (CancelTransactionDto cancelTransactionDto : cancelTransactionDtoList) {
        ps.setString(1, cancelTransactionDto.getMessageID());
        ps.setInt(2, cancelTransactionDto.getOrderID());
        ps.setDate(3, cancelTransactionDto.getStatusUpdateDate());
        ps.setString(8, cancelTransactionDto.getOrderFeedFileName());
        ps.setInt(10, Integer.parseInt(DateFormatterUtil.getCurrentDate()));
        ps.setInt(11, Integer.parseInt(DateFormatterUtil.getCurrentTime()));
        ps.setString(12, cancelTransactionDto.getMessageID());
        ps.setInt(13, cancelTransactionDto.getOrderID());
        for (CancellationItemDto cancellationItemDto : cancelTransactionDto.getCancellationItemDtoList()) {
          ps.setString(4, cancellationItemDto.getCancelReason());
          ps.setString(5, cancellationItemDto.getOrderItemCode());
          ps.setString(6, cancellationItemDto.getEffectiveSupplierID());
          ps.setString(7, cancellationItemDto.getIdentifier());
          ps.setString(9, cancellationItemDto.getLineItemId());
          ps.setString(14, cancellationItemDto.getOrderItemCode());
          ps.addBatch();
        }

      }

      int[] insertCount = ps.executeBatch();

      int recordsInserted = 0;
      for (int count : insertCount) {
        recordsInserted += count;
      }
      log.info("Processed " + xmlFileName + ". " + recordsInserted + " record(s) inserted in cancel transaction file.");
    }
    catch (SQLException e) {
      log.error(getClass().getName() + " : " + "Error processing xml file" + xmlFileName + "\n" + StackTrace.getStackTrace(e));
      throw new SQLException(e);
    } finally {
      closeAll();
    }
  }

  public List<OrderHeaderDto> findUnprocessedOrders()
    throws Exception
  {
    return null;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderstatusexport.jar
 * Qualified Name:     com.pacsun.hingeto.orderstatusexport.dao.CancelTransactionDaoImpl
 * JD-Core Version:    0.6.0
 */