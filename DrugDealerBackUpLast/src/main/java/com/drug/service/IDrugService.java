package com.drug.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.drug.dto.DrugDto;
import com.drug.vo.PageMaker;

public interface IDrugService {
	public void insert(DrugDto dto) throws Exception;
	public void update(DrugDto dto) throws Exception;
	public void delete(int pn) throws Exception;
	public ArrayList<DrugDto> selectAll() throws Exception;
	public DrugDto selectName(int pn) throws Exception;
	public void update_inventory(@Param("inventory")int inventory,@Param("pn")int pn) throws Exception;
	public List<DrugDto> listSearchCriteria(PageMaker pm) throws Exception;
	public List<DrugDto> listSearch_VIP(PageMaker pm)throws Exception;
	public int listSearchCount(PageMaker pm) throws Exception;
	public int listSearchCount_VIP(PageMaker pm)throws Exception;
}
