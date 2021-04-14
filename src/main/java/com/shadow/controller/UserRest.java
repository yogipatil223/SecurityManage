package com.shadow.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shadow.bean.UserBean;
import com.shadow.service.UserServ;

@Controller
public class UserRest {

	@Autowired
	UserServ service;
	
	 @RequestMapping("/")
     public String index()
     {
         return "index";
     }
	 
	 
	 @RequestMapping("/register")
     public String register()
     {
         return "registration";
     }

	@PostMapping("/login")
	public String process(Model model, HttpSession session,HttpServletRequest request) {
		String router ="index" ;
		try {
		UserBean bean = service.getUserInfoServ(request.getParameter("username") , request.getParameter("password") );
		if("admin".equalsIgnoreCase(bean.getRole())) {
			session.setAttribute("role", bean.getRole());
			session.setAttribute("usrid", bean.getUsrid());
			router = "dashboard";
		}else if("client".equalsIgnoreCase(bean.getRole())) {
			session.setAttribute("role", bean.getRole());
			session.setAttribute("usrid", bean.getUsrid());
			router = "dashboard";
		}
		}catch(Exception e) {
			request.setAttribute("invalid", "please enter valid information");
		}
		session.setAttribute("invalid", "please enter valid information");
		return router;
	}
	
	@PostMapping("/saveUser")
	public  String saveUser(UserBean bean) throws SerialException, SQLException, IOException {
		MultipartFile file = bean.getMulfile();
		System.out.println(file.getBytes());
		Blob cv = new SerialBlob(file.getBytes());
		System.out.println(cv);
		bean.setImageblob(cv);
		boolean result = false;
		String view = "registration";
		result = service.saveuser(bean);
		if(result == true) {
			view = "index";
		}
		return view;
	} 
	
	
	
	@GetMapping("/getSession")
	@ResponseBody
	public ArrayList<Object> getSession(HttpSession session) {
		ArrayList<Object> result = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		map.put("role", session.getAttribute("role").toString());
		map.put("usrid", session.getAttribute("usrid").toString());
		result.add(map);
		return result;
	}
	
	@GetMapping("/getAllUsers")
	@ResponseBody
	public List<UserBean> getAllUsers(){
		return service.getUsersServ();
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	
	}
