package com.drug.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.dao.INoticeDao;

import com.drug.dto.NoticeDto;

import com.drug.vo.PageMaker;

@Service
public class NoticeServiceImpl implements INoticeService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void write(NoticeDto board) throws Exception {
		System.out.println(sqlSession);
		INoticeDao dao = sqlSession.getMapper(INoticeDao.class);
		dao.create(board);
	}

	@Override
	public NoticeDto read(int bno) throws Exception {
		INoticeDao dao = sqlSession.getMapper(INoticeDao.class);
		System.out.println(bno);
		return dao.read(bno);
	}

	@Override
	public void modify(NoticeDto board) throws Exception {
		INoticeDao dao = sqlSession.getMapper(INoticeDao.class);
		dao.update(board);
	}

	@Override
	public void remove(int bno) throws Exception {
		INoticeDao dao = sqlSession.getMapper(INoticeDao.class);
		dao.delete(bno);

	}

	@Override
	public List<NoticeDto> listSearchCriteria(PageMaker pm) throws Exception {
		INoticeDao dao = sqlSession.getMapper(INoticeDao.class);
		return dao.listSearch(pm);
	}

	@Override
	public int listSearchCount(PageMaker pm) throws Exception {
		INoticeDao dao = sqlSession.getMapper(INoticeDao.class);
		return dao.listSearchCount(pm);
	}

	@Override
	public void viewCount(int bno) throws Exception {
		INoticeDao dao=sqlSession.getMapper(INoticeDao.class);
		dao.viewCount(bno);
	}

}
