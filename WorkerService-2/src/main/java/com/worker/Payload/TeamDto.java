package com.worker.Payload;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {

	private long teamId;
	

	
	private String name;
	
	private String leaderName;
	
	private String address;
	
	private String contact;
	
	private String tmOne;
	
	private String tmTwo;
	
	private String tmThree;
	
	private String tmFour;
	
    private String extramember;
	
	private String expertise;
	
	private int rate;
	private Date date;
}
