package org.backend.foulproofexam.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id; 
	private String firstName;
	private String LastName;
	private String email;
	private String phone;
	private String linkedInProfileUrl;
	private String githubProfileUrl;
	private boolean accountEnabled=true;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	public User( String firstName, String LastName, String email, String phone,
	String linkedInProfileUrl, String githubProfileUrl ) { 
		this.firstName=firstName;
		this.LastName=LastName;
		this.email=email;
		this.phone=phone;
		this.linkedInProfileUrl=linkedInProfileUrl;
		this.githubProfileUrl=githubProfileUrl;
	}
	
	
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Long getId() {
		return user_id;
	}
	public void setId(Long id) {
		this.user_id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLinkedInProfileUrl() {
		return linkedInProfileUrl;
	}
	public void setLinkedInProfileUrl(String linkedInProfileUrl) {
		this.linkedInProfileUrl = linkedInProfileUrl;
	}
	public String getGithubProfileUrl() {
		return githubProfileUrl;
	}
	public void setGithubProfileUrl(String githubProfileUrl) {
		this.githubProfileUrl = githubProfileUrl;
	}
	public boolean isAccountEnabled() {
		return accountEnabled;
	}
	public void setAccountEnabled(boolean accountEnabled) {
		this.accountEnabled = accountEnabled;
	}
	
	
	

}
