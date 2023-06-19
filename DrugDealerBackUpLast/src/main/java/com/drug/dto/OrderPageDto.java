package com.drug.dto;

import java.util.ArrayList;

public class OrderPageDto {
	
	private ArrayList<OrderDto> orders;

	public ArrayList<OrderDto> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<OrderDto> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "OrderPageDto [orders=" + orders + "]";
	}
	
	


	

}
