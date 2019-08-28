package com.pacsun.hingeto.dao;

import com.pacsun.util.StackTrace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class PacSunDao
{

  @Autowired
  protected DataSource dataSource;
  protected Connection connection;
  protected PreparedStatement ps;
  protected ResultSet rs;
  protected String sql = null;
  protected StringBuilder sb = null;

  private static final Logger log = Logger.getLogger(PacSunDao.class);

  protected Connection getConnection() throws Exception { String errorMessage;
    try { return this.dataSource.getConnection();
    } catch (SQLException e) {
      errorMessage = getClass().getName() + StackTrace.getStackTrace(e);
      log.error(errorMessage);
    }throw new SQLException(errorMessage);
  }

  protected void setConnection(Connection connection)
  {
    this.connection = connection;
  }

  protected void closeAll() throws SQLException {
    if (this.rs != null)
      this.rs.close();
    if (this.ps != null)
      this.ps.close();
    if (this.connection != null)
      this.connection.close();
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.hingeto.dao.PacSunDao
 * JD-Core Version:    0.6.0
 */