package com.pacsun.hingeto.productexport.process;

import com.pacsun.util.JavaVersion;
import com.pacsun.util.StackTrace;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductExportRequestor
{
  private static String errorMessage;
  private static final Logger log = Logger.getLogger(ProductExportRequestor.class);

  public static void main(String[] args) throws Exception {
    try {
      log.info("JVM Java Version:" + JavaVersion.getVersion());
      new ProductExportRequestor().run();
    } catch (Exception e) {
      errorMessage = StackTrace.getStackTrace(e);
      log.error(errorMessage);
      throw new Exception(errorMessage);
    }
    System.exit(0);
  }

  public void run() throws Exception {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("productExportApplicationContext.xml");
    try
    {
      ProductExportProcess productExportProcess = (ProductExportProcess)context.getBean("productExportProcess");
      productExportProcess.start();
    } catch (Exception e) {
      errorMessage = getClass().getName() + " : " + "Error in hingeto product export.\n" + StackTrace.getStackTrace(e);
      log.error(errorMessage);
      throw new Exception(errorMessage);
    } finally {
      context.close();
    }
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_productexport.jar
 * Qualified Name:     com.pacsun.hingeto.productexport.process.ProductExportRequestor
 * JD-Core Version:    0.6.0
 */