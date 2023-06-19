package com.drug.dto;

import java.util.Date;

public class OrderDto {
	
	private Integer odnum;		// 주문 번호
	private Integer pn;			// 상품 번호
	private Integer quantity;	// 주문 갯수
	private Integer price;		// 상품 가격
	private Character dt;	// 배송 이력
	private Integer inventory;
	private String id;
	private Date order_date;
	private String pay;
	
	public OrderDto() {}

	public OrderDto(Integer odnum, Integer pn, Integer quantity, Integer price, Character dt, Integer inventory,
			String id, Date order_date, String pay) {
		super();
		this.odnum = odnum;
		this.pn = pn;
		this.quantity = quantity;
		this.price = price;
		this.dt = dt;
		this.inventory = inventory;
		this.id = id;
		this.order_date = order_date;
		this.pay = pay;
	}

	public Integer getOdnum() {
		return odnum;
	}

	public void setOdnum(Integer odnum) {
		this.odnum = odnum;
	}

	public Integer getPn() {
		return pn;
	}

	public void setPn(Integer pn) {
		this.pn = pn;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Character getDt() {
		return dt;
	}

	public void setDt(Character dt) {
		this.dt = dt;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "OrderDto [odnum=" + odnum + ", pn=" + pn + ", quantity=" + quantity + ", price=" + price + ", dt=" + dt
				+ ", inventory=" + inventory + ", id=" + id + ", order_date=" + order_date + ", pay=" + pay + "]";
	}
	
	
}