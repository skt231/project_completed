package com.drug.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.drug.dto.QnaDto;
import com.drug.vo.PageMaker;

public interface QnaDao {
	  public void create(QnaDto vo) throws Exception;
	  public QnaDto read(@Param("bno")int bno, @Param("indent")int indent, @Param("depthno")int depthno) throws Exception;

	  public void update(QnaDto vo) throws Exception;

	  public void delete(int bno) throws Exception;

	//  
	  public List<QnaDto> listSearch(PageMaker pm)throws Exception;
	//  
	  public int listSearchCount(PageMaker pm)throws Exception;

	  //viewcnt
	  public void viewCount(int bno)throws Exception;
	  
	  public void reply_update(QnaDto dto) throws Exception;
	  public void reply_insert(QnaDto dto) throws Exception;
	  
	  public QnaDto select_bno(Integer bno) throws Exception;
	  
}
