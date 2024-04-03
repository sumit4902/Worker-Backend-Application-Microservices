package com.worker.Payload;




import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.worker.Entities.Friend;
import com.worker.Entities.Notification;
import com.worker.Entities.Rating;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDao {

	private long userId;
	private String name;
	private String Address;
	private String password;
	private String email;
	private String contact;
	
	
	
	private Set<Rating> rating = new HashSet<>();
	 
	
	 private Set<Notification> notification = new HashSet<>();
	 
	
	 private Set<Friend> friend = new HashSet<>();
	 
	 // this attribute for the Microservices 
	 private WorkerDto worker;
	
}