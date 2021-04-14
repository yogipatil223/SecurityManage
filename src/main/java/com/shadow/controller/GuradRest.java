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

import com.shadow.bean.GuardBean;
import com.shadow.service.GuardServ;

@Controller
@RequestMapping("/GuradRest")
public class GuradRest {

	@Autowired
	GuardServ service;
	
	@PostMapping("/setGuard")
	@ResponseBody
	public String setGuard(@RequestBody GuardBean bean) {
		String result = "false";
		
		try {
			result =  service.setGuard(bean);
		}catch(Exception e) {
			System.out.println("Exception in GuradRest in setGuard()="+e);
		}
		return result;
	}
	
	@GetMapping("/getGuardInfo")
	@ResponseBody
	public List<GuardBean> getGuardInfo(){
		List<GuardBean> result = service.getGuardInfo();
		return result;		
	}
	
	@GetMapping("/deleteGuard")
	@ResponseBody
	public String deleteGuard(@RequestParam int gid) {
		System.out.println("gid==");
		String result = "false";
		try {
			result = service.deleteGuard(gid);
		}catch(Exception e) {
			System.out.println("Exception in GuradRest in deleteGuard()="+e);
		}
		return result;
	}
	
}
