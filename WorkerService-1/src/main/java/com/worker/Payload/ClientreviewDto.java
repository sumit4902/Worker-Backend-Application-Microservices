package com.worker.Payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientreviewDto {

	private long id;
	private long userId;
	private int  star;
	private String feedback;

}
