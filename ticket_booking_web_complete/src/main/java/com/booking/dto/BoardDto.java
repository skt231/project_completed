package com.booking.dto;

import java.util.Date;

import org.springframework.web.bind.annotation.ModelAttribute;

public class BoardDto {
	private String bulletin; // 말머리
	private Integer board_id; // 게시글 ID
	private Integer user_id; // 사용자 ID
	private String title; // 게시글 제목
	private String content; // 게시글 내용
	private Date create_date; // 작성일
	private Date update_date; // 수정일
	private String username; // 게시글 작성자의 username
	private Integer viewcnt;// 조회수
	private Integer depthno; // depthno
	private Integer indent; // 들여쓰기
	// 기본 생성자

	public BoardDto(Integer board_id, Integer user_id, String title, String content, Date create_date, Date update_date,
			String username, Integer viewcnt, Integer depthno, Integer indent, String bulletin) {
		super();
		this.bulletin = bulletin;
		this.board_id = board_id;
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.create_date = create_date;
		this.update_date = update_date;
		this.username = username;
		this.viewcnt = viewcnt;
		this.depthno = depthno;
		this.indent = indent;
	}

	public String getBulletin() {
		return bulletin;
	}

	public void setBulletin(String bulletin) {
		this.bulletin = bulletin;
	}

	public Integer getDepthno() {
		return depthno;
	}

	public void setDepthno(Integer depthno) {
		this.depthno = depthno;
	}

	public Integer getIndent() {
		return indent;
	}

	public void setIndent(Integer indent) {
		this.indent = indent;
	}

	public BoardDto() {
	}

	// Getter 및 Setter 메소드들
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardDto other = (BoardDto) obj;
		if (board_id == null) {
			if (other.board_id != null)
				return false;
		} else if (!board_id.equals(other.board_id))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (create_date == null) {
			if (other.create_date != null)
				return false;
		} else if (!create_date.equals(other.create_date))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (update_date == null) {
			if (other.update_date != null)
				return false;
		} else if (!update_date.equals(other.update_date))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (viewcnt == null) {
			if (other.viewcnt != null)
				return false;
		} else if (!viewcnt.equals(other.viewcnt))
			return false;
		if (bulletin == null) {
			if (other.bulletin != null)
				return false;
		} else if (!bulletin.equals(other.bulletin))
			return false;
		return true;
	}

	public Integer getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(Integer viewcnt) {
		this.viewcnt = viewcnt;
	}

	public Integer getBoard_id() {
		return board_id;
	}

	public BoardDto getBoard_id(BoardDto board_id) {
		return board_id;
	}

	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "BoardDto [board_id=" + board_id + ", user_id=" + user_id + ", title=" + title + ", content=" + content
				+ ", create_date=" + create_date + ", update_date=" + update_date + ", username=" + username
				+ ", viewcnt=" + viewcnt + ", depthno=" + depthno + ", indent=" + indent + ", bulletin=" + bulletin
				+ "]";
	}

}
