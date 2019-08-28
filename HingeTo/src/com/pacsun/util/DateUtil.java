package com.pacsun.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.joda.time.DateTime;
import org.joda.time.DateTime.Property;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil
{
  public static XMLGregorianCalendar getXmlDate(Date date, String dateFormat)
    throws DatatypeConfigurationException
  {
    return DatatypeFactory.newInstance().newXMLGregorianCalendar(new SimpleDateFormat(dateFormat).format(date));
  }

  public static Date convertStringToDate(String dateString, String dateFormat) {
    DateFormat format = new SimpleDateFormat(dateFormat);
    Date date = null;
    try {
      date = format.parse(dateString);
    }
    catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }

  public static XMLGregorianCalendar stringToXMLGregorianCalendar(String stringDateFormat, String s) throws ParseException, DatatypeConfigurationException
  {
    XMLGregorianCalendar result = null;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(stringDateFormat);
    Date date = simpleDateFormat.parse(s);
    GregorianCalendar gregorianCalendar = (GregorianCalendar)GregorianCalendar.getInstance();
    gregorianCalendar.setTime(date);
    result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
    return result;
  }

  public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date) throws ParseException, DatatypeConfigurationException
  {
    XMLGregorianCalendar result = null;

    GregorianCalendar gregorianCalendar = (GregorianCalendar)GregorianCalendar.getInstance();
    gregorianCalendar.setTime(date);
    result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
    return result;
  }

  public static Date xmlGregorianCalendarToDate(XMLGregorianCalendar xmlGc) {
    if (xmlGc == null) {
      return null;
    }
    return xmlGc.toGregorianCalendar().getTime();
  }

  public static String dayOfWeek(String date_yymmdd) {
    DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMdd");
    DateTime dt = formatter.parseDateTime(date_yymmdd);
    return dt.dayOfWeek().getAsText();
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.util.DateUtil
 * JD-Core Version:    0.6.0
 */