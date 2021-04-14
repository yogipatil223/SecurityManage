package com.shadow.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.shadow.bean.ClientReqBean;
import com.shadow.dao.ClientRequestDao;

@Service
public class ClientReqServImpl implements ClientReqServ {

	@Autowired
	ClientRequestDao dao;
	
	@Override
	@Transactional
	public String setClientRequest(ClientReqBean bean) {
		String result = "false";
		try {
			ClientReqBean beanOne = dao.save(bean);
			if(beanOne.getReq_id()> 0) {
				result = "true";
			}
		}catch(Exception e) {
			System.out.println("Exception in ClientReqServImpl in setClientRequest()="+e);
		}
		return result;
	}
	
	@Override
	@Transactional
	public List<ClientReqBean> getClientRequests(){
		List<ClientReqBean> result = dao.getAllClientReq(); 
		return result;
	}
	
	@Override
	@Transactional
	public List<ClientReqBean> getClientReqSeted(){
		List<ClientReqBean> result = dao.getAllClientReqSet();
		return result;
	}
	
	
	@Override
	@Transactional
	public String updateStatusServ(int req_id) {
		String result = "false";
		try {
			System.out.println(req_id);
			dao.updateStatus(req_id);
			result = "true";
			
		}catch(Exception e) {
			result = "false";
		}
		return result;
	}
	
	@Override
	@Transactional
	public String updateSetGuardStatus(int req_id) {
		String result = "false";
		try {
			System.out.println(req_id);
			dao.updateSetGuardStatus(req_id);
			result = "true";
		}catch(Exception e) {
			result = "false";
		}
		return result;
	}
	
}
