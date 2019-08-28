package com.pacsun.hingeto.process;

import com.pacsun.hingeto.orderimport.process.OrderImportProcess;
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

@ContextConfiguration({"classpath:orderImportApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderExportProcessTest
{

  @Value("${orderexport.file.queue.folder}")
  private String QUEUE_FOLDER;

  @Value("${orderexport.file.processed.folder}")
  private String PROCESSED_FOLDER;

  @Value("${orderexport.file.failed.folder}")
  private String FAILED_FOLDER;

  @Value("${orderexport.data.queue.dqname}")
  private String ORDER_EXPORT_DATA_QUEUE;

  @Autowired
  OrderImportProcess orderExportProcess;

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
  public void testMoveFile()
    throws Exception
  {
    String xmlFileName = "Orders_20150507_101258.xml";
    this.orderExportProcess.moveFile(xmlFileName, this.QUEUE_FOLDER, this.FAILED_FOLDER);
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.hingeto.process.OrderExportProcessTest
 * JD-Core Version:    0.6.0
 */