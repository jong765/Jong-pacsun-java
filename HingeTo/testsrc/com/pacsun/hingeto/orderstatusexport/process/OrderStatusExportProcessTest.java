package com.pacsun.hingeto.orderstatusexport.process;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:orderStatusExportApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderStatusExportProcessTest
{

  @Autowired
  private OrderStatusExportProcess orderStatusExportProcess;

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

  @Test
  public void testReceiveFileSftp()
    throws Exception
  {
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_orderstatusexport.jar
 * Qualified Name:     com.pacsun.hingeto.orderstatusexport.process.OrderStatusExportProcessTest
 * JD-Core Version:    0.6.0
 */