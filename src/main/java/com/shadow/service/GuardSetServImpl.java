package com.shadow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadow.bean.GuradSetBean;

import com.shadow.dao.GuardSetDao;

@Service
public class GuardSetServImpl implements GuardSetServ {

	@Autowired
	GuardSetDao dao;
	
	@Override
	public String setGuarsOnSiteServ(GuradSetBean bean ) {
		String result = "false";
		GuradSetBean beanOne = dao.save(bean);
		if(beanOne.getSetid() > 0) {
			result = "true";
		}
		return result;
	}
}
