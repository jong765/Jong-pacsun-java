package com.pacsun.hingeto.imagedownload.process;

import com.pacsun.util.JavaVersion;
import com.pacsun.util.StackTrace;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ImageDownloadRequestor
{
  private static String errorMessage;
  private static final Logger log = Logger.getLogger(ImageDownloadRequestor.class);

  public static void main(String[] args) throws Exception {
    try {
      log.info("JVM Java Version:" + JavaVersion.getVersion());
      new ImageDownloadRequestor().run();
    } catch (Exception e) {
      errorMessage = StackTrace.getStackTrace(e);
      log.error(errorMessage);
      throw new Exception(errorMessage);
    }
    System.exit(0);
  }

  public void run() throws Exception {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("imageDownloadApplicationContext.xml");
    try
    {
      ImageDownloadProcess imageDownloadProcess = (ImageDownloadProcess)context.getBean("imageDownloadProcess");
      imageDownloadProcess.start();
    } catch (Exception e) {
      errorMessage = getClass().getName() + " : " + "Error in hingeto product image download.\n" + StackTrace.getStackTrace(e);
      log.error(errorMessage);
      throw new Exception(errorMessage);
    } finally {
      context.close();
    }
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_imagedownload.jar
 * Qualified Name:     com.pacsun.hingeto.imagedownload.process.ImageDownloadRequestor
 * JD-Core Version:    0.6.0
 */