package com.pacsun.hingeto.process;

import com.pacsun.util.FileUtils;
import com.pacsun.util.SchemaValidator;
import com.pacsun.util.SftpUtil;
import java.io.File;
import java.util.Arrays;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class ListingProcess
{

  @Autowired
  private SchemaValidator schemaValidator;

  @Autowired
  protected SftpUtil sftpUtil;

  @Value("${xml.schema.file}")
  protected String XML_SCHEMA_FILE;

  @Value("${file.move.retrial.attempt}")
  private String RETRIAL_ATTEMPT;

  @Value("${file.move.retrial.interval}")
  private String RETRIAL_INTERVAL;
  protected String xmlString;
  protected String fullXmlFileName;
  protected static String errorMessage = "";

  private static final Logger log = Logger.getLogger(ListingProcess.class);

  protected boolean validXml(File xmlFile) {
    this.schemaValidator.setSchemaName(this.XML_SCHEMA_FILE);
    this.schemaValidator.setXmlFile(xmlFile);
    this.schemaValidator.validate();
    return this.schemaValidator.isValidSchema();
  }

  public void moveFile(String xmlFileName, String sourceFolder, String targetFolder) throws Exception {
    String fromFullFileName = sourceFolder + xmlFileName;
    String toFullFileName = targetFolder + xmlFileName;

    boolean retryMoveFile = true;
    int retrialCount = 0;

    while (retryMoveFile)
      if (!FileUtils.moveFile(fromFullFileName, toFullFileName)) {
        if (retrialCount < Integer.parseInt(this.RETRIAL_ATTEMPT)) {
          retrialCount++;
          errorMessage = getClass().getName() + " : " + "Error in moving file " + xmlFileName + " from " + 
            sourceFolder + " to " + targetFolder;
          log.error(errorMessage);
          Thread.sleep(Integer.parseInt(this.RETRIAL_INTERVAL));
        } else {
          throw new Exception();
        }
      } else retryMoveFile = false;
  }

  public File[] getQueuedFiles(String folderPath, String filePrefix, String fileExtension)
  {
    File[] fileList = FileUtils.listFiles(folderPath, filePrefix, fileExtension);
    Arrays.sort(fileList);
    return fileList;
  }

  public String getFullXmlFileName() {
    return this.fullXmlFileName;
  }

  public void setFullXmlFileName(String fullXmlFileName) {
    this.fullXmlFileName = fullXmlFileName;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.hingeto.process.ListingProcess
 * JD-Core Version:    0.6.0
 */