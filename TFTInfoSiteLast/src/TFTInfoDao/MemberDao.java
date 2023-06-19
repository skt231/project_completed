package TFTInfoDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import TFTInfo.util.DBConn;
import TFTInfoDto.MemberDto;

public class MemberDao {
//selectAll
	public static ArrayList<MemberDto> memberlist() {
		ArrayList<MemberDto> resultDtos = new ArrayList<MemberDto>();
		ResultSet rs = DBConn.statementQuery(String.format(
				"select * from member"));
		
		try {
			while(rs.next()) {
				resultDtos.add(new MemberDto(
						rs.getString("ID"),
						rs.getString("PW"))
					);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resultDtos;
	}
	public static MemberDto selectId(String id) {
		MemberDto resultDtos=new MemberDto();
		String str = String.format("select * from member where id='%s'", id);
		System.out.println(str);
		ResultSet rs=DBConn.statementQuery(str);
		System.out.println("test selectone");
		try {
			rs.next();
			resultDtos=new MemberDto(rs.getString("ID"),rs.getString("PW"));			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultDtos;
	}
	public static void delete(String ID) {
		DBConn.statementUpdate(String.format("delete member where ID='%s'", ID));
	}
	

}
