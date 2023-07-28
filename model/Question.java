package org.backend.foulproofexam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="question")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long question_id;
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "option_one")
	private String optionOne;

	@Column(name = "option_two")
	private String optionTwo;
	
	@Column(name = "option_three")
	private String optionThree;
	
	@Column(name = "option_four")
	private String optionFour;
	
	
	
	
	
	public Question() {
		
	}

	public Question(String question, String optionOne, String optionTwo, String optionThree,
			String optionFour) {
		super();
		this.question = question;
		this.optionOne = optionOne;
		this.optionTwo = optionTwo;
		this.optionThree = optionThree;
		this.optionFour = optionFour;
	}

	public Long getQuestion_id() {
		return question_id;
	}
	
	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getOptionOne() {
		return optionOne;
	}
	
	public void setOptionOne(String optionOne) {
		this.optionOne = optionOne;
	}
	
	public String getOptionTwo() {
		return optionTwo;
	}
	
	public void setOptionTwo(String optionTwo) {
		this.optionTwo = optionTwo;
	}
	public String getOptionThree() {
		return optionThree;
	}
	public void setOptionThree(String optionThree) {
		this.optionThree = optionThree;
	}
	public String getOptionFour() {
		return optionFour;
	}
	public void setOptionFour(String optionFour) {
		this.optionFour = optionFour;
	}
	
	
}
