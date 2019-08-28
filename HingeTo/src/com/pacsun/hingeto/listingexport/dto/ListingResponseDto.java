package com.pacsun.hingeto.listingexport.dto;

public class ListingResponseDto
{
  private String effectiveSupplierId;
  private String identifier;

  public ListingResponseDto(String effectiveSupplierId, String identifier)
  {
    this.effectiveSupplierId = effectiveSupplierId;
    this.identifier = identifier;
  }

  public String getEffectiveSupplierId() {
    return this.effectiveSupplierId;
  }

  public void setEffectiveSupplierId(String effectiveSupplierId) {
    this.effectiveSupplierId = effectiveSupplierId;
  }

  public String getIdentifier() {
    return this.identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_listingexport.jar
 * Qualified Name:     com.pacsun.hingeto.listingexport.dto.ListingResponseDto
 * JD-Core Version:    0.6.0
 */