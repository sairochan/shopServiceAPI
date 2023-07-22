package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.ContactDAO;
import com.infy.dao.ProductDAO;
import com.infy.model.Contactus;
import com.infy.model.Product;
@Service("contactusServiceImpl")
@Transactional(readOnly=true)
public class ContactusServiceImpl implements ContactusService {
	@Autowired
	private ContactDAO cd;
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public Contactus setmes(Contactus c) {
		
		Contactus co=new Contactus();
		
		co=cd.setmes(c);
		return co;
	}
}
