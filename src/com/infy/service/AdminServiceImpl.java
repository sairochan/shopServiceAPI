package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.AdminDAO;
import com.infy.model.Admin;
import com.infy.model.users;

@Service("adminServiceImpl")
@Transactional(readOnly=true)
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAOImpl;

	
	public Admin getUsernameAndPassword(Admin admin) {
		System.out.println(admin.getUsername());
		Admin a= adminDAOImpl.getUsernameAndPassword(admin.getUsername());
      
		 if(a.getUsername().equals(admin.getUsername()) && a.getPassword().equals(admin.getPassword())) {
		
			 return a;
		}
		 else
		 {
			 return null;
		 }
	}
	public users getUserdet(String email){
		users a= adminDAOImpl.getUserdet(email);
	      
		 if(a==null) {
		
			 return null;
		}
		 else
		 {
			 return a;
		 }
	}
	
}
