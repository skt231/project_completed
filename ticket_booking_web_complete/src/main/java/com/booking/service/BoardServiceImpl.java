package com.booking.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dao.BoardDao;
import com.booking.dto.BoardDto;
import com.booking.dto.PageDto;

@Service
public class BoardServiceImpl implements BoardService {
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardDto> getAllBoards() throws Exception {
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		List<BoardDto> dtos = boardDao.getAllBoards();
		System.out.println(dtos);
		return dtos;
	}

	@Override
	public BoardDto getBoardById(int board_id, int indent, int depthno) throws Exception {
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		System.out.println(board_id);
		System.out.println(depthno);
		System.out.println(indent);
		return boardDao.getBoardById(board_id, indent, depthno);
	}

	@Override
	public List<BoardDto> getBoardBybull(String bulletin) throws Exception {
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		List<BoardDto> boards = boardDao.getBoardBybull(bulletin);
		System.out.println(bulletin);
		return boards;
	}

	@Override
	public void insertBoard(BoardDto board) throws Exception {
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.insertBoard(board);
	}

	@Override
	public void updateBoard(BoardDto board) throws Exception {
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(int boardId) throws Exception {
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.deleteBoard(boardId);

	}

	@Override
	public List<BoardDto> listSearchCriteria(PageDto page) throws Exception {
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		return dao.listSearch(page);
	}

	@Override
	public int listSearchCount(PageDto page) throws Exception {
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		return dao.listSearchCount(page);
	}

	@Override
	public void viewCount(int board_id) throws Exception {
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		dao.viewCount(board_id);
	}

	@Override
	public void comment_update(BoardDto board) throws Exception {
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		dao.comment_update(board);

	}

	@Override
	public void comment_insert(BoardDto board) throws Exception {
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		dao.comment_insert(board);

	}

}
