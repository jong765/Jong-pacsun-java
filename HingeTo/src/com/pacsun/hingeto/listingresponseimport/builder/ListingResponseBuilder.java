package com.pacsun.hingeto.listingresponseimport.builder;

import com.hingeto.api.Feed;
import com.hingeto.api.ListingIDType;
import com.hingeto.api.ListingResponse;
import com.hingeto.api.ListingResponseItemType;
import com.hingeto.api.ObjectFactory;
import com.hingeto.api.ProcessingResult;
import com.pacsun.hingeto.builder.HeaderDataBuilder;
import com.pacsun.hingeto.listingexport.dao.InventoryDao;
import com.pacsun.hingeto.listingexport.dto.ListingResponseDto;
import com.pacsun.util.StackTrace;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class ListingResponseBuilder
{

  @Autowired
  private ObjectFactory objectFactory;

  @Autowired
  private InventoryDao inventoryTransactionDao;

  @Autowired
  private HeaderDataBuilder headerDataBuilder;
  private Feed feed = null;
  List<ListingResponseDto> listingResponseDtoList;
  private static final Logger log = Logger.getLogger(ListingResponseBuilder.class);

  public Feed build()
    throws Exception
  {
    log.debug("Begin ListingResponseBuilder.build()");
    try {
      this.listingResponseDtoList = this.inventoryTransactionDao.findInventoryRecordsForResponse();

      if (this.listingResponseDtoList.size() > 0) {
        this.feed = this.objectFactory.createFeed();
        this.feed.setHeader(this.headerDataBuilder.build());

        ListingResponse listingResponse = this.objectFactory.createListingResponse();
        List listingResponseItemTypeList = new ArrayList();

        for (ListingResponseDto inventoryResponseDto : this.listingResponseDtoList)
        {
          ListingResponseItemType listingResponseItemType = this.objectFactory.createListingResponseItemType();
          ListingIDType listingIDType = this.objectFactory.createListingIDType();
          listingIDType.setEffectiveSupplierID(inventoryResponseDto.getEffectiveSupplierId());
          listingIDType.setIdentifier(inventoryResponseDto.getIdentifier());
          listingResponseItemType.setListingID(listingIDType);
          listingResponseItemType.setResult(ProcessingResult.SUCCESS);
          listingResponseItemTypeList.add(listingResponseItemType);
        }
        if (listingResponse.getListingResponseItem().addAll(listingResponseItemTypeList))
          this.feed.setListingResponse(listingResponse);
        else
          throw new Exception("Failed to add listResponseItemTypeList.");
      } else {
        this.feed = null;
      }
    } catch (Exception e) {
      log.error(getClass().getName() + " : " + StackTrace.getStackTrace(e));
      throw new Exception(e);
    }
    log.debug("End ListingResponseBuilder.build()");
    return this.feed;
  }

  public Feed getFeed()
  {
    return this.feed;
  }

  public void setFeed(Feed feed) {
    this.feed = feed;
  }

  public List<ListingResponseDto> getListingResponseDtoList() {
    return this.listingResponseDtoList;
  }

  public void setListingResponseDtoList(List<ListingResponseDto> listingResponseDtoList) {
    this.listingResponseDtoList = listingResponseDtoList;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_listingexport.jar
 * Qualified Name:     com.pacsun.hingeto.listingresponseimport.builder.ListingResponseBuilder
 * JD-Core Version:    0.6.0
 */