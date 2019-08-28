package com.pacsun.util;

public class JavaVersion
{
  public static double getVersion()
  {
    String version = System.getProperty("java.version");
    int pos = version.indexOf('.');
    pos = version.indexOf('.', pos + 1);
    return Double.parseDouble(version.substring(0, pos));
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.util.JavaVersion
 * JD-Core Version:    0.6.0
 */