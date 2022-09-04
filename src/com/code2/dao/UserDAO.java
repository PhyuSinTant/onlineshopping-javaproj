package com.code2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.code2.modal.User;

public class UserDAO {

	private DataSource dataSource;

	public UserDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public User getUserByUsernameAndPassword(String username,String password) throws SQLException {
		Connection conn = dataSource.getConnection();
		String sql = "select * from users where username=? and password=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet result = stmt.executeQuery();
		User user = null;
		if(result.next()) {
			int id = result.getInt("id");
			String uName = result.getString("username");
			String pass = result.getString("password");
			String role = result.getString("role");
			user = new User(id,uName,pass,role);
					
		}
		return user;
	}
}
