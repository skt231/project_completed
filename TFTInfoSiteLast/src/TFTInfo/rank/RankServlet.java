package TFTInfo.rank;

import java.io.IOException;
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
import TFTInfoDto.TFTInfoCountDto;

/**
 * Servlet implementation class RankServlet
 */
@WebServlet("*.rank")
public class RankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RankServlet() {
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
				
		String viewPage = "rank.jsp";
		DBConn.getInstance();
		
		ResultSet rs = DBConn.statementQuery(String.format("select * from count order by count desc"));
		ArrayList<TFTInfoCountDto> dtos = new ArrayList<TFTInfoCountDto>();		
		if(rs!=null) {
			try {
				while(rs.next()) {
					dtos.add(new TFTInfoCountDto(rs.getString("name"),rs.getInt("count")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(command.equals("/Main_Select/selectUser.rank")) {
			viewPage = "rankUser.jsp";
		}
		request.setAttribute("dtos", dtos);		
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
