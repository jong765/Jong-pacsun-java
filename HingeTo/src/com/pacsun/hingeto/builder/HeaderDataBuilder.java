package com.pacsun.hingeto.builder;

import com.hingeto.api.Header;
import com.hingeto.api.ObjectFactory;
import com.pacsun.util.DateFormatterUtil;
import com.pacsun.util.DateUtil;
import java.util.Date;
import javax.xml.datatype.DatatypeConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class HeaderDataBuilder
{

  @Autowired
  private ObjectFactory objectFactory;

  @Value("${header.senderid}")
  private String HEADER_SENDERID;

  @Value("${header.sendername}")
  private String HEADER_SENDERNAME;

  @Value("${header.source.channelid}")
  private String HEADER_SOURCE_CHANNELID;

  @Value("${header.receiverid}")
  private String HEADER_RECEIVERID;

  @Value("${header.destination.channelid}")
  private String HEADER_DESTINATION_CHANNELID;

  public Header build()
    throws DatatypeConfigurationException
  {
    Header header = this.objectFactory.createHeader();
    try {
      String documentGUID = "DGUID" + DateFormatterUtil.getCurrentDate() + DateFormatterUtil.getCurrentTime();
      header.setDocumentGUID(documentGUID);
      header.setSenderID(this.HEADER_SENDERID);
      header.setSenderName(this.HEADER_SENDERNAME);
      header.setDocumentCreationDate(DateUtil.getXmlDate(new Date(), "yyyy-MM-dd'T'HH:mm:ss'.0Z'"));
      header.setSourceChannelID(this.HEADER_SOURCE_CHANNELID);
      header.setReceiverID(this.HEADER_RECEIVERID);
      header.setDestinationChannelID(this.HEADER_DESTINATION_CHANNELID);
    } catch (DatatypeConfigurationException e) {
      throw new DatatypeConfigurationException(e);
    }
    return header;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.hingeto.builder.HeaderDataBuilder
 * JD-Core Version:    0.6.0
 */