package com.booking.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dao.RsvDao;
import com.booking.dto.RsvDto;

@Service
public class RsvServiceImpl implements RsvService {

	@Autowired
	private SqlSession sqlsession;

	@Override
	public void RsvInsert(RsvDto Rsv) throws Exception {
		RsvDao rsvDao = sqlsession.getMapper(RsvDao.class);
		rsvDao.RsvInsert(Rsv);
		/*
		 * RsvDto insertData=(RsvDto) rsvDao.getRsvId(Rsv.getUserid());
		 * System.out.println(insertData);
		 */
	}

	@Override
	public List<RsvDto> getRsvId(Integer userid) throws Exception {
		RsvDao rsvDao = sqlsession.getMapper(RsvDao.class);
		List<RsvDto> rsv = rsvDao.getRsvId(userid);
		System.out.println(userid);
		System.out.println(rsv);
		return rsv;
	}

	@Override
	public void deleteRsv(Integer userid, List<String> re_selectedSeats, String re_mt20id) throws Exception {
		RsvDao rsvDao = sqlsession.getMapper(RsvDao.class);
		rsvDao.deleteRsv(userid, re_selectedSeats, re_mt20id);
	}

	@Override
	public List<String> RsvSeats(String re_mt20id, String re_time, String re_showdate) throws Exception {
		RsvDao rsvDao = sqlsession.getMapper(RsvDao.class);

		System.out.println(re_mt20id);
		System.out.println(re_time);
		System.out.println(re_showdate);
		return rsvDao.RsvSeats(re_mt20id, re_time, re_showdate);
	}

}
