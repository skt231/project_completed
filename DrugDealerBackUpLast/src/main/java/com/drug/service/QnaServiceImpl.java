package com.drug.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.dao.QnaDao;
import com.drug.dto.QnaDto;
import com.drug.vo.PageMaker;

@Service
public class QnaServiceImpl implements IQnaService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void write(QnaDto board) throws Exception {
		System.out.println(sqlSession);
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		dao.create(board);
	}

	@Override
	public QnaDto read(int bno, int indent, int depthno) throws Exception {
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		System.out.println(bno);
		System.out.println(depthno);
		System.out.println(indent);
		return dao.read(bno, indent, depthno);
	}

	@Override
	public void modify(QnaDto board) throws Exception {
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		dao.update(board);
	}

	@Override
	public void remove(int bno) throws Exception {
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		dao.delete(bno);

	}

	@Override
	public List<QnaDto> listSearchCriteria(PageMaker pm) throws Exception {
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		return dao.listSearch(pm);
	}

	@Override
	public int listSearchCount(PageMaker pm) throws Exception {
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		return dao.listSearchCount(pm);
	}

	@Override
	public void viewCount(int bno) throws Exception {
		QnaDao dao=sqlSession.getMapper(QnaDao.class);
		dao.viewCount(bno);
	}

	@Override
	public void reply_update(QnaDto dto) throws Exception {
		// TODO Auto-generated method stub
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		dao.reply_update(dto);
	}
	@Override
	public void reply_insert(QnaDto dto) throws Exception {
		// TODO Auto-generated method stub
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		dao.reply_insert(dto);
	}

	@Override
	public QnaDto select_bno(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		System.out.println(dao.select_bno(bno));
		return dao.select_bno(bno);
	}

}
