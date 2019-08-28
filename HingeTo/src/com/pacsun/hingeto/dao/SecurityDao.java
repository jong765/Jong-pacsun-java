package com.pacsun.hingeto.dao;

import com.pacsun.util.SecurityHandling;
import org.apache.log4j.Logger;

public class SecurityDao extends PacSunDao
{
  protected static String errorMessage = "";

  private static final Logger log = Logger.getLogger(SecurityDao.class);

  public String getSftpPassword(String username) throws Exception {
    String password = "";
    try {
      password = SecurityHandling.getPassword(getConnection(), username);
    } catch (Exception e) {
      errorMessage = getClass().getName() + " : " + "Error in retrieving SFTP password.";
      log.error(errorMessage);
      throw new Exception(errorMessage);
    }
    return password;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.hingeto.dao.SecurityDao
 * JD-Core Version:    0.6.0
 */