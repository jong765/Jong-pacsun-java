package com.pacsun.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;

public class SchemaValidator
{
  private SAXSource source;
  private FileReader fileReader;
  private boolean validSchema = false;
  private String schemaName = "";
  private File xmlFile = null;
  private int errorCount = 0;
  private static final Logger log = Logger.getLogger(SchemaValidator.class);

  public void validate()
  {
    if ((getSchemaName() != null) && (getSchemaName().length() > 0))
    {
      Schema schema = loadSchema(getSchemaName());

      setValidSchema(validateXml(schema, getXmlFile()));
    }
  }

  private boolean validateXml(Schema schema, File xmlFile) {
    boolean valid = false;
    try
    {
      Validator validator = schema.newValidator();
      log.debug(getClass().getName() + ": Validator Class: " + validator.getClass().getName());
      try
      {
        this.fileReader = new FileReader(xmlFile);
        this.source = new SAXSource(new InputSource(this.fileReader));
      } catch (Exception e) {
        log.error(getClass().getName() + ": getting source XML file to SAX failed.  Errors as follow :\n" + 
          StackTrace.getStackTrace(e));
      }

      try
      {
        validator.validate(this.source);
        valid = true;
      } catch (SAXParseException e) {
        printException(e);
      } catch (IOException e) {
        log.error(getClass().getName() + ": I/O error: " + "Errors as follow :\n" + 
          StackTrace.getStackTrace(e));
      } finally {
        this.fileReader.close();
      }
    }
    catch (Exception e) {
      log.error(getClass().getName() + ": validation failed.  Errors as follow :\n" + 
        StackTrace.getStackTrace(e));
    }

    return valid;
  }

  private Schema loadSchema(String schemaName)
  {
    Schema schema = null;
    try {
      String language = "http://www.w3.org/2001/XMLSchema";
      SchemaFactory factory = SchemaFactory.newInstance(language);
      schema = factory.newSchema(new File(schemaName));
    } catch (Exception e) {
      log.error(getClass().getName() + ": failed loading: " + schemaName + ".  Errors as follow :\n" + 
        StackTrace.getStackTrace(e));
    }
    return schema;
  }

  private void printException(SAXParseException e) {
    this.errorCount += 1;
    log.error(getClass().getName() + ": validation error details for XML: " + " against schema: " + 
      getSchemaName() + "\nError counts: " + Integer.toString(this.errorCount) + "\nLine number: " + 
      e.getLineNumber() + "\nColumn number: " + e.getColumnNumber() + "\nMessage: " + e.getMessage());
    System.out.println(getClass().getName() + ": validation error details for XML: " + " against schema: " + 
      getSchemaName() + "\nError counts: " + Integer.toString(this.errorCount) + "\nLine number: " + 
      e.getLineNumber() + "\nColumn number: " + e.getColumnNumber() + "\nMessage: " + e.getMessage());
  }

  public boolean isValidSchema() {
    return this.validSchema;
  }

  private void setValidSchema(boolean validSchema) {
    this.validSchema = validSchema;
  }

  public String getSchemaName() {
    return this.schemaName;
  }

  public void setSchemaName(String schemaName) {
    this.schemaName = schemaName;
  }

  public File getXmlFile() {
    return this.xmlFile;
  }

  public void setXmlFile(File xmlFile) {
    this.xmlFile = xmlFile;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.util.SchemaValidator
 * JD-Core Version:    0.6.0
 */