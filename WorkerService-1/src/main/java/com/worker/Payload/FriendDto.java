package com.worker.Payload;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FriendDto {

	
	private long id;
//	private long fromUser;
	private long toUser;
	private boolean approved;
}
