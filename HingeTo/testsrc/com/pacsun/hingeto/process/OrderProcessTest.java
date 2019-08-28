package com.pacsun.hingeto.process;

import com.pacsun.hingeto.orderstatusexport.process.OrderStatusExportProcess;
import java.io.File;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:orderStatusExportApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderProcessTest
{

  @Autowired
  OrderStatusExportProcess orderStatusExportProcess;

  @Value("${orderstatus.file.queue.folder}")
  private String QUEUE_FOLDER;

  @Value("${orderstatusexport.file.prefix}")
  private String ORDER_STATUS_EXPORT_FILE_PREFIX;

  @BeforeClass
  public static void setUpBeforeClass()
    throws Exception
  {
  }

  @AfterClass
  public static void tearDownAfterClass()
    throws Exception
  {
  }

  @Before
  public void setUp()
    throws Exception
  {
  }

  @After
  public void tearDown()
    throws Exception
  {
  }

  @Test
  public void testGetQueuedFiles()
  {
    File[] fileList = this.orderStatusExportProcess.getQueuedFiles(this.QUEUE_FOLDER, this.ORDER_STATUS_EXPORT_FILE_PREFIX, "xml");
    System.out.println("List size=" + fileList.length);
    for (File file : fileList)
      System.out.println(file);
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.hingeto.process.OrderProcessTest
 * JD-Core Version:    0.6.0
 */