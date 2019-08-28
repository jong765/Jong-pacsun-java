package com.pacsun.hingeto.orderstatusexport.process;

import com.pacsun.util.JavaVersion;
import com.pacsun.util.StackTrace;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderStatusExportRequestor
{
  private static String errorMessage;
  private static final Logger log = Logger.getLogger(OrderStatusExportRequestor.class);

  public static void main(String[] args) throws Exception {
    log.info("JVM Java Version:" + JavaVersion.getVersion());
    new OrderStatusExportRequestor().run();
  }

  public void run() throws Exception {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("orderStatusExportApplicationContext.xml");
    OrderStatusExportProcess orderStatusExportProcess = (OrderStatusExportProcess)context.getBean("orderStatusExportProcess");
    try {
      orderStatusExportProcess.start();
    } catch (Exception e) {
      errorMessage = getClass().getName() + " : " + "Error in hingeto order status export.\n" + StackTrace.getStackTrace(e);
      log.error(errorMessage);
      throw new Exception(errorMessage);
    } finally {
      context.close();
    }
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderstatusexport.jar
 * Qualified Name:     com.pacsun.hingeto.orderstatusexport.process.OrderStatusExportRequestor
 * JD-Core Version:    0.6.0
 */