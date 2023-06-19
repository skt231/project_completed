package TFTInfoDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import TFTInfo.util.DBConn;
import TFTInfoDto.TFTInfoSynergeDto;

public class TFTInfoSynergeDao {
	public void insert(TFTInfoSynergeDto dto) {
		String sql = String.format("insert into synerge values('%s','%s','%s','%s')",
				dto.getName(),
				dto.getSynerge1(),
				dto.getSynerge2(),
				dto.getSynerge3());
		DBConn.statementUpdate(sql);
		System.out.println(sql);
	}
	public ArrayList<TFTInfoSynergeDto> selectAll(){
		ArrayList<TFTInfoSynergeDto> dtos = new ArrayList<TFTInfoSynergeDto>();
		
		ResultSet rs = DBConn.statementQuery("select * from synerge");
		
		try {
			while(rs.next()) {
				dtos.add(new TFTInfoSynergeDto(rs.getString("name"),
						rs.getString("synerge1"),rs.getString("synerge2") ,rs.getString("synerge3")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return dtos;		
	}
	
	public TFTInfoSynergeDto selectOne(String name,String synerge1) {
		TFTInfoSynergeDto dto = new TFTInfoSynergeDto();
		
		ResultSet rs = DBConn.statementQuery(String.format("select * from synerge where name = '%s' and synerge1 = '%s'"
				,name,synerge1));
		try {
			rs.next();
			dto = new TFTInfoSynergeDto(rs.getString("name"),
					rs.getString("synerge1"),
					rs.getString("synerge2"),
					rs.getString("synerge3")); 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	public void update(String name,String synerge1) {
		DBConn.statementUpdate(String.format("update set synerge1 = '%s' where name = '%s'",synerge1,name));
	}
	public void delete(String name) {
		DBConn.statementUpdate(String.format("delete syerge where name = '%s'",name));
	}
	
}
