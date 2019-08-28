package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"header", "products", "imageURLs", "categoryAssignments", "listings", "fullProducts", "orders", "rmAs", "refundRequests", "refunds", "returns", "orderStatus", "storefrontTree", "shippingCalculations", "processingResponse", "newProductAuthorization", "newProductAuthorizationResponse", "productResponse", "listingResponse", "suppliers", "supplierCommissions", "validationResults"})
@XmlRootElement(name="feed")
public class Feed
{

  @XmlElement(name="Header", required=true)
  protected Header header;

  @XmlElement(name="Products")
  protected ProductContentList products;

  @XmlElement(name="ImageURLs")
  protected ImageURLList imageURLs;

  @XmlElement(name="CategoryAssignments")
  protected CategoryAssignmentList categoryAssignments;

  @XmlElement(name="Listings")
  protected ListingList listings;

  @XmlElement(name="FullProducts")
  protected FullProductList fullProducts;

  @XmlElement(name="Orders")
  protected OrderList orders;

  @XmlElement(name="RMAs")
  protected RMAList rmAs;

  @XmlElement(name="RefundRequests")
  protected RefundRequestList refundRequests;

  @XmlElement(name="Refunds")
  protected RefundList refunds;

  @XmlElement(name="Returns")
  protected ReturnList returns;

  @XmlElement(name="OrderStatus")
  protected OrderStatusList orderStatus;

  @XmlElement(name="StorefrontTree")
  protected StorefrontTree storefrontTree;

  @XmlElement(name="ShippingCalculations")
  protected ShippingCalculationList shippingCalculations;

  @XmlElement(name="ProcessingResponse")
  protected ProcessingResponse processingResponse;

  @XmlElement(name="NewProductAuthorization")
  protected ProductContentList newProductAuthorization;

  @XmlElement(name="NewProductAuthorizationResponse")
  protected NewProductAuthorizationResponse newProductAuthorizationResponse;

  @XmlElement(name="ProductResponse")
  protected ProductResponse productResponse;

  @XmlElement(name="ListingResponse")
  protected ListingResponse listingResponse;

  @XmlElement(name="Suppliers")
  protected SupplierList suppliers;

  @XmlElement(name="SupplierCommissions")
  protected SupplierCommissionList supplierCommissions;
  protected ValidationResults validationResults;

  public Header getHeader()
  {
    return this.header;
  }

  public void setHeader(Header value)
  {
    this.header = value;
  }

  public ProductContentList getProducts()
  {
    return this.products;
  }

  public void setProducts(ProductContentList value)
  {
    this.products = value;
  }

  public ImageURLList getImageURLs()
  {
    return this.imageURLs;
  }

  public void setImageURLs(ImageURLList value)
  {
    this.imageURLs = value;
  }

  public CategoryAssignmentList getCategoryAssignments()
  {
    return this.categoryAssignments;
  }

  public void setCategoryAssignments(CategoryAssignmentList value)
  {
    this.categoryAssignments = value;
  }

  public ListingList getListings()
  {
    return this.listings;
  }

  public void setListings(ListingList value)
  {
    this.listings = value;
  }

  public FullProductList getFullProducts()
  {
    return this.fullProducts;
  }

  public void setFullProducts(FullProductList value)
  {
    this.fullProducts = value;
  }

  public OrderList getOrders()
  {
    return this.orders;
  }

  public void setOrders(OrderList value)
  {
    this.orders = value;
  }

  public RMAList getRMAs()
  {
    return this.rmAs;
  }

  public void setRMAs(RMAList value)
  {
    this.rmAs = value;
  }

  public RefundRequestList getRefundRequests()
  {
    return this.refundRequests;
  }

  public void setRefundRequests(RefundRequestList value)
  {
    this.refundRequests = value;
  }

  public RefundList getRefunds()
  {
    return this.refunds;
  }

  public void setRefunds(RefundList value)
  {
    this.refunds = value;
  }

  public ReturnList getReturns()
  {
    return this.returns;
  }

  public void setReturns(ReturnList value)
  {
    this.returns = value;
  }

  public OrderStatusList getOrderStatus()
  {
    return this.orderStatus;
  }

  public void setOrderStatus(OrderStatusList value)
  {
    this.orderStatus = value;
  }

  public StorefrontTree getStorefrontTree()
  {
    return this.storefrontTree;
  }

  public void setStorefrontTree(StorefrontTree value)
  {
    this.storefrontTree = value;
  }

  public ShippingCalculationList getShippingCalculations()
  {
    return this.shippingCalculations;
  }

  public void setShippingCalculations(ShippingCalculationList value)
  {
    this.shippingCalculations = value;
  }

  public ProcessingResponse getProcessingResponse()
  {
    return this.processingResponse;
  }

  public void setProcessingResponse(ProcessingResponse value)
  {
    this.processingResponse = value;
  }

  public ProductContentList getNewProductAuthorization()
  {
    return this.newProductAuthorization;
  }

  public void setNewProductAuthorization(ProductContentList value)
  {
    this.newProductAuthorization = value;
  }

  public NewProductAuthorizationResponse getNewProductAuthorizationResponse()
  {
    return this.newProductAuthorizationResponse;
  }

  public void setNewProductAuthorizationResponse(NewProductAuthorizationResponse value)
  {
    this.newProductAuthorizationResponse = value;
  }

  public ProductResponse getProductResponse()
  {
    return this.productResponse;
  }

  public void setProductResponse(ProductResponse value)
  {
    this.productResponse = value;
  }

  public ListingResponse getListingResponse()
  {
    return this.listingResponse;
  }

  public void setListingResponse(ListingResponse value)
  {
    this.listingResponse = value;
  }

  public SupplierList getSuppliers()
  {
    return this.suppliers;
  }

  public void setSuppliers(SupplierList value)
  {
    this.suppliers = value;
  }

  public SupplierCommissionList getSupplierCommissions()
  {
    return this.supplierCommissions;
  }

  public void setSupplierCommissions(SupplierCommissionList value)
  {
    this.supplierCommissions = value;
  }

  public ValidationResults getValidationResults()
  {
    return this.validationResults;
  }

  public void setValidationResults(ValidationResults value)
  {
    this.validationResults = value;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.hingeto.api.Feed
 * JD-Core Version:    0.6.0
 */