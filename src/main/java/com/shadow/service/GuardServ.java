package com.shadow.service;

import java.util.List;

import com.shadow.bean.GuardBean;



public interface GuardServ {

	public String setGuard(GuardBean bean);
	public List<GuardBean> getGuardInfo();
	public String deleteGuard(int gid);
}
