package com.pacsun.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class StackTrace
{
  public static String getStackTrace(Throwable aThrowable)
  {
    Writer result = new StringWriter();
    PrintWriter printWriter = new PrintWriter(result);
    aThrowable.printStackTrace(printWriter);
    return result.toString();
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.util.StackTrace
 * JD-Core Version:    0.6.0
 */