package com.drug.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.drug.dto.NoticeDto;
import com.drug.vo.PageMaker;

public interface INoticeDao {
	public void create(NoticeDto vo) throws Exception;

	public NoticeDto read(@Param("bno") int bno) throws Exception;

	public void update(NoticeDto vo) throws Exception;

	public void delete(int bno) throws Exception;

	//
	public List<NoticeDto> listSearch(PageMaker pm) throws Exception;

	//
	public int listSearchCount(PageMaker pm) throws Exception;

	// viewcnt
	public void viewCount(int bno) throws Exception;
}
