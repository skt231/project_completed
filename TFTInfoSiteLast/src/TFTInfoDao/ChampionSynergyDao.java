package TFTInfoDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import TFTInfo.util.DBConn;
import TFTInfoDto.ChampionSynergeDto;
import TFTInfoDto.TFTInfoSynergeDto;

public class ChampionSynergyDao {

	public ArrayList<ChampionSynergeDto> selectAllJoinSynerge() {
		ArrayList<ChampionSynergeDto> resultDtos = new ArrayList<ChampionSynergeDto>();
		ResultSet rs = DBConn.statementQuery(String.format(
				"select champion.*,synerge.synerge1, synerge.synerge2,synerge.synerge3 from champion, synerge where champion.name=synerge.name(+)"
				+ "order by champion.name"));
		
		try {
			while(rs.next()) {
				resultDtos.add(new ChampionSynergeDto(
						rs.getString("name"),
						rs.getString("skill"),
						rs.getInt("price"),
						new TFTInfoSynergeDto(rs.getString("name"),rs.getString("synerge1"),
								rs.getString("synerge2"),rs.getString("synerge3"))
						)
					);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resultDtos;
	}
	public ArrayList<ChampionSynergeDto> serch(String menu,String keyword){
		ArrayList<ChampionSynergeDto> resultDtos = new ArrayList<ChampionSynergeDto>();
	      
	      //키워드 메뉴로 문장 완성
	      String sql="";
	      if(menu.equals("synerge")) {
	         sql=String.format("select champion.*,synerge.synerge1, synerge.synerge2,synerge.synerge3 "
	               + "from champion, synerge "
	               + "where champion.name=synerge.name(+) "
	               + "and (synerge.synerge1 like '%%%s%%' or "
	               + "synerge.synerge2 like '%%%s%%' or "
	               + "synerge.synerge3 like '%%%s%%')",keyword,keyword,keyword);	         
	      }else if(menu.equals("price")) {
	         sql=String.format("select champion.*,synerge.synerge1, synerge.synerge2,synerge.synerge3 "
	               + "from champion, synerge"
	               + " where champion.name=synerge.name(+) "
	               + "and champion.price = %s",keyword);
	      }else {
	         sql=String.format("select champion.*,synerge.synerge1, synerge.synerge2,synerge.synerge3 "
	               + "from champion, synerge"
	               + " where champion.name=synerge.name(+) "
	               + "and champion.%s= '%s'",menu,keyword);
	      }      
	      System.out.println(sql);
	      //문장 실행
	      ResultSet rs = DBConn.statementQuery(sql);
	      
	      //배열에 저장
	      try {
	         while(rs.next()) {
	            resultDtos.add(new ChampionSynergeDto(
	                  rs.getString("name"),
	                  rs.getString("skill"),
	                  rs.getInt("price"),
	                  new TFTInfoSynergeDto(rs.getString("name"),rs.getString("synerge1"),
	                        rs.getString("synerge2"),rs.getString("synerge3"))
	                  )
	               );      
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }	      
	      return resultDtos;
	}
	
}
