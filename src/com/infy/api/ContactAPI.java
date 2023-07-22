package com.infy.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.model.Contactus;

import com.infy.service.ContactusServiceImpl;

import com.infy.utility.ContextFactory;


@RestController
@CrossOrigin
@RequestMapping(value="ContactAPI")
public class ContactAPI {
	
private ContactusServiceImpl cs;

@RequestMapping(method=RequestMethod.POST,value="setmes")
public ResponseEntity<Contactus> setmes(@RequestBody Contactus c){
	cs =   (ContactusServiceImpl) ContextFactory.getContext().getBean(ContactusServiceImpl.class);
	ResponseEntity<Contactus> responseEntity = null;
	Contactus u = cs.setmes(c);
	responseEntity = new ResponseEntity<Contactus> (u,HttpStatus.OK);
	if(u==null){
		responseEntity = new ResponseEntity<Contactus> (u,HttpStatus.BAD_REQUEST);
	}
	return responseEntity;
}

}
