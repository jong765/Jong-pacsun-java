package com.pacsun.hingeto.listingexport.process;

import com.pacsun.util.FileUtils;
import java.io.File;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:listingExportApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ListingExportProcessTest
{

  @Autowired
  private ListingExportProcess listingExportProcess;

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
  public void testDownloadFiles()
    throws Exception
  {
    File[] files = this.listingExportProcess.downloadFiles();
    FileUtils.sortFiles(files);

    System.out.println(files[(files.length - 1)].getName());
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_listingexport.jar
 * Qualified Name:     com.pacsun.hingeto.listingexport.process.ListingExportProcessTest
 * JD-Core Version:    0.6.0
 */