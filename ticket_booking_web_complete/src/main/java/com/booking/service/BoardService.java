package com.booking.service;

import java.util.List;

import com.booking.dto.BoardDto;
import com.booking.dto.PageDto;

public interface BoardService {
	public List<BoardDto> getAllBoards() throws Exception;

	public BoardDto getBoardById(int board_id, int indent, int depthno) throws Exception;

	public List<BoardDto> getBoardBybull(String bulletin) throws Exception;

	public void insertBoard(BoardDto board) throws Exception;

	public void updateBoard(BoardDto board) throws Exception;

	public void deleteBoard(int boardId) throws Exception;

	public List<BoardDto> listSearchCriteria(PageDto page) throws Exception;

	public int listSearchCount(PageDto dto) throws Exception;

	public void viewCount(int board_id) throws Exception;

	public void comment_update(BoardDto dto) throws Exception;

	public void comment_insert(BoardDto dto) throws Exception;

}
