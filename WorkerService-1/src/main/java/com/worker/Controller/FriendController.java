package com.worker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worker.Payload.ApiResponse;
import com.worker.Payload.FriendDto;
import com.worker.Services.FriendService;

@RestController
@RequestMapping("/api/service1")
public class FriendController {

	@Autowired
	private FriendService friendService;
	
	@PostMapping("/user/{userId}/friend/create")
	ResponseEntity<FriendDto> createFriend(@RequestBody FriendDto frienddto, @PathVariable long userId)
	{
		FriendDto friend = this.friendService.createFriend(frienddto,userId);
		return new ResponseEntity<FriendDto>(friend,HttpStatus.CREATED);
	}
	
	// get Friend By userId 
	@GetMapping("/user/{userId}/friend")
	ResponseEntity<List<FriendDto>> getFriendByUserId(@RequestBody @PathVariable long userId)
	{
		List<FriendDto> allfriends = this.friendService.getFriendsByUserId(userId);
		return new ResponseEntity<List<FriendDto>>(allfriends,HttpStatus.OK);
	}
	
	
	@PutMapping("/Friend/Update/{Id}")
	ResponseEntity<FriendDto> updateFriend(@RequestBody FriendDto frienddto ,@PathVariable long Id)
	{
		FriendDto friend = this.friendService.updateFriend(frienddto, Id);
		return new ResponseEntity<FriendDto>(friend,HttpStatus.OK);
	}
	
	@GetMapping("/Friend/{Id}")
	ResponseEntity<FriendDto> getById(@RequestBody @PathVariable long Id)
	{
		FriendDto friend = this.friendService.getById(Id);
		return new ResponseEntity<FriendDto>(friend,HttpStatus.OK);
	}
	
	@GetMapping("/Friend/All")
	ResponseEntity<List<FriendDto>> getAll()
	{
		List<FriendDto> friend = this.friendService.getAllFriends();
		return new ResponseEntity<List<FriendDto>>(friend,HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/Friend/Delete/{Id}")
	ResponseEntity<ApiResponse> deleteFriend(@RequestBody @PathVariable long Id)
	{
		this.friendService.deletefriends(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("FriendDeleted Successfully",true),HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}