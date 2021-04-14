package com.shadow.service;

import java.util.List;

import com.shadow.bean.UserBean;

public interface UserServ {

	public UserBean getUserInfoServ(String mobilenum , String password);
	public boolean saveuser(UserBean bean);
	public List<UserBean> getUsersServ();
}
