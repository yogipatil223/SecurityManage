package com.shadow.controller;

import java.lang.management.GarbageCollectorMXBean;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shadow.bean.GuradSetBean;
import com.shadow.service.ClientReqServ;
import com.shadow.service.GuardSetServ;

@RestController
@RequestMapping("/GuardSetRest")
public class GuardSetRest {

	@Autowired
	GuardSetServ serv;
	
	@Autowired
	ClientReqServ reqServ;
	
	@PostMapping("/setGuards")
	public String setGuards(@RequestBody List<GuradSetBean> result) {
		String res = "false";
		for(int i = 0; i< result.size(); i++) {
			res = serv.setGuarsOnSiteServ(result.get(i));
			if("false".equalsIgnoreCase(res)) {
				break;
			}
		}
	  if("true".equalsIgnoreCase(res)) {
		  reqServ.updateSetGuardStatus(result.get(0).getReq_id());
	  }
		return res;
		
	}
	
}
