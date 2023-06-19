package TFTInfo.changePW;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TFTInfo.util.DBConn;

/**
 * Servlet implementation class changePWServlet
 */
@WebServlet("*.changePW")
public class changePWServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePWServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String originalPw = request.getParameter("pw1");
		String changePw = request.getParameter("pw2");
		String checkPw = request.getParameter("pw3");
//		System.out.println(changePw);
//		System.out.println(checkPw);
		int result =-1;
		if(changePw.equals(checkPw)) {
			DBConn.getInstance();
			String sql = String.format("update member set pw='%s' where pw='%s'", changePw, originalPw);
		 result = DBConn.statementUpdate(sql);		 
		 if(result>=1) {
			 out.println("<script>alert('changed successfully.');location.href='/TFTInfoSite/Login/LoginPage.jsp';</script>");
		 }else {
			 out.println("<script>alert('changing failed.');location.href='myPage/changePW.jsp';</script>");
		 }
		 
		}
		out.println("<script>alert('not matched');location.href='myPage/changePW.jsp';</script>");
				
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
