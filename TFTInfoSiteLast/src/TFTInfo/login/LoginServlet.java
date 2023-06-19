package TFTInfo.login;

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
import TFTInfoDto.ChampionSynergeDto;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("*.login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String uri = request.getRequestURI();
		System.out.println("URI:" + uri);
		
		String conPath = request.getContextPath();
		System.out.println("conPath:" + conPath);

		String command = uri.substring(conPath.length());
		System.out.println("command:" + command);
		

		boolean admin = false;
		boolean checker = false;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		DBConn.getInstance();

		ResultSet rs = DBConn.statementQuery(String.format("select * from member where id ='%s' and pw='%s'", id, pw));
		if(command.equals("/Login/login.login")) {
			
			if (rs != null) {
				try {
					while (rs.next()) {
						String checkId = rs.getString("id");
						String checkPw = rs.getString("pw");
						if (id.equals(checkId) && pw.equals(checkPw)) {
							checker = true;
							ArrayList<ChampionSynergeDto> dtos = TFTInfoDao.selectAllJoinSynerge();
							request.setAttribute("dtos", dtos);
						}
						if (checker == true && checkId.equals("admin")) {
							admin = true;
						}
						System.out.println("id=" + id);
						System.out.println("pw=" + pw);

						System.out.println("checkId=" + checkId);
						System.out.println("checkPw=" + checkPw);

						System.out.println("checker=" + checker);
						System.out.println("admin=" + admin);

						if (checker == true && admin == true) {
							// 관리자 전송
							HttpSession session = request.getSession();
							session.setAttribute("id", id);
							session.setAttribute("pw", pw);
							session.setAttribute("authority", "admin");
							
							RequestDispatcher dispatcher = request.getRequestDispatcher("/Main_Select/SelectAll.TFT");
							dispatcher.forward(request, response);
						} else if (checker == true && admin == false) {
							// 유저 전송
							HttpSession session = request.getSession();
							session.setAttribute("id", id);
							session.setAttribute("pw", pw);
							session.setAttribute("authority", "user");
							RequestDispatcher dispatcher = request.getRequestDispatcher("/Main_Select/SelectAllUser.TFT");
							dispatcher.forward(request, response);
						}
					}
					out.println("<script>alert('로그인실패');location.href='/TFTInfoSite/Login/LoginPage.jsp';</script>");
					out.close(); 

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else if(command.equals("/Login/withdrawal.login")) {
			
			HttpSession session = request.getSession();
			String d_id = (String) session.getAttribute("id");
			String d_pw = (String) session.getAttribute("pw");
			System.out.println(d_pw);
			String d_pw2 = request.getParameter("d_pw");
			System.out.println(d_pw2);
			if(d_pw.equals(d_pw2)) {
			DBConn.statementUpdate(String.format("drop table %s_bookmarktable purge",d_id));
			rs = DBConn.statementQuery(String.format("delete member where pw = '%s' and id = '%s'", d_pw2,d_id));
			out.println("<script>alert('회원탈퇴되었습니다.');location.href='/TFTInfoSite/Login/LoginPage.jsp';</script>");
			
			}
			else {
				out.println("<script>alert('비밀번호가 일치하지 않습니다.');location.href='/TFTInfoSite/Login/Withdrawal.jsp';</script>");
			}
		}
		
		
		
		/*
		 * if (rs != null) { try { while (rs.next()) { String checkId =
		 * rs.getString("id"); String checkPw = rs.getString("pw"); if
		 * (id.equals(checkId) && pw.equals(checkPw)) { checker = true;
		 * ArrayList<ChampionSynergeDto> dtos = TFTInfoDao.selectAllJoinSynerge();
		 * request.setAttribute("dtos", dtos); } if (checker == true &&
		 * checkId.equals("admin")) { admin = true; } System.out.println("id=" + id);
		 * System.out.println("pw=" + pw);
		 * 
		 * System.out.println("checkId=" + checkId); System.out.println("checkPw=" +
		 * checkPw);
		 * 
		 * System.out.println("checker=" + checker); System.out.println("admin=" +
		 * admin);
		 * 
		 * if (checker == true && admin == true) { // 관리자 전송 HttpSession session =
		 * request.getSession(); session.setAttribute("id", id);
		 * session.setAttribute("authority", "admin");
		 * 
		 * RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("Main_Select/SelectAll.TFT");
		 * dispatcher.forward(request, response); } else if (checker == true && admin ==
		 * false) { // 유저 전송 HttpSession session = request.getSession();
		 * session.setAttribute("id", id); session.setAttribute("authority", "user");
		 * RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("Main_Select/SelectAllUser.TFT");
		 * dispatcher.forward(request, response); } } out.println(
		 * "<script>alert('로그인실패');location.href='Login/LoginPage.jsp';</script>");
		 * out.close();
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 */

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
