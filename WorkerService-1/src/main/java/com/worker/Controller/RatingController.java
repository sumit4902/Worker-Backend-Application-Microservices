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
import com.worker.Payload.RatingDto;
import com.worker.Services.RatingService;

@RestController
@RequestMapping("/api/service1")
public class RatingController {
       
	@Autowired 
	private RatingService ratingservice; 
	
	@PostMapping("/user/{userId}/rating/create")
	ResponseEntity<RatingDto> createRating(@RequestBody RatingDto ratingdto,@PathVariable long userId){
    RatingDto createrating	=	this.ratingservice.createRating(ratingdto,userId);
    return new ResponseEntity<RatingDto>(createrating,HttpStatus.CREATED);
	}
	
	// get Rating by userId 
	@GetMapping("/user/{Id}/rating")
	ResponseEntity<List<RatingDto>> getRatingByUserId(@RequestBody @PathVariable long userId)
	{
	  List<RatingDto> rating =	this.ratingservice.getRatingByUserId(userId);
	  return new ResponseEntity<List<RatingDto>>(rating,HttpStatus.OK);
	}
	
	
	@PutMapping("/rating/update/{Id}")
	ResponseEntity<RatingDto> updateRating(@RequestBody RatingDto ratingdto ,@PathVariable long Id)
	{
		RatingDto rating = this.ratingservice.updateRating(ratingdto, Id);
		return new ResponseEntity<RatingDto>(rating,HttpStatus.OK);
	}
	
	@GetMapping("/rating/{Id}")
	ResponseEntity<RatingDto> getByRatingId(@RequestBody @PathVariable long Id)
	{
	  RatingDto rating =	this.ratingservice.getRatingById(Id);
	  return new ResponseEntity<RatingDto>(rating,HttpStatus.OK);
	}
	
	@GetMapping("/rating/all")
	ResponseEntity<List<RatingDto>> getAllRating()
	{
	   List<RatingDto> allRating=this.ratingservice.getAllRating();
	   return new ResponseEntity<List<RatingDto>>(allRating,HttpStatus.OK);
	}
	
	@DeleteMapping("/rating/delete/{Id}")
	ResponseEntity<ApiResponse> deleteRating(@RequestBody @PathVariable long Id)
	{
	     this.ratingservice.deleteRating(Id);
	     return new ResponseEntity<ApiResponse>(new ApiResponse("Rating Delete Successfully..",true),HttpStatus.OK);
	}
}
