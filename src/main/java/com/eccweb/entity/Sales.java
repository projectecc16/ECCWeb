package com.eccweb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sales {
	 @Id @GeneratedValue
	 private Long id;
	 private String productName;
	 private Long yearOfProd;
	 private Long quantity;
	 private String preBookingDetail;
	 private String deliveryDetail;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	 
}
