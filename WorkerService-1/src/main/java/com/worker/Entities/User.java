package com.worker.Entities;

import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String name;
	private String Address;
	private String password;
	private String email;
	private String contact;
	
	 @JsonManagedReference
	@OneToMany(mappedBy = "user" ,cascade=CascadeType.ALL)
	private List<Rating> rating = new ArrayList<>(); 
	
	 @JsonManagedReference
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Notification> notification =new ArrayList<>();
	
	 @JsonManagedReference
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Friend> friend = new ArrayList<>();
}
