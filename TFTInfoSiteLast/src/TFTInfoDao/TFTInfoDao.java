package TFTInfoDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import TFTInfo.util.DBConn;
import TFTInfoDto.ChampionSynergeDto;
import TFTInfoDto.TFTInfoChampionDto;
import TFTInfoDto.TFTInfoSynergeDto;

public class TFTInfoDao {

	// insert작업
	public void insert(TFTInfoChampionDto dto) {
		String sql = String.format("insert into champion values('%s','%s','%d')", dto.getName(), dto.getSkill(),
				dto.getPrice());
		DBConn.statementUpdate(sql);
	}

	// select All작업
	public ArrayList<TFTInfoChampionDto> selectAll() {
		ArrayList<TFTInfoChampionDto> resultDtos = new ArrayList<TFTInfoChampionDto>();

		ResultSet rs = DBConn.statementQuery(String.format("select * from champion"));
		try {
			while (rs.next()) {
				resultDtos.add(new TFTInfoChampionDto(rs.getString("name"), rs.getString("skill"), rs.getInt("price")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultDtos;

	}
	

	// update작업
	public void update(String name1,String name2, String skill1,String skill2,
			int price, String synerge1, String synerge2, String synerge3) {
		DBConn.statementUpdate(String.format("update champion set name = '%s', skill = '%s'"
				+ ", price = %d where name='%s' and skill='%s'",name2,skill2,price,name1,skill1));
		DBConn.statementUpdate(String.format("update synerge set name = '%s', synerge1 = '%s',"
				+ "synerge2 = '%s', synerge3 = '%s' where name = '%s'",
				name2,synerge1,synerge2,synerge3,name1));
	}

	// delete작업
	public static void delete(String name) {
		DBConn.statementUpdate(String.format("delete champion where name = '%s'", name));
		DBConn.statementUpdate(String.format("delete Synerge where name='%s'", name));
	}

	public static ArrayList<ChampionSynergeDto> selectAllJoinSynerge() {
		ArrayList<ChampionSynergeDto> resultDtos = new ArrayList<ChampionSynergeDto>();
		ResultSet rs = DBConn.statementQuery(String.format(
				"select champion.*,synerge.synerge1, synerge.synerge2,synerge.synerge3 from champion,"
				+ " synerge where champion.name=synerge.name(+)"));

		try {
			while (rs.next()) {
				resultDtos.add(new ChampionSynergeDto(rs.getString("name"), rs.getString("skill"), rs.getInt("price"),
						new TFTInfoSynergeDto(rs.getString("name"), rs.getString("synerge1"), rs.getString("synerge2"),
								rs.getString("synerge3"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultDtos;
	}
}
