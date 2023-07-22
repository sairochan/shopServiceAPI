package com.infy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.entity.AdminEntity;
import com.infy.entity.ContactusEntity;
import com.infy.entity.ProductEntity;
import com.infy.model.Contactus;
@Repository("contactDAOImpl")
public class ContactDAOImpl implements ContactDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	public Contactus setmes(Contactus c){
		System.out.println(c.getEmail());
		if(c==null) {
			System.out.println("sdfsdfsfsdf dao");
			return null;
		
		}
		Session session=null;
		session=sessionFactory.getCurrentSession();
		ContactusEntity co=new ContactusEntity();
		co.setEmail(c.getEmail());
		co.setMessage(c.getMessage());
		co.setName(c.getName());
		System.out.println("sdfsdfsfsdf dao");
		session.persist(co);
		System.out.println("sdfsdfsfsdf dao 2");
		return c;
		
	}
	

}
