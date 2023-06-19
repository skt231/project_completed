package TFTInfo.controller;

import java.io.IOException; 
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TFTInfo.service.TFTInfoService;
import TFTInfoDao.TFTInfoDao;
import TFTInfoDto.ChampionSynergeDto;

/**
 * Servlet implementation class TFTInfoController
 */
@WebServlet("*.TFT")
public class TFTInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TFTInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uri = request.getRequestURI();
		System.out.println("URI:" + uri);
		
		String conPath = request.getContextPath();
		System.out.println("conPath:" + conPath);

		String command = uri.substring(conPath.length());
		System.out.println("command:" + command);
		
		String viewPage = "SelectAll.jsp";
		
		if(command.equals("/Main_Select/SelectOne.TFT")) {
			viewPage = "SelectOne.jsp";	
			TFTInfoService.selectOne(request, response);
		}else if(command.equals("/Main_Select/SelectOneUser.TFT")) {
			viewPage = "SelectOneUser.jsp";	
			TFTInfoService.selectOne(request, response);
		}else if(command.equals("/Main_Select/SelectAll.TFT")) {
			ArrayList<ChampionSynergeDto> dtos = TFTInfoDao.selectAllJoinSynerge();
			request.setAttribute("dtos", dtos);
		}else if(command.equals("/Main_Select/SelectAllUser.TFT")) {
			viewPage = "SelectAllUser.jsp";
			ArrayList<ChampionSynergeDto> dtos = TFTInfoDao.selectAllJoinSynerge();
			request.setAttribute("dtos", dtos);
		}else if(command.equals("/Main_Select/delete.TFT")) {
			String name = request.getParameter("name");
			System.out.println(name);
			TFTInfoDao.delete(name);
			ArrayList<ChampionSynergeDto> dtos = TFTInfoDao.selectAllJoinSynerge();
			request.setAttribute("dtos", dtos);
//			viewPage = "/TFTInfoSite/Main_Select/SelectAll.jsp";			
		}else if(command.equals("/Main_Select/Insert.TFT")) {
			viewPage = "insert.jsp";
		}else if(command.equals("/Main_Select/InsertDB.TFT")) {
			TFTInfoService.insert(request, response);			
			ArrayList<ChampionSynergeDto> dtos = TFTInfoDao.selectAllJoinSynerge();
			request.setAttribute("dtos", dtos);
		}else if(command.equals("/Main_Select/update.TFT")) {
			viewPage = "/Main_Select/update.jsp";
			TFTInfoService.selectOne(request, response);
			request.setAttribute("dto", request.getAttribute("dto"));
		}else if(command.equals("/Main_Select/updateDB.TFT")) {
			TFTInfoService.update(request, response);
			viewPage = "/Main_Select/SelectAll.TFT";
		}else if(command.equals("/Main_Select/SelectFilterName.TFT")) {
			String filter = request.getParameter("filter");
			ArrayList<ChampionSynergeDto> dtos = TFTInfoService.selectFilter(request, response, filter);
			request.setAttribute("dtos", dtos);
			viewPage = "/Main_Select/SelectAll.jsp";
		}else if(command.equals("/Main_Select/SelectFilterNameUser.TFT")) {
			String filter = request.getParameter("filter");
			ArrayList<ChampionSynergeDto> dtos = TFTInfoService.selectFilter(request, response, filter);
			request.setAttribute("dtos", dtos);
			viewPage = "/Main_Select/SelectAllUser.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
