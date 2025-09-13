package com.user.dao;

import com.user.Pojo.Confession;
import java.util.List;

public interface ConfessionDao {

	boolean addConfession(Confession c);

	List<Confession> getApprovedConfessions();

	boolean updateLikes(int id);

	boolean updateDislikes(int id);

	List<Confession> getPendingConfessions();

	boolean approveConfession(int id);

	boolean rejectConfession(int id);

	String getUserEmail(String email);

	List<Confession> getUserConfessions(String email);

	List<Confession> getUserFeedback(String email, String type);

	boolean updatePassword(String email, String oldPassword, String newPassword);
}