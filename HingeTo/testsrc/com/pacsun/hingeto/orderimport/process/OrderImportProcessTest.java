package com.pacsun.hingeto.orderimport.process;

import com.pacsun.hingeto.process.FileProcess;
import com.pacsun.util.SftpUtil;
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

@ContextConfiguration({"classpath:orderImportApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderImportProcessTest extends FileProcess
{

  @Value("${orderimport.file.queue.folder}")
  private String QUEUE_FOLDER;

  @Value("${orderimport.file.processed.folder}")
  private String PROCESSED_FOLDER;

  @Autowired
  private OrderImportProcess orderImportProcess;

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
  public void testStart()
    throws Exception
  {
    this.orderImportProcess.start();
  }

  @Test
  public void testMoveFile() throws Exception {
    this.sftpUtil.setSftpHost("10.60.10.9");
    this.sftpUtil.setSftpUser("sftptest");
    this.sftpUtil.setSftpDir("test");
    this.sftpUtil.setSftpPassword("Sftpt3st");

    String fullXmlFileName = "";
    String xmlFileName = "TestOrders-20150714_145638.xml";

    for (int i = 0; i < 250; i++) {
      fullXmlFileName = this.QUEUE_FOLDER + xmlFileName;
      this.sftpUtil.sendFile(new File(fullXmlFileName));
      moveFile(xmlFileName, this.QUEUE_FOLDER, this.PROCESSED_FOLDER);

      fullXmlFileName = this.PROCESSED_FOLDER + xmlFileName;
      this.sftpUtil.sendFile(new File(fullXmlFileName));
      moveFile(xmlFileName, this.PROCESSED_FOLDER, this.QUEUE_FOLDER);

      System.out.println(i);
    }
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderimport.jar
 * Qualified Name:     com.pacsun.hingeto.orderimport.process.OrderImportProcessTest
 * JD-Core Version:    0.6.0
 */