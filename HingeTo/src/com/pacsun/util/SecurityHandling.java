package com.pacsun.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class SecurityHandling
{
  public static String getPassword(Connection conn, String username)
    throws Exception
  {
    String password = "";
    CallableStatement stmt = null;

    if (conn != null)
      try {
        stmt = conn.prepareCall("CALL PSSYS.GETPWD(?, ?)");
        stmt.registerOutParameter(2, 1);
        stmt.setString(1, username);
        stmt.execute();

        password = stmt.getString(2).trim();
      } catch (SQLException e1) {
        throw new Exception("\nFailed to retrieve the password for: " + username + " error: " + e1.getMessage());
      } finally {
        try {
          stmt.close();
        } catch (SQLException localSQLException1) {
        }
      }
    return password;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.util.SecurityHandling
 * JD-Core Version:    0.6.0
 */