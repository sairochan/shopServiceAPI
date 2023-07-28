package org.backend.foulproofexam.controller;

import java.util.List;

import org.backend.foulproofexam.model.Question;
import org.backend.foulproofexam.model.User;
import org.backend.foulproofexam.repository.QuestionRepository;
import org.backend.foulproofexam.repository.UserRepository;
import org.backend.foulproofexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.backend.foulproofexam.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private UserService userServiceimpl;
	
	//getAllQuestions- UseIt
//	@CrossOrigin(origins = "http://localhost:4200")
//	@GetMapping("/users")
//	public List<User> getAllUsers(){
//		return userRepository.findAll(); 
//	}
	
	
	//getAllQuestions- UseIt
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/users")
	public User createUser (){
		System.out.println("hi i'm here");
		User user = new User("kacha","charan","chaka@bokka.f","thopu","thurummu","999");
		return userServiceimpl.createUser(user, null); 
	}
	
	//addQuestion-UseIt
//	@CrossOrigin(origins = "http://localhost:4200")
//	@PostMapping("/questions")
//	public Question createQuestion(@RequestBody Question question){
//		return questionRepository.save(question); 
//	}
	

}
