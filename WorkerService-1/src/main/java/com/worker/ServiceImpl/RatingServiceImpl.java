package com.worker.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worker.Entities.Rating;
import com.worker.Entities.User;
import com.worker.Payload.RatingDto;
import com.worker.Repositories.RatingRepo;
import com.worker.Repositories.UserRepo;
import com.worker.Services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepo ratingrepo;
	
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public RatingDto createRating(RatingDto ratingdto,long userId) {
		User user = this.userrepo.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found"));
		Rating rating = this.modelmapper.map(ratingdto,Rating.class);
	    rating.setUser(user);
        Rating savedrating=this.ratingrepo.save(rating);
		return this.modelmapper.map(savedrating, RatingDto.class);
	}
	
	@Override
	public List<RatingDto> getRatingByUserId(long userId) {
		User user = this.userrepo.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found"));
		List<Rating> all = this.ratingrepo.findByUser(user);
		List<RatingDto> rating =all.stream().map(rate->this.modelmapper.map(rate, RatingDto.class)).collect(Collectors.toList());
		return rating;
	}


	@Override
	public RatingDto updateRating(RatingDto ratingdto, long Id) {
		Rating rating = this.ratingrepo.findById(Id).orElseThrow(()-> new RuntimeException("Rating Not Found"));
		rating.setRating(ratingdto.getRating());
		Rating  savedrating = this.ratingrepo.save(rating);
		return this.modelmapper.map(savedrating, RatingDto.class);
	}

	@Override
	public RatingDto getRatingById(long Id) {
		Rating rating = this.ratingrepo.findById(Id).orElseThrow(()-> new RuntimeException("Rating Not Found"));
		return this.modelmapper.map(rating, RatingDto.class);
	}

	@Override
	public List<RatingDto> getAllRating() {
		List<Rating> all = this.ratingrepo.findAll();
		List<RatingDto> rating =all.stream().map(rate->this.modelmapper.map(rate, RatingDto.class)).collect(Collectors.toList());
		return rating;
	}

	@Override
	public void deleteRating(long Id) {
		this.ratingrepo.deleteById(Id);
		
	}

	
}
