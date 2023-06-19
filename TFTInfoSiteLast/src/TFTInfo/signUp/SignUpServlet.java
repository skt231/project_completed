package TFTInfo.signUp;

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

import TFTInfo.util.DBConn;

/**
 * Servlet implementation class SignUpServlet
 */

@WebServlet("*.signUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
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
		boolean signup = true;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String c_pw = request.getParameter("c_pw");
		PrintWriter out = response.getWriter();
		ArrayList<String> c_id = new ArrayList<String>();

		ResultSet rs = DBConn.statementQuery(String.format("select id from member"));
		try {
			while (rs.next()) {
				c_id.add(rs.getString("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < c_id.size(); i++) {
			if (id.equals(c_id.get(i))) {
				signup = false;
				out.println("<script>alert('이미 있는 아이디입니다.');" 
				+ "location.href='Login/signUp.jsp';</script>");
				out.close();
			}
		}
//		if (signup == true) {
//			if (pw.equals(c_pw)) {
//				String sql = String.format("create table %s_BookmarkTable" 
//			+ "(NAME NVARCHAR2(10),"
//			+ " SKILL NVARCHAR2(15),"
//			+ " PRICE NUMBER(4),"
//			+ " SYNERGE1 NVARCHAR2(15),"
//			+ " SYNERGE2 NVARCHAR2(15),"
//			+ "SYNERGE3 NVARCHAR2(15))",id);
//				
//				DBConn.statementUpdate(sql);
//				System.out.println("table생성 완료");
				DBConn.statementUpdate(String.format("insert into member values('%s','%s')", id, pw));				
				RequestDispatcher dispatcher = request.getRequestDispatcher("Login/LoginPage.jsp");
				dispatcher.forward(request, response);
//			} else {
//				out.println("<script>alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');"
//						+"location.href='Login/signUp.jsp';</script>");
//				out.close();
//			}
//		}

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
