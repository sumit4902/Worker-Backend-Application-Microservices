package com.worker.Services;

import java.util.List;

import com.worker.Payload.RatingDto;

public interface RatingService {

	RatingDto createRating(RatingDto ratingdto,long userId);
	List<RatingDto> getRatingByUserId(long userId);
	RatingDto updateRating(RatingDto ratingdto,long Id);
	RatingDto getRatingById(long Id);
	List<RatingDto> getAllRating();
	void deleteRating(long Id);
	
}
