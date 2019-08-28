package com.pacsun.hingeto.productexport.process;

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

@ContextConfiguration({"classpath:productExportApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductExportProcessTest
{

  @Autowired
  ProductExportProcess productExportProcess;

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
  public void testFormatDescription()
  {
    String productDescription = "test is a test  ";
    System.out.println(this.productExportProcess.formatDescription(productDescription));
  }
  @Test
  public void testReceiveFileSftp() throws Exception {
    this.productExportProcess.receiveFileSftp();
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_productexport.jar
 * Qualified Name:     com.pacsun.hingeto.productexport.process.ProductExportProcessTest
 * JD-Core Version:    0.6.0
 */