package com.infy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.entity.SecurityEntity;
import com.infy.entity.UserEntity;
import com.infy.model.security;
import com.infy.model.users;
@Repository("userRegDAOImpl")
public class UserRegDAOImpl implements UserRegDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public users register(users user) {
		if(user==null){
			return null;
		}
		Session session = null;
		System.out.println(user.getEmailId());
		session = sessionFactory.getCurrentSession();
		System.out.println("\n***************\n");
			UserEntity userEntity =  new UserEntity();
			userEntity.setName(user.getName());
			userEntity.setEmailId(user.getEmailId());
			userEntity.setPassword(user.getPassword());
			userEntity.setPhoneNo(user.getPhoneNo());
			//userEntity.setQes(user.getQes());
			//userEntity.setAns(user.getAns());
			
			session.persist(userEntity);
			
			return user;
			
	}
	
	public users getUsernameAndPassword(String email) {
		
		Session session=sessionFactory.getCurrentSession();
		UserEntity ae = session.get(UserEntity.class, email);
				
		users a=new users();
		a.setEmailId(ae.getEmailId());
		a.setPassword(ae.getPassword());
		a.setName(ae.getName());
		a.setPhoneNo(ae.getPhoneNo());
		
		return a;
	}
	
	public users total(String email) {
		
		Session session=sessionFactory.getCurrentSession();
		UserEntity ae = session.get(UserEntity.class, email);
				
		users a=new users();
		a.setEmailId(ae.getEmailId());
		a.setPassword(ae.getPassword());
		a.setName(ae.getName());
		a.setPhoneNo(ae.getPhoneNo());
		a.setGrandTotal(ae.getGrandTotal());
		
		return a;
	}
	/***************************** for Q & A***************************/
	public security registerQA(security sec) {
		if(sec==null){
			return null;
		}
		Session session = null;
		//System.out.println(user.getEmailId());
		session = sessionFactory.getCurrentSession();
	
			SecurityEntity so =  new SecurityEntity();
			so.setAnswer(sec.getAnswer());
			so.setEmail(sec.getEmail());
			so.setQuestion(sec.getQuestion());;
			
			//userEntity.setQes(user.getQes());
			//userEntity.setAns(user.getAns());
			
			session.persist(so);
			
			return sec;
			
	}
	public security forgotP(String email) {
		
		Session session=sessionFactory.getCurrentSession();
		System.out.println(email+"hjh");
		SecurityEntity se = session.get(SecurityEntity.class, email);
		security s=new security();
		s.setQuestion(se.getQuestion());
		s.setEmail(se.getEmail());
		return s;
	}
	
	public users checkA(security s) {

		Session session=sessionFactory.getCurrentSession();
		Session session2=sessionFactory.getCurrentSession();
		SecurityEntity se = session.get(SecurityEntity.class, s.getEmail());		
		UserEntity ue = session2.get(UserEntity.class, s.getEmail());	
		
		if(s.getAnswer().equals(se.getAnswer()) && s.getEmail().equals(se.getEmail()))
		{
			users uu=new users();
			uu.setPassword(ue.getPassword());
			return uu;
		}
		else {
		return null;
		}
	}
}
