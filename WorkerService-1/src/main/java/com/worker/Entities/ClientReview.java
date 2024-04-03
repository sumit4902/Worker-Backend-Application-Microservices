package com.worker.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ClientReview {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ClientreviewId;
	private long userId;
	private int  star;
	private String feedback;
}
