package com.dentalapp.utility;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dentalapp.dao.beans.User;

public class CustomerRowMapper implements RowMapper<Object>{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setEmailId(rs.getString("EMAIL_ID"));
		user.setPassword(rs.getString("PASSWORD"));
		return user;
	}

}
