package com.worker.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worker.Entities.Friend;
import com.worker.Entities.User;
import com.worker.Payload.FriendDto;
import com.worker.Repositories.FriendRepo;
import com.worker.Repositories.UserRepo;
import com.worker.Services.FriendService;


@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	private FriendRepo friendrepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public FriendDto createFriend(FriendDto frienddto,long userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found "));
		Friend friend = this.modelmapper.map(frienddto, Friend.class);
		friend.setUser(user);
		friend.setApproved(false);
		Friend savefriend = this.friendrepo.save(friend);
		return this.modelmapper.map(savefriend, FriendDto.class);
	}
	// get Friends By userID
	@Override
	public List<FriendDto> getFriendsByUserId(long userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found "));
		List<Friend> friends = this.friendrepo.findByUser(user);		
		List<FriendDto> convertedfriends = friends.stream().map(friend -> this.modelmapper.map(friend,FriendDto.class)).collect(Collectors.toList());
		return convertedfriends;
	}
	

	@Override
	public FriendDto updateFriend(FriendDto frienddto, long Id) {
		Friend friend = this.friendrepo.findById(Id).orElseThrow(()->new RuntimeException("Friend Not Found"));
		friend.setToUser(frienddto.getToUser());
		friend.setApproved(frienddto.isApproved());
		Friend updatedfriend = this.friendrepo.save(friend);
		return this.modelmapper.map(updatedfriend, FriendDto.class);
	}

	@Override
	public FriendDto getById(long Id) {
		Friend friend = this.friendrepo.findById(Id).orElseThrow(()->new RuntimeException("Friend Not Found"));
		
		return this.modelmapper.map(friend, FriendDto.class);
	}

	@Override
	public List<FriendDto> getAllFriends() {
		 List<Friend> allfriend = this.friendrepo.findAll();
		 List<FriendDto> convertedfriend = allfriend.stream().map((friend)->this.modelmapper.map(friend,FriendDto.class)).collect(Collectors.toList());
		return convertedfriend;
	}

	@Override
	public void deletefriends(long Id) {
		Friend friend = this.friendrepo.findById(Id).orElseThrow(()->new RuntimeException("Friend Not Found"));
		this.friendrepo.delete(friend);
		
	}

	

}
