package com.pacsun.hingeto.listingexport.process;

import com.pacsun.util.JavaVersion;
import com.pacsun.util.StackTrace;
import java.io.PrintStream;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ListingExportRequestor
{
  private static String errorMessage;
  private static final Logger log = Logger.getLogger(ListingExportRequestor.class);

  public static void main(String[] args) throws Exception {
    try {
      log.info("JVM Java Version:" + JavaVersion.getVersion());
      new ListingExportRequestor().run();
    } catch (Exception e) {
      errorMessage = StackTrace.getStackTrace(e);
      log.error(errorMessage);
      System.out.println(errorMessage);
      throw new Exception(errorMessage);
    }
    System.exit(0);
  }

  public void run() throws Exception {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("listingExportApplicationContext.xml");
    try
    {
      ListingExportProcess listingExportProcess = (ListingExportProcess)context.getBean("listingExportProcess");
      listingExportProcess.start();
      ListingResponseImportProcess listingResponseImportProcess = (ListingResponseImportProcess)context
        .getBean("listingResponseImportProcess");
      listingResponseImportProcess.start();
    } catch (Exception e) {
      errorMessage = getClass().getName() + " : " + "Error in hingeto listing export.\n" + StackTrace.getStackTrace(e);
      log.error(errorMessage);
      throw new Exception(errorMessage);
    } finally {
      context.close();
    }
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_listingexport.jar
 * Qualified Name:     com.pacsun.hingeto.listingexport.process.ListingExportRequestor
 * JD-Core Version:    0.6.0
 */