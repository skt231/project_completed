package TFTInfoDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TFTInfo.util.DBConn;
import TFTInfoDto.jjimDto;
import TFTInfoDto.MemberDto;


public class jjimDao {

   
   
   // insert작업
	// insert작업
	   public static int insert(jjimDto dto, HttpSession session) {
		   
	      String sql = String.format("insert into %s_BookmarkTable values('%s','%s','%d','%s','%s','%s')",session.getAttribute("id"), dto.getName(), dto.getSkill(),
	            dto.getPrice(), dto.getSynerge1(), dto.getSynerge2(), dto.getSynerge3());	  
	      int i = DBConn.statementUpdate(sql);
	      return i;
	   }
	   
	


   // delete작업
    public static int delete(String name,HttpSession session) {       
       return DBConn.statementUpdate(String.format("delete %s_bookmarktable where NAME='%s'",session.getAttribute("id"), name));
    }
    
    //select작업
    public static ArrayList<jjimDto> jjimSelect(String id) {
    	ArrayList<jjimDto> dtos=new ArrayList<jjimDto>();
    	ResultSet rs=DBConn.statementQuery(String.format("select * from %s_Bookmarktable",id));
    	try {
			dtos.add(new jjimDto(rs.getString("NAME"),rs.getString("skill"),rs.getInt("cost"),rs.getString("Synerge1"),rs.getString("Synerge2"),rs.getString("Synerge3")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return dtos;
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	////    	String id = session.get
//    	System.out.println(id);
//    	ArrayList<jjimDto> resultDtos = new ArrayList<jjimDto>();
// 		ResultSet rs = DBConn.statementQuery(String.format(
// 				"select * from %s_bookmarktable",id));
// 		
// 		try {
// 			while(rs.next()) {
// 				resultDtos.add(new jjimDto(
// 						rs.getString("name"),
// 						rs.getString("skill"),
// 						rs.getInt("price"),
// 						rs.getString("synerge1"),
// 						rs.getString("synerge2"),
// 						rs.getString("synerge3")
// 						)
// 					);		
// 			}
// 		} catch (SQLException e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}
// 		
// 		
// 		return resultDtos;
// 	
    }

   
   public static jjimDto selectName(String name) {
      jjimDto resultDtos=new jjimDto();
      String str = String.format("select * from jjim where name='%s'", name);
      System.out.println(str);
      ResultSet rs=DBConn.statementQuery(str);
      System.out.println("test jjimone");
      try {
         rs.next();
         resultDtos=new jjimDto(rs.getString("name"), rs.getString("skill"), rs.getInt("price"), rs.getString("synerge1"), rs.getString("synerge2"), rs.getString("synerge3"));         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return resultDtos;
   }

}