package com.drug.service;

import java.util.List;

import com.drug.dto.NoticeDto;
import com.drug.vo.PageMaker;

public interface INoticeService {
	public void write(NoticeDto board) throws Exception;
	public NoticeDto read(int bno) throws Exception;
	public void modify(NoticeDto board) throws Exception;
	public void remove(int bno) throws Exception;
	public List<NoticeDto> listSearchCriteria(PageMaker pm) throws Exception;
	public int listSearchCount(PageMaker pm) throws Exception;
	public void viewCount(int bno) throws Exception;
	}
	

