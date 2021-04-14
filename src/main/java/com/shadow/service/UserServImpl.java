package com.shadow.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadow.bean.UserBean;
import com.shadow.dao.UserDao;

@Service
public class UserServImpl implements UserServ {

	@Autowired
	UserDao dao;
	
	@Override
	@Transactional
	public UserBean getUserInfoServ(String mobilenum , String password) {		
			return	dao.getUserInfo(mobilenum, password);
	}
	
	@Override
	@Transactional
	public boolean saveuser(UserBean bean) {
		 
		boolean result = false;
		 UserBean resultval = dao.save(bean);
		 if(resultval.getUsrid() > 0) {
			 result = true;
		 }
		 return result;
	}
	
	@Override
	@Transactional
	public List<UserBean> getUsersServ(){
		return dao.findAll();
	}
	
}
