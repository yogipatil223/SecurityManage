package com.shadow.service;

import java.util.List;

import com.shadow.bean.ClientReqBean;

public interface ClientReqServ {

	public String setClientRequest(ClientReqBean bean);
	public List<ClientReqBean> getClientRequests();
	public String updateStatusServ(int req_id);
	public List<ClientReqBean> getClientReqSeted();
	public String updateSetGuardStatus(int req_id);
	
}
