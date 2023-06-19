package TFTInfo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TFTInfo.service.TFTInfoService;
import TFTInfo.util.DBConn;
import TFTInfoDao.ChampionSynergyDao;
import TFTInfoDao.TFTInfoDao;
import TFTInfoDto.ChampionSynergeDto;

@WebServlet("*.Servlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public searchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String uri = request.getRequestURI();
		System.out.println("URI:" + uri);
		// 원하는 수소에 대한 처리 방법
		String conPath = request.getContextPath();
		System.out.println("conPath:" + conPath);

		String command = uri.substring(conPath.length());
		System.out.println("command:" + command);
		
		String menu = request.getParameter("menu");
		String keyword = request.getParameter("keyword");
		String viewPage = "SelectAll.jsp";
		
		if(command.equals("/Main_Select/searchUser.Servlet")) {
			viewPage = "SelectAllUser.jsp";
		}
		
		System.out.println(menu);
		System.out.println(keyword);
		
		TFTInfoService.serch(request, response);
		request.setAttribute("dtos", request.getAttribute("dtos"));
		
		
//		DBConn.getInstance();
//		
//		if (menu.equals("price")) {			
//			viewPage = "SelectAll.jsp";	
//			
//		} else {
//		ResultSet rs = DBConn.statementQuery(String.format("select * from champion where %s = '%s'", menu, keyword));
//		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
