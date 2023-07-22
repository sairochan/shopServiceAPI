package com.infy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.List;

@Entity
@Table(name="Users", uniqueConstraints=@UniqueConstraint(name="uniquePH", columnNames="phoneNo"))
public class UserEntity {

	private String name;
//	@Column(unique=true)
	private Double phoneNo;
	@Id
	private String emailId;
	private String password;
	//private String question;


	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "cart", 
	joinColumns = @JoinColumn(name = "emailId", referencedColumnName = "emailId"), 
	inverseJoinColumns = @JoinColumn(name = "prodid", referencedColumnName = "prodid"))
	private List<ProductEntity> pe;
	
	private Integer grandTotal;



	
	public Integer getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Integer grandTotal) {
		this.grandTotal = grandTotal;
	}
	public List<ProductEntity> getPe() {
		return pe;
	}
	public void setPe(List<ProductEntity> pe) {
		this.pe = pe;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Double phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}*/
	
	
}
