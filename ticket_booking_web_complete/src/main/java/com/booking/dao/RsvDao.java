package com.booking.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.booking.dto.RsvDto;

public interface RsvDao {
	public void RsvInsert(RsvDto Rsv) throws Exception;

	public List<RsvDto> getRsvId(Integer userid) throws Exception;

	public void deleteRsv(Integer userid, List<String> re_selectedSeats, String re_mt20id) throws Exception;

	public List<String> RsvSeats(@Param("re_mt20id") String re_mt20id, @Param("re_time") String re_time, @Param("re_showdate") String re_showdate);
}
