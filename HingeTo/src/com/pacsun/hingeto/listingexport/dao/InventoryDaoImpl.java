package com.pacsun.hingeto.listingexport.dao;

import com.pacsun.hingeto.dao.PacSunDao;
import com.pacsun.hingeto.listingexport.dto.InventoryDto;
import com.pacsun.hingeto.listingexport.dto.ListingResponseDto;
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

public class InventoryDaoImpl extends PacSunDao
  implements InventoryDao
{

  @Value("${inventory.file}")
  private String INVENTORY_FILE;
  private static final Logger log = Logger.getLogger(InventoryDaoImpl.class);

  public void insertBatch(List<InventoryDto> inventoryDtoList, String xmlFileName) throws Exception
  {
    this.sb = new StringBuilder();
    this.sb.append("INSERT INTO " + this.INVENTORY_FILE);
    this.sb.append(" (IMSGID,IPSKU,ISFPID,IIAQTY,ISUPID,IIDENT,IDATCR,ITIMCR)");
    this.sb.append(" SELECT CAST(? as VARCHAR(30)), CAST(? as VARCHAR(15)), CAST(? as VARCHAR(15)), CAST(? as Int), CAST(? as VARCHAR(9)), CAST(? as VARCHAR(30)), CAST(? as Int), CAST(? as Int)");

    this.sb.append(" FROM SYSIBM.SYSDUMMY1 WITH NC");

    this.sql = this.sb.toString();
    try
    {
      PreparedStatement ps = getConnection().prepareStatement(this.sql);

      for (InventoryDto inventoryDto : inventoryDtoList)
      {
        ps.setString(1, inventoryDto.getMessageId());
        ps.setString(2, inventoryDto.getUpc());
        ps.setString(3, inventoryDto.getStoreFrontProductId());
        ps.setInt(4, inventoryDto.getQuantity());
        ps.setString(5, inventoryDto.getEffectiveSupplierId());
        ps.setString(6, inventoryDto.getIdentifier());
        ps.setInt(7, Integer.parseInt(DateFormatterUtil.getCurrentDate()));
        ps.setInt(8, Integer.parseInt(DateFormatterUtil.getCurrentTime()));
        ps.addBatch();
      }

      int[] insertCount = ps.executeBatch();

      int recordsInserted = 0;
      for (int count : insertCount) {
        recordsInserted += count;
      }
      log.info("Processed " + xmlFileName + ". " + recordsInserted + 
        " record(s) inserted in expanded assortment inventory file.");
    } catch (SQLException e) {
      log.error(getClass().getName() + " : " + "Error in processing xml file " + xmlFileName + "\n" + 
        StackTrace.getStackTrace(e));
      throw new SQLException(e);
    } finally {
      closeAll();
    }
  }

  public void deleteAll()
    throws Exception
  {
    this.sb = new StringBuilder();
    this.sb.append("DELETE FROM " + this.INVENTORY_FILE + " WITH NC");

    this.sql = this.sb.toString();
    try
    {
      PreparedStatement ps = getConnection().prepareStatement(this.sql);

      ps.executeUpdate();

      log.info("Expanded assortment inventory file was cleared for new process.");
    } catch (SQLException e) {
      log.error(getClass().getName() + " : " + "Error in clearing file \n" + StackTrace.getStackTrace(e));
      throw new SQLException(e);
    } finally {
      closeAll();
    }
  }

  public List<ListingResponseDto> findInventoryRecordsForResponse() throws Exception
  {
    List inventoryResponseDtoList = new ArrayList();
    this.sb = new StringBuilder();
    this.sb.append("SELECT DISTINCT TRIM(ISUPID) AS EffectiveSupplierID,");
    this.sb.append("TRIM(IIDENT) AS Identifier ");
    this.sb.append("FROM ");
    this.sb.append(this.INVENTORY_FILE);

    this.sql = this.sb.toString();
    try
    {
      this.ps = getConnection().prepareStatement(this.sql);
      ListingResponseDto inventoryResponseDto = null;
      this.rs = this.ps.executeQuery();

      while (this.rs.next()) {
        inventoryResponseDto = new ListingResponseDto(this.rs.getString("EffectiveSupplierID"), 
          this.rs.getString("Identifier"));
        inventoryResponseDtoList.add(inventoryResponseDto);
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

    return inventoryResponseDtoList;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_listingexport.jar
 * Qualified Name:     com.pacsun.hingeto.listingexport.dao.InventoryDaoImpl
 * JD-Core Version:    0.6.0
 */