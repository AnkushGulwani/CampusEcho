package com.user.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.user.dao.UserDao;
import com.user.Pojo.UserInfo;

public class UserDB implements UserDao {
    Connection con = null;

    public UserDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notes", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkuserCredentials(UserInfo u) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            ps.setString(1, u.getEmail());
            ps.setString(2, u.getPassword());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addnewUser(UserInfo u) {
        try {
            // Check if email already exists
            PreparedStatement checkStmt = con.prepareStatement("SELECT * FROM users WHERE email = ?");
            checkStmt.setString(1, u.getEmail());
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                return false;
            }

            // Insert new user
            PreparedStatement insertStmt = con.prepareStatement("INSERT INTO users (name, email, password) VALUES (?, ?, ?)");
            insertStmt.setString(1, u.getName());
            insertStmt.setString(2, u.getEmail());
            insertStmt.setString(3, u.getPassword());

            int rows = insertStmt.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public String getUserNameByEmail(String email) {
    	String name = null;
    	try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notes", "root", "root")) {
    		String sql = "SELECT name FROM users WHERE email = ?";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1, email);
    		ResultSet rs = ps.executeQuery();
    		if (rs.next()) {
    			name = rs.getString("name");
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return name;
    }
}