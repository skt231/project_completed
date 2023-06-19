package TFTInfo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import TFTInfo.util.DBConn;
import TFTInfoDao.ChampionSynergyDao;
import TFTInfoDao.TFTInfoDao;
import TFTInfoDao.TFTInfoSynergeDao;
import TFTInfoDto.ChampionSynergeDto;
import TFTInfoDto.TFTInfoChampionDto;
import TFTInfoDto.TFTInfoSynergeDto;

public class TFTInfoService {
	public static TFTInfoDao c_dao = new TFTInfoDao();
	public static TFTInfoSynergeDao s_dao = new TFTInfoSynergeDao();
	public static ChampionSynergyDao tftInfoDao = new ChampionSynergyDao();
	
	public static void serch(HttpServletRequest request, HttpServletResponse response) {
		String menu = request.getParameter("menu");
		String keyword = request.getParameter("keyword");
		
		ArrayList<ChampionSynergeDto> dtos = tftInfoDao.serch(menu,keyword);
		request.setAttribute("dtos", dtos);
		
	}
	
	public static void selectOne(HttpServletRequest request, HttpServletResponse response) {
		ChampionSynergeDto dto = new ChampionSynergeDto();
		String name = request.getParameter("name");
		String skill = request.getParameter("skill");
		ResultSet rs = DBConn.statementQuery(String.format(
				"select champion.*,synerge.synerge1, synerge.synerge2,synerge.synerge3"
						+ " from champion, synerge where champion.name=synerge.name(+)"
						+ "and champion.name='%s' and champion.skill='%s'",name, skill));
		if (rs != null) {
			try {
				while (rs.next()) {
					dto = new ChampionSynergeDto(rs.getString("name"), rs.getString("Skill"), rs.getInt("price"),
							new TFTInfoSynergeDto(rs.getString("name"), rs.getString("synerge1"),
									rs.getString("synerge2"), rs.getString("synerge3")));
					System.out.println(rs.getString("name"));
					System.out.println(rs.getString("skill"));
					System.out.println(rs.getInt("price"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(dto);
		request.setAttribute("dto", dto);
		
		rs = DBConn.statementQuery(String.format("update count set count=count+1 where name = '%s'",name));
		 
	}
	public static void insert(HttpServletRequest request, HttpServletResponse response) {
		TFTInfoChampionDto c_dto = new TFTInfoChampionDto(
				request.getParameter("name"),
				request.getParameter("skill"),
				Integer.parseInt(request.getParameter("price")));
		c_dao.insert(c_dto);
		System.out.println(c_dto);
		
		TFTInfoSynergeDto s_dto = new TFTInfoSynergeDto(
				request.getParameter("name"),
				request.getParameter("synerge1"),
				request.getParameter("synerge2"),
				request.getParameter("synerge3"));
		s_dao.insert(s_dto);
		System.out.println(s_dto);
	}
	public static void update(HttpServletRequest request, HttpServletResponse response) {
		ChampionSynergeDto csDto = new ChampionSynergeDto();
		c_dao.update(request.getParameter("name1"),request.getParameter("name2"),request.getParameter("skill1"),
				request.getParameter("skill2"),Integer.parseInt(request.getParameter("price")),request.getParameter("synerge1"),
				request.getParameter("synerge2"),request.getParameter("synerge3"));
		csDto = new ChampionSynergeDto(request.getParameter("name2"),
				request.getParameter("skill2"),
				Integer.parseInt(request.getParameter("price")),
				new TFTInfoSynergeDto(request.getParameter("name2"),
						request.getParameter("synerge1"),
						request.getParameter("synerge2"),
						request.getParameter("synerge3")));
		request.setAttribute("dto", csDto);
	}
	public static ArrayList<ChampionSynergeDto> selectFilter(HttpServletRequest request, HttpServletResponse response,
			String filter) {
		DBConn.getInstance();
		String sql="";
		
		String judger = filter.substring(0,2);
		
		
		ArrayList<ChampionSynergeDto> dtos = new ArrayList<ChampionSynergeDto>();
		if(judger.equals("sy")) {
			sql = String.format(
					"select champion.*, synerge.synerge1, synerge.synerge2, synerge.synerge3 "
							+ "from champion, synerge where champion.name=synerge.name(+)" 
							+ "order by synerge.%s",
					filter);
			System.out.println(sql);
			
		}else {
		sql = String.format(
				"select champion.*, synerge.synerge1, synerge.synerge2, synerge.synerge3 "
						+ "from champion, synerge where champion.name=synerge.name(+)" + "order by champion.%s",
				filter);
		}
		ResultSet rs = DBConn.statementQuery(sql);
		if (rs != null) {

			try {
				while (rs.next()) {
					dtos.add(new ChampionSynergeDto(rs.getString("name"), rs.getString("skill"), rs.getInt("price"),
							new TFTInfoSynergeDto(rs.getString("name"), rs.getString("synerge1"),
									rs.getString("synerge2"), rs.getString("synerge3"))));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}

		return dtos;
	}
	
	
	
//	public static void selectAll(HttpServletRequest request, HttpServletResponse response) {
//		ArrayList<ChampionSynergeDto> dtos = new ArrayList<ChampionSynergeDto>();
//		ResultSet rs = DBConn.statementQuery(String.format(format, args))
//	}
}