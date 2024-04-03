package com.worker.Entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long workerId;
	
	@Column(unique = true,nullable = true)
	private long userId;
	
	@Column(unique = true, nullable = true)
	private String name;
	@Column( nullable = true)
	private String contact;
	@Column( nullable = true)
	private String address;
	@Column( nullable = true)
	private String expertise;
	private Date date;
	@Column(nullable = true)
	private int rate;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "worker",cascade = CascadeType.ALL)
	private Team team;
}
