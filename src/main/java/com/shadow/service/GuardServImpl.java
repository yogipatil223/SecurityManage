
package com.shadow.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadow.bean.GuardBean;
import com.shadow.dao.GuardDao;


@Service
public class GuardServImpl implements GuardServ {

	@Autowired
	GuardDao dao;
	
	@Override
	@Transactional
	public String setGuard(GuardBean bean) {
		String result = "false";
		try {			
			GuardBean beanOne  =dao.save(bean);	
			
			if(beanOne.getGid() > 0 ) {
				result = "true";
			}
			
		}catch(Exception e) {
			System.out.println("Exception in GuardServImpl in setGuard()="+e);
		}
		return result;		
	}
	
	@Override
	@Transactional
	public List<GuardBean> getGuardInfo() {	
		 List<GuardBean> result = dao.findAll();
		 return result;
	}
	
	@Override
	@Transactional
	public String deleteGuard(int gid) {
		String result = "false";
		try {
			dao.deleteById(gid);
			result = "true";
		}catch(Exception e) {
			result = "false";
		}
		return result;
		
	}
	
}
