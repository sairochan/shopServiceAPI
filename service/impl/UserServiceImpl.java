package org.backend.foulproofexam.service.impl;

import java.util.Set;

import org.backend.foulproofexam.model.User;
import org.backend.foulproofexam.model.UserRole;
import org.backend.foulproofexam.repository.UserRepository;
import org.backend.foulproofexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) {

		return userRepository.save(user);
	}
}
