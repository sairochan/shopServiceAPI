package com.infy.dao;

import com.infy.model.Admin;
import com.infy.model.users;

public interface AdminDAO {
	public Admin getUsernameAndPassword(String username);
	public users getUserdet(String email);
}
