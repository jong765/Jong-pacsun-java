package com.pacsun.hingeto.orderimport.process;

import com.pacsun.util.JavaVersion;
import com.pacsun.util.StackTrace;
import java.io.PrintStream;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderImportRequestor
{
  private static String errorMessage;
  private static final Logger log = Logger.getLogger(OrderImportRequestor.class);

  public static void main(String[] args) throws Exception {
    try {
      log.info("JVM Java Version:" + JavaVersion.getVersion());
      new OrderImportRequestor().run();
    } catch (Exception e) {
      errorMessage = StackTrace.getStackTrace(e);
      log.error(errorMessage);
      System.out.println(errorMessage);
      System.exit(1);
    }
    System.exit(0);
  }

  public void run() throws Exception {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("orderImportApplicationContext.xml");
    OrderImportProcess orderImportProcess = (OrderImportProcess)context.getBean("orderImportProcess");
    try {
      orderImportProcess.start();
    } catch (Exception e) {
      errorMessage = getClass().getName() + " : " + "Error in hingeto order import.\n" + StackTrace.getStackTrace(e);
      log.error(errorMessage);
      throw new Exception(errorMessage);
    } finally {
      context.close();
    }
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderimport.jar
 * Qualified Name:     com.pacsun.hingeto.orderimport.process.OrderImportRequestor
 * JD-Core Version:    0.6.0
 */