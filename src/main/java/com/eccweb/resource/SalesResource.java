package com.eccweb.resource;


import com.eccweb.entity.Account;
import com.eccweb.entity.Production;
import com.eccweb.entity.Sales;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesResource {
	private Long rid;
	private String productName;
	private Long yearOfProd;
	private Long quantity;
	private String preBookingDetail;
	private String deliveryDetail;
	
    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
    public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getYearOfProd() {
		return yearOfProd;
	}

	public void setYearOfProd(Long yearOfProd) {
		this.yearOfProd = yearOfProd;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getPreBookingDetail() {
		return preBookingDetail;
	}

	public void setPreBookingDetail(String preBookingDetail) {
		this.preBookingDetail = preBookingDetail;
	}

	public String getDeliveryDetail() {
		return deliveryDetail;
	}

	public void setDeliveryDetail(String deliveryDetail) {
		this.deliveryDetail = deliveryDetail;
	}
    public Sales toSales() {
    	Sales sales = new Sales();
    	sales.setId(rid);
    	sales.setDeliveryDetail(deliveryDetail);
    	sales.setPreBookingDetail(preBookingDetail);
    	sales.setProductName(productName);
    	sales.setQuantity(quantity);
    	sales.setYearOfProd(yearOfProd);
        return sales;
    }
    
    public static SalesResource fromSales(Sales sales) {
    	SalesResource salesRes = new SalesResource();
    	salesRes.setRid(sales.getId());
    	salesRes.setDeliveryDetail(sales.getDeliveryDetail());
    	salesRes.setPreBookingDetail(sales.getPreBookingDetail());
    	salesRes.setProductName(sales.getProductName());
    	salesRes.setQuantity(sales.getQuantity());
    	salesRes.setYearOfProd(sales.getYearOfProd());
    	return salesRes;
    }
}
