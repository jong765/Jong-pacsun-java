package com.pacsun.util;

import java.io.File;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
public class SchemaValidatorTest
{

  @Autowired
  private SchemaValidator schemaValidator;

  @Value("${xml.schema.file}")
  protected String XML_SCHEMA_FILE;

  @Value("${productexport.datafile.queue.folder}")
  protected String QUEUE_FOLDER;

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
  public void test()
    throws Exception
  {
    File xmlFile = new File(this.QUEUE_FOLDER + "ProductFeed1.xml");
    this.schemaValidator.setSchemaName(this.XML_SCHEMA_FILE);
    this.schemaValidator.setXmlFile(xmlFile);
    this.schemaValidator.validate();
    Assert.assertTrue(this.schemaValidator.isValidSchema());
    System.out.println("done.");
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.util.SchemaValidatorTest
 * JD-Core Version:    0.6.0
 */