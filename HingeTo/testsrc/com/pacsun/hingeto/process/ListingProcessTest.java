package com.pacsun.hingeto.process;

import com.pacsun.hingeto.productexport.process.ProductExportProcess;
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

@ContextConfiguration({"classpath:productExportApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ListingProcessTest
{

  @Autowired
  ProductExportProcess productExportProcess;

  @Value("${listingexport.file.queue.folder}")
  protected String LISTING_EXPORT_QUEUE_FOLDER;

  @Value("${listingexport.file.prefix}")
  private String LISTING_EXPORT_FILE_PREFIX;

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
    File[] files = this.productExportProcess.getQueuedFiles(this.LISTING_EXPORT_QUEUE_FOLDER, this.LISTING_EXPORT_FILE_PREFIX, ".xml");
    System.out.println("done");
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.hingeto.process.ListingProcessTest
 * JD-Core Version:    0.6.0
 */