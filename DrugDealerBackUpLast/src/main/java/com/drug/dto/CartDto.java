package com.drug.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class CartDto {
	
	private int cn;					//장바구니 번호
	private String id;				//장바구니 이용 회원 아이디
	private int pn;					//상품 번호			
	private int quantity;			//수량
	private char result;			//배송 유무 (default:1) 배송 전:1 배송 후:2
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private LocalDateTime indate;	//장바구니 생성일
	private String name;
	private int price;
	private int inventory;
	
	public CartDto() {}
	public CartDto(int cn, String id, int pn, int quantity, char result, LocalDateTime indate, String name, int price,
			int inventory) {
		super();
		this.cn = cn;
		this.id = id;
		this.pn = pn;
		this.quantity = quantity;
		this.result = result;
		this.indate = indate;
		this.name = name;
		this.price = price;
		this.inventory = inventory;
	}
	
	public int getCn() {
		return cn;
	}
	public void setCn(int cn) {
		this.cn = cn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPn() {
		return pn;
	}
	public void setPn(int pn) {
		this.pn = pn;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public char getResult() {
		return result;
	}
	public void setResult(char result) {
		this.result = result;
	}
	public LocalDateTime getIndate() {
		return indate;
	}
	public void setIndate(LocalDateTime indate) {
		this.indate = indate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	@Override
	public String toString() {
		return "CartDto [cn=" + cn + ", id=" + id + ", pn=" + pn + ", quantity=" + quantity + ", result=" + result
				+ ", indate=" + indate + ", name=" + name + ", price=" + price + ", inventory=" + inventory + "]";
	}
	
}