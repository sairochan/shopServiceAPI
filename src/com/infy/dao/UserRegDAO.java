package com.infy.dao;

import com.infy.model.security;
import com.infy.model.users;

public interface UserRegDAO {
	public users register(users user);
	public users getUsernameAndPassword(String email);
	public users total(String email);
	public security forgotP(String email);
	public security registerQA(security sec);
	public users checkA(security s);
}
