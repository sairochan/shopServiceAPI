package com.infy.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.model.Admin;
import com.infy.model.users;
import com.infy.service.AdminService;
import com.infy.service.AdminServiceImpl;
import com.infy.service.UserRegService;
import com.infy.utility.ContextFactory;

@RestController
@CrossOrigin
@RequestMapping(value="AdminAPI")
public class AdminAPI {
	
	private AdminService as;
	private UserRegService us;
	
	@RequestMapping(method=RequestMethod.POST, value="getUP")
	private ResponseEntity<Admin> getUsernameAndPassword(@RequestBody Admin admin) {
	
		System.out.println(admin.getUsername()+"from api");
		ResponseEntity<Admin> res=null;
		as = (AdminServiceImpl) ContextFactory.getContext().getBean(AdminServiceImpl.class);
	
		Admin a=as.getUsernameAndPassword(admin);
		
		if(a==null) {
			return res=new ResponseEntity<>(a, HttpStatus.BAD_REQUEST);
		}
		return res=new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="getUserdet")
	private ResponseEntity<users> getUserdet(@RequestBody users user) {
	
		ResponseEntity<users> res=null;
		as = (AdminServiceImpl) ContextFactory.getContext().getBean(AdminServiceImpl.class);
	
		users a=as.getUserdet(user.getEmailId());
		
		if(a==null) {
			return res=new ResponseEntity<>(a, HttpStatus.BAD_REQUEST);
		}
		return res=new ResponseEntity<>(a, HttpStatus.OK);
	
}
}
