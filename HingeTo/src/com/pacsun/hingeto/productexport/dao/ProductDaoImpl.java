package com.pacsun.hingeto.productexport.dao;

import com.pacsun.hingeto.dao.PacSunDao;
import com.pacsun.hingeto.productexport.dto.ProductDto;
import com.pacsun.util.DateFormatterUtil;
import com.pacsun.util.StackTrace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

public class ProductDaoImpl extends PacSunDao
  implements ProductDao
{

  @Value("${product.file}")
  private String PRODUCT_FILE;
  private static final Logger log = Logger.getLogger(ProductDaoImpl.class);

  public void insertBatch(List<ProductDto> productDtoList, String xmlFileName) throws Exception {
    this.sb = new StringBuilder();
    this.sb.append("INSERT INTO " + this.PRODUCT_FILE);
    this.sb.append(" (XPPROC, XPISKU, XPITCK, XPBRCD, XSUPID, XPICLS, XPIVEN, XPISTY, XPICLR, XPISIZ, XPEXGB, XPEXTP, XPFEED, XPMRDW, XPIREG, XPONEX, XPIDES, XPDESC, XPEXCM, XPDROP, XPDTCR, XPTMCR, XPUSER)");
    this.sb.append(" SELECT 'U', CAST(? as Int), CAST(? as VARCHAR(1)), CAST(? as VARCHAR(15)), CAST(? as VARCHAR(9)), CAST(? as Int), CAST(? as Int), CAST(? as Int), CAST(? as Int), CAST(? as Int), CAST(? as VARCHAR(5)), CAST(? as VARCHAR(20)), CAST(? as VARCHAR(5)), CAST(? as VARCHAR(1)), CAST(? as VARCHAR(1)), CAST(? as VARCHAR(5)), CAST(? as VARCHAR(100)), CAST(? as VARCHAR(2000)), CAST(? as VARCHAR(5)), CAST(? as VARCHAR(3)), CAST(? as DECIMAL(9,0)), CAST(? as DECIMAL(7,0)), CAST(? as VARCHAR(10))");

    this.sb.append(" FROM SYSIBM.SYSDUMMY1 WITH NC");

    this.sql = this.sb.toString();
    try
    {
      PreparedStatement ps = getConnection().prepareStatement(this.sql);

      for (ProductDto productDto : productDtoList)
      {
        ps.setInt(1, productDto.getSku());
        ps.setString(2, productDto.getItemTicketing());
        ps.setString(3, productDto.getBarCode());
        ps.setString(4, productDto.getEffectiveSupplierId());
        ps.setInt(5, productDto.getClassz());
        ps.setInt(6, productDto.getVendor());
        ps.setInt(7, productDto.getStyle());
        ps.setInt(8, productDto.getColor());
        ps.setInt(9, productDto.getSize());
        ps.setString(10, productDto.getExcludeGiftBox());
        ps.setString(11, productDto.getExclusiveType());
        ps.setString(12, productDto.getFeedProcessed());
        ps.setString(13, productDto.getMarkdownFlag());
        ps.setString(14, productDto.getIsRegular());
        ps.setString(15, productDto.getOnlineExclusive());
        ps.setString(16, productDto.getTitle());
        ps.setString(17, productDto.getProductDescription());
        ps.setString(18, productDto.getExcludeClassMap());
        ps.setString(19, productDto.getDropShip());
        ps.setInt(20, Integer.parseInt(DateFormatterUtil.getCurrentDate()));
        ps.setInt(21, Integer.parseInt(DateFormatterUtil.getCurrentTime()));
        ps.setString(22, "ProductDao");
        ps.addBatch();
      }

      int[] insertCount = ps.executeBatch();

      int recordsInserted = 0;
      for (int count : insertCount) {
        recordsInserted += count;
      }
      log.info("Processed " + xmlFileName + ". " + recordsInserted + " record(s) inserted in expanded assortment product file.");
    } catch (SQLException e) {
      log.error(getClass().getName() + " : " + "Error in processing xml file " + xmlFileName + "\n" + 
        StackTrace.getStackTrace(e));
      throw new SQLException(e);
    } finally {
      closeAll();
    }
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_productexport.jar
 * Qualified Name:     com.pacsun.hingeto.productexport.dao.ProductDaoImpl
 * JD-Core Version:    0.6.0
 */