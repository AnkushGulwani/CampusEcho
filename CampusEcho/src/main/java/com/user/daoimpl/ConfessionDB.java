package com.user.daoimpl;

import com.user.dao.ConfessionDao;
import com.user.Pojo.Confession;
import java.sql.*;
import java.util.*;

public class ConfessionDB implements ConfessionDao {
	Connection con;

	public ConfessionDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notes", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean addConfession(Confession c) {
		try {
			PreparedStatement ps = con.prepareStatement(
				"INSERT INTO confessions (message, tag, posted_by, isApproved) VALUES (?, ?, ?, false)"
			);
			ps.setString(1, c.getMessage());
			ps.setString(2, c.getTag());
			ps.setString(3, c.getPostedBy()); // NEW
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Confession> getApprovedConfessions() {
		List<Confession> list = new ArrayList<>();
		String query = "SELECT * FROM confessions WHERE isApproved=1 ORDER BY timestamp DESC";

		try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Confession c = new Confession();
				c.setId(rs.getInt("id"));
				c.setMessage(rs.getString("message"));
				c.setPostedBy(rs.getString("posted_by")); // NEW
				c.setTag(rs.getString("tag"));
				c.setTimestamp(rs.getTimestamp("timestamp").toString());
				c.setLikes(rs.getInt("likes"));
				c.setDislikes(rs.getInt("dislikes"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean updateLikes(int id) {
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE confessions SET likes = likes + 1 WHERE id = ?");
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateDislikes(int id) {
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE confessions SET dislikes = dislikes + 1 WHERE id = ?");
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Confession> getPendingConfessions() {
		List<Confession> list = new ArrayList<>();
		String sql = "SELECT * FROM confessions WHERE isApproved = 0 ORDER BY timestamp DESC";
		try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Confession c = new Confession();
				c.setId(rs.getInt("id"));
				c.setMessage(rs.getString("message"));
				c.setPostedBy(rs.getString("posted_by"));
				c.setTag(rs.getString("tag"));
				c.setTimestamp(rs.getTimestamp("timestamp").toString());
				c.setLikes(rs.getInt("likes"));
				c.setDislikes(rs.getInt("dislikes"));
				c.setApproved(false);
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean approveConfession(int id) {
		String sql = "UPDATE confessions SET isApproved = 1 WHERE id = ?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean rejectConfession(int id) {
		String sql = "DELETE FROM confessions WHERE id = ?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String getUserEmail(String email) {
		String sql = "SELECT email FROM users WHERE email = ?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getString("email");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Confession> getUserConfessions(String email) {
		List<Confession> list = new ArrayList<>();
		String sql = "SELECT id, text, timestamp, likes, dislikes FROM confessions WHERE posted_by = ?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Confession c = new Confession();
				c.setId(rs.getInt("id"));
				c.setMessage(rs.getString("message"));
				c.setTimestamp(rs.getTimestamp("timestamp").toString());
				c.setLikes(rs.getInt("likes"));
				c.setDislikes(rs.getInt("dislikes"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<Confession> getUserFeedback(String email, String type) {
		List<Confession> list = new ArrayList<>();
        String sql = "SELECT c.id, c.text, c.timestamp FROM feedback f " +
                     "JOIN confessions c ON f.confession_id = c.id " +
                     "WHERE f.email = ? AND f.type = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, type);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Confession c = new Confession();
                c.setId(rs.getInt("id"));
                c.setMessage(rs.getString("message"));
                c.setTimestamp(rs.getTimestamp("timestamp").toString());
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

	}

	@Override
	public boolean updatePassword(String email, String oldPassword, String newPassword) {
		 String checkSql = "SELECT password FROM users WHERE email = ?";
	        String updateSql = "UPDATE users SET password = ? WHERE email = ?";
	        try (PreparedStatement checkPs = con.prepareStatement(checkSql)) {
	            checkPs.setString(1, email);
	            ResultSet rs = checkPs.executeQuery();
	            if (rs.next() && rs.getString("password").equals(oldPassword)) {
	                try (PreparedStatement updatePs = con.prepareStatement(updateSql)) {
	                    updatePs.setString(1, newPassword);
	                    updatePs.setString(2, email);
	                    updatePs.executeUpdate();
	                    return true;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;

	}

}
