package com.worker.Services;

import java.util.List;

import com.worker.Entities.Friend;
import com.worker.Payload.FriendDto;

public interface FriendService {

	FriendDto createFriend(FriendDto frienddto,long userId);
	
	List<FriendDto> getFriendsByUserId(long userId);
	
	FriendDto updateFriend(FriendDto frienddto ,long Id);
	
	FriendDto getById(long Id);
	
	List<FriendDto> getAllFriends();
	
	void deletefriends(long Id);
}
