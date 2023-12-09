package com.booking.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.booking.dto.BoardDto;
import com.booking.dto.PageDto;

public interface BoardDao {

	// 게시글 작성
	public void insertBoard(BoardDto board) throws Exception;

	// 게시글 목록 조회
	public List<BoardDto> getAllBoards() throws Exception;

	// 게시글 상세 조회
	public BoardDto getBoardById(@Param("board_id") int board_id, @Param("indent") int indent,
			@Param("depthno") int depthno) throws Exception;

	// 게시글 분류
	public List<BoardDto> getBoardBybull(@Param("bulletin") String bulletin) throws Exception;

	// 게시글 수정
	public void updateBoard(BoardDto board) throws Exception;

	// 게시글 삭제
	public void deleteBoard(int board_id) throws Exception;

	public List<BoardDto> listSearch(PageDto page) throws Exception;

	public int listSearchCount(PageDto page) throws Exception;

	public void viewCount(int board_id) throws Exception;

	/* comment */
	public void comment_update(BoardDto dto) throws Exception;

	public void comment_insert(BoardDto dto) throws Exception;

}