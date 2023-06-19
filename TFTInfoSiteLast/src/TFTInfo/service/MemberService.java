package TFTInfo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TFTInfoDao.MemberDao;
import TFTInfoDto.MemberDto;

public class MemberService {
	public static MemberDto MemberSelectOne(HttpServletRequest request, HttpServletResponse response) {
		MemberDto dtos= MemberDao.selectId(request.getParameter("ID"));
		request.setAttribute("dtos", dtos);
		return dtos;
	}


	public static void delete(HttpServletRequest request, HttpServletResponse response) {
		MemberDao.delete(request.getParameter("ID"));
		
	}
}
