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
import com.worker.Payload.ClientreviewDto;
import com.worker.Services.ClientreviewService;

@RestController
@RequestMapping("/api/service1")
public class ClientreviewController {

	@Autowired
	private ClientreviewService reviewService;


	@PostMapping("/Review/Create")
	ResponseEntity<ClientreviewDto> createReview (@RequestBody ClientreviewDto reviewdto)
	{
		ClientreviewDto review = this.reviewService.createReview(reviewdto);
		return new ResponseEntity<ClientreviewDto>(review,HttpStatus.CREATED);
	}
	
	@PutMapping("/Review/Update/{Id}")
	ResponseEntity<ClientreviewDto> updateReview(@RequestBody ClientreviewDto reviewdto ,@PathVariable long Id)
	{
		ClientreviewDto updatedreview = this.reviewService.updateReview(reviewdto, Id);
		return new ResponseEntity<ClientreviewDto>(updatedreview,HttpStatus.OK);
	
	}
	
	@GetMapping("/Review/{Id}")
	ResponseEntity<ClientreviewDto> getreviewById(@RequestBody @PathVariable long Id)
	{
		ClientreviewDto  review = this.reviewService.getreviewById(Id);
		return new ResponseEntity<ClientreviewDto>(review,HttpStatus.OK);
	}
	
	@GetMapping("/Review/All")
	ResponseEntity<List<ClientreviewDto>> getAllReviews ()
	{
		List<ClientreviewDto> allreview = this.reviewService.getAllreview();
		return new ResponseEntity<List<ClientreviewDto>>(allreview,HttpStatus.OK);
	}
	
	@DeleteMapping("/Review/Delete/{Id}")
	ResponseEntity<ApiResponse> deleteReview(@RequestBody @PathVariable long Id)
	{
	   this.reviewService.delete(Id);
	   return new ResponseEntity<ApiResponse>(new ApiResponse("Review Deleted Successfully...",true),HttpStatus.OK);
	}
	
}
