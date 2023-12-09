package com.booking.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class StringListTypeHandler extends BaseTypeHandler<List<String>> {

	public void setNonNullParameter(PreparedStatement ps, int i, List<String> list, JdbcType jdbcType)
	        throws SQLException {
	    if (list != null) {
	        String value = list.stream().collect(Collectors.joining(","));
	        ps.setString(i, value);
	    } else {
	        ps.setString(i, null);
	    }
	}

	@Override
	public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return Arrays.asList(rs.getString(columnName).split(","));
	}

	@Override
	public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return Arrays.asList(rs.getString(columnIndex).split(","));
	}

	@Override
	public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return Arrays.asList(cs.getString(columnIndex).split(","));
	}

}
