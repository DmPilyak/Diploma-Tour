package com.pilyak.testmavenproject.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pilyak.testmavenproject.dao.UserDao;
import com.pilyak.testmavenproject.models.UserData;

public class DefaultUserDao implements UserDao {
	private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?;";
	private static final String LOGIN_USER = "SELECT * FROM users WHERE email = ?;";
	private static final String SELECT_ALL_USERS = "SELECT * FROM users;";
	private static final String INSERT_USER = "INSERT INTO users (first_name, last_name, role_id, email, password, birthday, gender)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?);";
	private static final String URL = "jdbc:mysql://localhost:3306/group1_db?useUnicode=true&serverTimezone=GMT%2B8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	private static DefaultUserDao instance;
	
	public DefaultUserDao() {
	}
	public static synchronized DefaultUserDao getInstance() {
		if(instance == null) {
			instance = new DefaultUserDao();
		}
		return instance;
	}
	
	
	@Override
	public UserData getUserByID(int id) {
		UserData user = null;
		
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					user = new UserData();
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					user.setId(rs.getInt("id"));
					//RoleDao roleDao = new DefaultRoleDao();
					//user.setRole(roleDao.getRoleById(rs.getInt("role_id")));
					user.setRole(rs.getInt("role_id"));
					user.setBirthday(rs.getString("birthday"));
					user.setGender(rs.getString("gender"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public UserData getUserByEmail(String email) {
		UserData user = null;
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(LOGIN_USER)) {
			ps.setString(1, email);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					user = new UserData();
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					user.setId(rs.getInt("id"));
					//RoleDao roleDao = new DefaultRoleDao();
					//user.setRole(roleDao.getRoleById(rs.getInt("role_id")));
					user.setRole(rs.getInt("role_id"));
					user.setBirthday(rs.getString("birthday"));
					user.setGender(rs.getString("gender"));
					user.setPassword(rs.getString("password"));

					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException  | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<UserData> getAllUsers() {
		UserData user = null;
		List<UserData> usersList = new ArrayList<>();
		try (Connection conn = getConnection();
				Statement ps = conn.createStatement()) {
			
			try (ResultSet rs = ps.executeQuery(SELECT_ALL_USERS);) {
				while (rs.next()) {
					user = new UserData();
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					user.setId(rs.getInt("id"));
					//RoleDao roleDao = new DefaultRoleDao();
					//user.setRole(roleDao.getRoleById(rs.getInt("role_id")));
					user.setRole(rs.getInt("role_id"));
					user.setBirthday(rs.getString("birthday"));
					user.setGender(rs.getString("gender"));
					usersList.add(user);
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return usersList;
		
	}
	
	
	public void addUser(UserData user) {
		try(Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(INSERT_USER);) {
				ps.setString(1, user.getFirstName());
				ps.setString(2, user.getLastName());
				//ps.setInt(3, user.getRole());
				ps.setInt(3, 1);
				ps.setString(4, user.getEmail());
				ps.setString(5, user.getPassword());
				//ps.setInt(6, user.getId());
				ps.setString(6, user.getBirthday());
				ps.setString(7, user.getGender());
				ps.executeUpdate();

					//System.out.println(user.getId() + " " + user.getFirstName() +" "+user.getLastName()+" "+user.getEmail());
			}catch (SQLException e) {
				e.printStackTrace();
			} 
			
		}

}
