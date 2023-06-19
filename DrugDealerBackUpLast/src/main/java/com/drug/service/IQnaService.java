package com.drug.service;

import java.util.List;

import com.drug.dto.QnaDto;
import com.drug.vo.PageMaker;

public interface IQnaService {
	public void write(QnaDto board) throws Exception;
	public QnaDto read(int bno, int indent, int depthno) throws Exception;
	public void modify(QnaDto board) throws Exception;
	public void remove(int bno) throws Exception;
	
	public List<QnaDto> listSearchCriteria(PageMaker pm) throws Exception;
	public int listSearchCount(PageMaker pm) throws Exception;
	public void viewCount(int bno) throws Exception;
	public void reply_update(QnaDto dto) throws Exception;
	public void reply_insert(QnaDto dto) throws Exception;
	public QnaDto select_bno(Integer bno) throws Exception;
	}
	

