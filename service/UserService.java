package org.backend.foulproofexam.service;

import java.util.Set;

import org.backend.foulproofexam.model.User;
import org.backend.foulproofexam.model.UserRole;
import org.springframework.stereotype.Service;


public interface UserService {
	
	public User createUser(User user, Set<UserRole> userRoles);
}
