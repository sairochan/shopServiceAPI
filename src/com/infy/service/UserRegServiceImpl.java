package com.infy.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.UserRegDAO;
import com.infy.model.security;
import com.infy.model.users;

@Service("userRegServiceImpl")
@Transactional(readOnly=true)
public class UserRegServiceImpl implements UserRegService{
	
	@Autowired
	private UserRegDAO urd;
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public users register(users user){
		if(user==null){
			return null;
		}System.out.println(user.getName()+"from service");
		System.out.println(user.getEmailId()+"fcvkjn");
		users u=new users();
		u=urd.register(user);
		return u;
		
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public users getUsernameAndPassword(users user) {
//		System.out.println(user.getUsername());
		users a= urd.getUsernameAndPassword(user.getEmailId());
      System.out.println("jkhgjhgg service");
		 if(a.getEmailId().equals(user.getEmailId()) && a.getPassword().equals(user.getPassword())) {
		
			 return a;
		}
		 else
		 {
			 return null;
		 }
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public users total(String email){
		
		users a= urd.total(email);
	      
		 if(a!=null) {
		
			 return a;
		}
		 else
		 {
			 return null;
		 }
		
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public security registerQA(security sec){
		if(sec==null){
			return null;
		}
		security s=urd.registerQA(sec);
		return s;
	}
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public security forgotP(String email){
		if(email==null){
			return null;
		}
		security q =urd.forgotP(email);
		
		 if(q!=null) {
				
			 return q;
		}

			 return null;
	}
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public users checkA(security s){
		users p = urd.checkA(s);
		System.out.println(p);
		 if(p!=null) {
			 return p;
		}
		 else{
			 return null;
		 }
		
	}
	
	
}
