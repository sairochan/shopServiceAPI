package com.infy.service;

import com.infy.model.Admin;
import com.infy.model.users;

public interface AdminService {
	public Admin getUsernameAndPassword(Admin admin);
	public users getUserdet(String email);
}
