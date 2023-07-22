package com.infy.api;

import java.security.Security;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.model.Admin;
import com.infy.model.security;
import com.infy.model.users;
import com.infy.service.AdminServiceImpl;
import com.infy.service.UserRegService;
import com.infy.service.UserRegServiceImpl;
import com.infy.utility.ContextFactory;

@RestController
@CrossOrigin
@RequestMapping(value="UserApi")
public class UserApi {


private UserRegServiceImpl serv;

@RequestMapping(value="user", method=RequestMethod.POST)
public ResponseEntity<users> register(@RequestBody users user){
	serv =   (UserRegServiceImpl) ContextFactory.getContext().getBean(UserRegServiceImpl.class);
	ResponseEntity<users> responseEntity = null;
	users u = serv.register(user);
	responseEntity = new ResponseEntity<users> (u,HttpStatus.OK);
	if(u==null){
		responseEntity = new ResponseEntity<users> (u,HttpStatus.BAD_REQUEST);
	}
	return responseEntity;
}

private UserRegService as;

@RequestMapping(method=RequestMethod.POST, value="getUP")
private ResponseEntity<users> getUsernameAndPassword(@RequestBody users user) {

	System.out.println(user.getEmailId()+"from api");
	ResponseEntity<users> res=null;
	as = (UserRegServiceImpl) ContextFactory.getContext().getBean(UserRegServiceImpl.class);

	users a=as.getUsernameAndPassword(user);
	
	if(a==null) {
		return res=new ResponseEntity<>(a, HttpStatus.BAD_REQUEST);
	}
	return res=new ResponseEntity<>(a, HttpStatus.OK);
}


@RequestMapping(method=RequestMethod.GET, value="total/{email}")
private ResponseEntity<users> total(@PathVariable String email) {
	System.out.println(email);
	ResponseEntity<users> res=null;
	as = (UserRegServiceImpl) ContextFactory.getContext().getBean(UserRegServiceImpl.class);

	users a=as.total(email+".com");
	
	if(a==null) {
		return res=new ResponseEntity<>(a, HttpStatus.BAD_REQUEST);
	}
	return res=new ResponseEntity<>(a, HttpStatus.OK);
}

@RequestMapping(method=RequestMethod.POST, value="registerQA")
private ResponseEntity<security> registerQA(@RequestBody security sec) {

	ResponseEntity<security> res=null;
	as = (UserRegServiceImpl) ContextFactory.getContext().getBean(UserRegServiceImpl.class);
	
	security q=as.registerQA(sec);
	
	if(q==null) {
		return res=new ResponseEntity<>(q, HttpStatus.BAD_REQUEST);
	}
	return res=new ResponseEntity<>(q, HttpStatus.OK);
}

@RequestMapping(method=RequestMethod.GET, value="forgotP/{email}")
private ResponseEntity<security> forgotP(@PathVariable String email) {
	System.out.println(email);
	ResponseEntity<security> res=null;
	as = (UserRegServiceImpl) ContextFactory.getContext().getBean(UserRegServiceImpl.class);

	security q=as.forgotP(email+".com");
	System.out.println(q);
	if(q==null) {
		return res=new ResponseEntity<>(q, HttpStatus.BAD_REQUEST);
	}
	return res=new ResponseEntity<>(q, HttpStatus.OK);
}

@RequestMapping(method=RequestMethod.POST, value="checkA")
private ResponseEntity<users> checkA(@RequestBody security s){

	ResponseEntity<users> res=null;
	as = (UserRegServiceImpl) ContextFactory.getContext().getBean(UserRegServiceImpl.class);

	users p=as.checkA(s);
	
	if(p==null) {
		return res=new ResponseEntity<>(p, HttpStatus.BAD_REQUEST);
	}
	return res=new ResponseEntity<>(p, HttpStatus.OK);
}

}
