package com.pacsun.hingeto.process;

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

@ContextConfiguration({"classpath:orderImportApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class FileProcessTest
{

  @Autowired
  private FileProcess fileProcess;

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
    String xmlFileName = "Orders-20151119_151827.xml";
    String sourceFolder = "Custom/QUA/Merchantry/feed/orderimport/queue/";
    String targetFolder = "Custom/QUA/Merchantry/feed/orderimport/processed/";
    this.fileProcess.moveFile(xmlFileName, sourceFolder, targetFolder);
    System.out.println("Done");
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.hingeto.process.FileProcessTest
 * JD-Core Version:    0.6.0
 */