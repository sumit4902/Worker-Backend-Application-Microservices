package com.worker.Entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Team {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long teamId;
	@Column(nullable = true)
	
	private String name;
	@Column(nullable = true)
	private String leaderName;
	@Column(nullable = true)
	private String address;
	@Column(nullable = true)
	private String contact;
	@Column(nullable = true)
	private String tmOne;
	@Column(nullable = true)
	private String tmTwo;
	@Column(nullable = true)
	private String tmThree;
	@Column(nullable = true)
	private String tmFour;
	@Column(nullable = true)
    private String extramember;
	@Column(nullable = true)
	private String expertise;
	@Column(nullable = true)
	private int rate;
	private Date date;
	
	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	private Worker worker;
	
	
}
