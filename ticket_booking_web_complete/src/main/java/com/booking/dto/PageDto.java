package com.booking.dto;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageDto {
	private int page = 1; // 현재 페이지
	private int perPageNum = 10; // 페이지당 데이터 개수
	private String searchType; // 검색할 컬럼
	private String keyword; // 검색 내용

	private int totalCount; // 전체 data갯수
	private int totalStartPage = 1; // 첫 page
	private int totalEndPage; // 끝 page
	private int startPage; // pageMake에서 시작 페이지 번호
	private int endPage; // pageMaker에서 마지막 페이지 번호
	private boolean prev; // 이전 페이지 번호 목록 이동
	private boolean next; // 다음 페이지 목록 이동
							// pageMaker에서 사용자에게 제공하는 한 화면에서 보여줄 페이지 개수
	private int displayPageNum = 5;

	public int getTotalStartPage() {
		return totalStartPage;
	}

	public void setTotalStartPage(int totalStartPage) {
		this.totalStartPage = totalStartPage;
	}

	public int getTotalEndPage() {
		return totalEndPage;
	}

	public void setTotalEndPage(int totalEndPage) {
		this.totalEndPage = totalEndPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			page = 1;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			perPageNum = 10;
		}
		this.perPageNum = perPageNum;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}

	public void calcData() {
		int tempEndPage = (int) (Math.ceil((double) page / displayPageNum) * displayPageNum);
		startPage = tempEndPage - (displayPageNum - 1);
		int totalEndPage = (int) (Math.ceil((double) totalCount / perPageNum));
		endPage = (totalEndPage < tempEndPage) ? totalEndPage : tempEndPage;

		prev = startPage > 1;
		next = endPage < totalEndPage;
		if (totalEndPage < endPage) {
			endPage = totalEndPage;
		}

		if (startPage < 1) {
			startPage = 1;
		}
		if (startPage == 1) {
			prev = false;
		} else {
			prev = true;
		}
		if (endPage == totalEndPage) {
			next = false;
		} else {
			next = true;
		}

	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "PageDto [page=" + page + ", perPageNum=" + perPageNum + ", searchType=" + searchType + ", keyword="
				+ keyword + ", totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", prev=" + prev + ", next=" + next + "]";
	}

	public String makeSearch() {
		UriComponents u = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", perPageNum).queryParam("searchType", searchType)
				.queryParam("keyword", keyword).build();
		return u.toUriString();
	}

	public String makeSearch(int page) {
		UriComponents u = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", perPageNum).queryParam("searchType", searchType)
				.queryParam("keyword", keyword).build();
		return u.toUriString();
	}

	public String makePage(int page) {
		UriComponents u = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", perPageNum).build();
		return u.toUriString();
	}

}
