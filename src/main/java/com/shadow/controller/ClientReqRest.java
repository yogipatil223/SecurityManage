package com.shadow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shadow.bean.ClientReqBean;
import com.shadow.service.ClientReqServ;

@RestController
@RequestMapping("/ClientReqRest")
public class ClientReqRest {

	@Autowired
	ClientReqServ service;
	
	@PostMapping("/setClientReq")
	public String setClientReq(@RequestBody ClientReqBean bean) {
		
		String result = service.setClientRequest(bean);
		return result;
	}
	
	@GetMapping("/getClientRequest")
    public List<ClientReqBean> getClientRequest(){
		
		List<ClientReqBean> result = service.getClientRequests();
		System.out.println("Now changes in another method");
		return result;
	}
	
	@GetMapping("/getClientRequestSet")
    public List<ClientReqBean> getClientRequestSet(){
		
		List<ClientReqBean> result = service.getClientReqSeted();
		
		return result;
	}
	
	
	@GetMapping("/updateStatus")
    public String updateStatus(@RequestParam("req_id") int req_id ){		
		String result = service.updateStatusServ(req_id);
		
		return result;
	}
}
