package TFTInfo.list;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TFTInfo.util.DBConn;
import TFTInfoDao.TFTInfoDao;
import TFTInfoDao.MemberDao;
import TFTInfoDto.ChampionSynergeDto;
import TFTInfoDto.MemberDto;
import TFTInfo.service.MemberService;

/**
 * Servlet implementation class listservlet
 */
@WebServlet("*.member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uri = request.getRequestURI();
		System.out.println("list URI:" + uri);
		
		String conPath = request.getContextPath();
		System.out.println("list conPath:" + conPath);

		String command = uri.substring(conPath.length());
		System.out.println("list command:" + command);
		
		String viewPage = "SelectAll.jsp";
		
		DBConn.getInstance();
		
		if(command.equals("/Main_Select/list.member")||command.equals("/Main_Select/MemberSelect.member")) {
		ArrayList<MemberDto> dtos = MemberDao.memberlist();
		request.setAttribute("dtos", dtos);		
//		response.sendRedirect("/TFTInfoSite/Main_Select/list.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Main_Select/MemberSelect.jsp");
		dispatcher.forward(request, response);
		}
		else if(command.equals("/Main_Select/MemberSelectOne.member")) {
			viewPage="MemberSelectOne.jsp";
			MemberDto dtos = MemberService.MemberSelectOne(request,response);
			MemberService.MemberSelectOne(request,response);
//			System.out.println("/Member/MemberSelectOne.member");
			request.setAttribute("dto", dtos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Main_Select/MemberSelectOne.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/Main_Select/Memberdelete.member")) {
			viewPage="MemberSelect.member";
			MemberService.delete(request,response);
			System.out.println("/Main_Select/Memberdelete.member");
			ArrayList<MemberDto> dtos = MemberDao.memberlist();
			request.setAttribute("dtos", dtos);	
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Main_Select/MemberSelect.jsp");
			dispatcher.forward(request, response);
			
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
