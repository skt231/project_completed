package com.drug.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.drug.dto.CartDto;
import com.drug.dto.CartDto;

public interface ICartDao {
	//장바구니 수량 추가
	public void insert (CartDto dto) throws Exception;
	
	//장바구니 전체 확인
	public List<CartDto> selectAll() throws Exception;
	
	//장바구니 담긴 수량 확인
	public List<CartDto> checkCart(@Param("pn")Integer pn,@Param("id")String id) throws Exception;
	
	//장바구니 회원별 확인
	public List<CartDto> selectId(String id) throws Exception;
	
	//장바구니 개별 삭제 - 상품
	public void delete(String cn) throws Exception;
	
	//장바구니 전체 삭제
	public void deleteAll(String id) throws Exception;
	
	//장바구니 수량 수정
	public void update(CartDto dto) throws Exception;

}