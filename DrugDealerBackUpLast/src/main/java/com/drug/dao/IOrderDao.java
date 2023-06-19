package com.drug.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.drug.dto.OrderDto;
import com.drug.dto.OrderPageDto;

public interface IOrderDao {
	public void insert(OrderDto dto) throws Exception;
	public void update(@Param("odnum")Integer odnum,@Param("dt")Character dt) throws Exception;
	public void update_pay(Integer odnum) throws Exception;
	public void delete(int odnum) throws Exception;
	public OrderDto select_dt(Integer odnum) throws Exception;
	public ArrayList<OrderDto> selectAll() throws Exception;
	public ArrayList<OrderDto> select_pay(String id) throws Exception;
	public ArrayList<OrderDto> selectId(String id) throws Exception;
//	public ArrayList<OrderDto> select(ArrayList<OrderDto> orders) throws Exception;
	public OrderDto selectOne(int pn) throws Exception;	
}
