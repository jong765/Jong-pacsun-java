package com.pacsun.util;

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.log4j.Logger;

public class JAXBMarshallerUtil
{
  private static String errorMessage = "";
  private static final Logger log = Logger.getLogger(JAXBMarshallerUtil.class);

  public String getXMLString(Class<?> className, Object classObject) throws Exception {
    log.debug("Begin JAXBMarshallerUtil.getXMLString()");

    StringWriter stringWriter = null;
    try {
      Marshaller jaxbMarshaller = getMarshaller(className);
      jaxbMarshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
      stringWriter = new StringWriter();
      jaxbMarshaller.marshal(classObject, stringWriter);
    } catch (JAXBException e) {
      errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
      log.error(errorMessage);
      throw new Exception(errorMessage);
    }
    Marshaller jaxbMarshaller;
    log.debug("End JAXBMarshallerUtil.getXMLString()");
    return stringWriter.toString();
  }

  private Marshaller getMarshaller(Class<?> className) throws Exception {
    log.debug("Begin JAXBMarshallerUtil.getMarshaller()");
    Marshaller jaxbMarshaller = null;
    try
    {
      JAXBContext jaxbContext = JAXBContext.newInstance(new Class[] { className });
      jaxbMarshaller = jaxbContext.createMarshaller();
    } catch (JAXBException e) {
      errorMessage = getClass().getName() + " : " + StackTrace.getStackTrace(e);
      log.error(errorMessage);
      throw new Exception(errorMessage);
    }
    JAXBContext jaxbContext;
    log.debug("End JAXBMarshallerUtil.getMarshaller()");
    return jaxbMarshaller;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.util.JAXBMarshallerUtil
 * JD-Core Version:    0.6.0
 */