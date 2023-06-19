package com.drug.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class DrugDto {
	private int pn;					//상품 번호
	private String name;			//상품 이름
	private int price;				//상품 가격
	private String origin;			//상품 원산지
	private char category;			//상품 분류
	private String content;			//상품 설명
	private int inventory;			//상품 재고
	private char sellable;			//상품 판매 가능 여부 (y:가능 n:불가능)
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private LocalDateTime regdate;	//상품 등록일
	private int ps;					//상품 등록 번호 (글번호 개념)
	
	

	public int getPn() {
		return pn;
	}
	public void setPn(int pn) {
		this.pn = pn;
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
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public char getCategory() {
		return category;
	}
	public void setCategory(char category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public char getSellable() {
		return sellable;
	}
	public void setSellable(char sellable) {
		this.sellable = sellable;
	}
	public LocalDateTime getRegdate() {
		return regdate;
	}
	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	
	@Override
	public String toString() {
		return "DrugDto [pn=" + pn + ", name=" + name + ", price=" + price + ", origin=" + origin + ", category="
				+ category + ", content=" + content + ", inventory=" + inventory + ", sellable=" + sellable
				+ ", regdate=" + regdate + ", ps=" + ps + "]";
	}
	
	public DrugDto() {}
	public DrugDto(int pn, String name, int price, String origin, char category, String content, int inventory,
			char sellable, LocalDateTime regdate, int ps) {
		super();
		this.pn = pn;
		this.name = name;
		this.price = price;
		this.origin = origin;
		this.category = category;
		this.content = content;
		this.inventory = inventory;
		this.sellable = sellable;
		this.regdate = regdate;
		this.ps = ps;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pn;
		result = prime * result + ps;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DrugDto other = (DrugDto) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pn != other.pn)
			return false;
		if (ps != other.ps)
			return false;
		return true;
	}

}