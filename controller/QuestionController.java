package org.backend.foulproofexam.controller;

import java.util.List;

import org.backend.foulproofexam.model.Question;
import org.backend.foulproofexam.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class QuestionController {
		
	@Autowired
	private QuestionRepository questionRepository;
	
	//getAllQuestions- UseIt
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/questions")
	public List<Question> getAllQuestion(){
		return questionRepository.findAll(); 
	}
	
	//addQuestion-UseIt
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/questions")
	public Question createQuestion(@RequestBody Question question){
		return questionRepository.save(question); 
	}
	
}
