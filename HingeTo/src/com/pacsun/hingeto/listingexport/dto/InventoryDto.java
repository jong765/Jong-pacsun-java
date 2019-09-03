package com.pacsun.hingeto.listingexport.dto;

public class InventoryDto {
	private String messageId;
	private String upc;
	private String storeFrontProductId;
	private int quantity;
	private String effectiveSupplierId;
	private String identifier;

	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getUpc() {
		return this.upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getStoreFrontProductId() {
		return this.storeFrontProductId;
	}

	public void setStoreFrontProductId(String storeFrontProductId) {
		this.storeFrontProductId = storeFrontProductId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

/*
 * Location: C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_listingexport.jar Qualified Name:
 * com.pacsun.hingeto.listingexport.dto.InventoryDto JD-Core Version: 0.6.0
 */