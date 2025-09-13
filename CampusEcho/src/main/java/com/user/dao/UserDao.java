package com.user.dao;

import com.user.Pojo.UserInfo;

public interface UserDao {
	boolean checkuserCredentials(UserInfo u);
	boolean addnewUser(UserInfo u);
	public String getUserNameByEmail(String email);
}
