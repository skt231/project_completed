package com.booking.service;

import java.util.List;

import com.booking.dto.RsvDto;

public interface RsvService {
	public void RsvInsert(RsvDto Rsv) throws Exception;

	public List<RsvDto> getRsvId(Integer userid) throws Exception;

	public void deleteRsv(Integer userid, List<String> re_selectedSeats, String re_mt20id) throws Exception;

	 public List<String> RsvSeats(String re_mt20id, String re_time, String re_showdate) throws Exception;

}
