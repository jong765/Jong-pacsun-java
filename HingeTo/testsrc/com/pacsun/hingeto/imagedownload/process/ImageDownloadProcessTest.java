package com.pacsun.hingeto.imagedownload.process;

import com.pacsun.hingeto.imagedownload.dto.ImageDto;
import java.io.PrintStream;
import java.util.List;
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

@ContextConfiguration({"classpath:imageDownloadApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ImageDownloadProcessTest
{
  List<ImageDto> imageDtoList;

  @Value("${merchantry.host.name}")
  private String IMAGE_HOST_NAME;

  @Value("${productexport.imagefile.image.queue.folder}")
  private String IMAGE_QUEUE_FOLDER;

  @Value("${merchantry.host.name}")
  private String MERCHANTRY_HOSTNAME;

  @Value("${productexport.imagefile.xml.queue.folder}")
  private String XML_QUEUE_FOLDER;

  @Value("${productexport.imagefile.xml.processed.folder}")
  private String XML_PROCESSED_FOLDER;

  @Value("${productexport.imagefile.xml.failed.folder}")
  private String XML_FAILED_FOLDER;

  @Value("${productexport.datafile.prefix}")
  private String PRODUCT_EXPORT_FILE_PREFIX;

  @Autowired
  ImageDownloadProcess imageDownloadProcess;

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
  public void testDownloadImages()
    throws Exception
  {
    System.out.println("This file contains valid image file:");
    String xmlFileName = "Custom/QUA/Merchantry/feed/productexport/image/processed/xml/Products-2015-12-10-224150-332.dat";

    this.imageDownloadProcess.setContentMessageList(this.imageDownloadProcess.unMarshalListingExportXmlFile(xmlFileName));
    this.imageDownloadProcess.loadImageDtoList(xmlFileName);
    this.imageDownloadProcess.downloadImages();

    System.out.println("END");
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_imagedownload.jar
 * Qualified Name:     com.pacsun.hingeto.imagedownload.process.ImageDownloadProcessTest
 * JD-Core Version:    0.6.0
 */