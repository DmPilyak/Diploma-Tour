package com.pilyak.testmavenproject.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pilyak.testmavenproject.dao.RoleDao;
import com.pilyak.testmavenproject.dao.UserDao;
import com.pilyak.testmavenproject.models.Role;
import com.pilyak.testmavenproject.models.UserData;

public class DefaultRoleDao implements RoleDao {
	private static final String SELECT_ROLE_BY_ID = "SELECT * FROM roles WHERE id_role = ?"; 
	private static final String URL = "jdbc:mysql://localhost:3306/group1_db?useUnicode=true&serverTimezone=GMT%2B8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	@Override
	public Role getRoleById(int id) {
		Role role = null;
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_ROLE_BY_ID)) {
			
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					//role.setRole(rs.getInt("id_role"));
					
					role.setRole(id);
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException  | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
