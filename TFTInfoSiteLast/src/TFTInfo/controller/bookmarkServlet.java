package TFTInfo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TFTInfo.service.TFTInfoService;
import TFTInfo.util.DBConn;
import TFTInfoDao.TFTInfoDao;
import TFTInfoDao.jjimDao;
import TFTInfoDto.ChampionSynergeDto;
import TFTInfoDto.jjimDto;

/**
 * Servlet implementation class bookmarkServlet
 */
@WebServlet("*.bookmarkServlet")
public class bookmarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public bookmarkServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		


		String uri = request.getRequestURI();
		System.out.println("URI:" + uri);

		String conPath = request.getContextPath();
		System.out.println("conPath:" + conPath);

		String command = uri.substring(conPath.length());
		System.out.println("command:" + command);
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");		
		
		
		// insert
		System.out.println(id);
		if (command.equals("/bookmarkServlet.bookmarkServlet")) {
			String name = request.getParameter("name");
			String skill = request.getParameter("skill");
			int price = Integer.parseInt(request.getParameter("price"));
			String synerge1 = request.getParameter("synerge1");
			String synerge2 = request.getParameter("synerge2");
			String synerge3 = request.getParameter("synerge3");
			jjimDto dto = new jjimDto(name, skill, price, synerge1, synerge2, synerge3);
			int i = jjimDao.insert(dto, session);			
			if (i >= 1) {
				out.println("<script>alert('저장 완료');location.href='/TFTInfoSite/"
						+ "Main_Select/SelectOneUser.TFT?name=" + name + "&skill=" + skill + "'</script>");			
			} else {
				out.println("<script>alert('저장 실패');location.href='/TFTInfoSite/Main_Select/"
						+ "SelectOneUser.TFT?name=" + name + "&skill=" + skill + "'</script>");
			}
		}else if(command.equals("/bookmarkselect.bookmarkServlet")) {
			ResultSet rs = DBConn.statementQuery(String.format("select * from %s_bookmarktable",id));		 
			ArrayList<jjimDto> dtos = new ArrayList<jjimDto>();			
			if(rs!=null) {
				try {
					while(rs.next()) {
						 dtos.add(new jjimDto(rs.getString("name"),
								rs.getString("skill"),
								rs.getInt("price"),
								rs.getString("synerge1"),
								rs.getString("synerge2"),
								rs.getString("synerge3")));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
//			ArrayList<jjimDto> resultDtos = jjimDao.jjimSelect(id);
			request.setAttribute("dtos", dtos);
			String viewPage = "Main_Select/bookmark.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}else if(command.equals("/delete.bookmarkServlet")) {
			String name = request.getParameter("name");
			String skill = request.getParameter("skill");
			//delete
			int k = jjimDao.delete(name,session);
			if (k >= 1) {
				out.println("<script>alert('삭제 완료');location.href='/TFTInfoSite/"
						+ "Main_Select/SelectOneUser.TFT?name=" + name + "&skill=" + skill + "'</script>");			
			} else {
				out.println("<script>alert('삭제 실패');location.href='/TFTInfoSite/Main_Select/"
						+ "SelectOneUser.TFT?name=" + name + "&skill=" + skill + "'</script>");
			}
		}
//		
//		//Select
//		ArrayList<jjimDto> resultDtos = jjimDao.jjimSelect(id);
//		request.setAttribute("dtos", resultDtos);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
