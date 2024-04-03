package com.worker.Payload;

import java.util.Date;

//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.worker.Entities.Team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDto {

	
	private long workerId;
	private long userId;
	private String name;
	private String contact;
	private String address;
	private String expertise;
	private Date date;
	private int rate;
	

	private TeamDto team; //one to one relation with team //
}
