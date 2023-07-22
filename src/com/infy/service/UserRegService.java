package com.infy.service;

import com.infy.model.security;
import com.infy.model.users;

public interface UserRegService {
	public users register(users user);
	public users getUsernameAndPassword(users user);
	public users total(String email);
	public security forgotP(String email);
	public users checkA(security s);
	public security registerQA(security sec);
}
