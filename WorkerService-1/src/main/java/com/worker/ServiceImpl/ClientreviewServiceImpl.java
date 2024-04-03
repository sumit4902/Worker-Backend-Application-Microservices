package com.worker.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worker.Entities.ClientReview;
import com.worker.Payload.ClientreviewDto;
import com.worker.Repositories.ClientreviewRepo;
import com.worker.Services.ClientreviewService;

@Service
public class ClientreviewServiceImpl implements ClientreviewService{

	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private ClientreviewRepo reviewrepo;
	
	
	@Override
	public ClientreviewDto createReview(ClientreviewDto reviewdto) {
		ClientReview review = this.modelmapper.map(reviewdto, ClientReview.class);
		ClientReview savedreview = this.reviewrepo.save(review);
		return this.modelmapper.map(savedreview, ClientreviewDto.class);
	}

	@Override
	public ClientreviewDto updateReview(ClientreviewDto reviewdto, long Id) {
		
		ClientReview review = this.reviewrepo.findById(Id).orElseThrow(()-> new RuntimeException("Review Not Found"));
		
		review.setUserId(reviewdto.getUserId());
		review.setStar(reviewdto.getStar());
		review.setFeedback(reviewdto.getFeedback());
		   ClientReview updatedreview = this.reviewrepo.save(review);
		return this.modelmapper.map(updatedreview, ClientreviewDto.class);
	}

	@Override
	public ClientreviewDto getreviewById(long Id) {
		
		ClientReview review = this.reviewrepo.findById(Id).orElseThrow(()-> new RuntimeException("Review Not Found"));
		
		return this.modelmapper.map(review,ClientreviewDto.class);
	}

	@Override
	public List<ClientreviewDto> getAllreview() {
	
		List<ClientReview> allreview = this.reviewrepo.findAll();
		
		List<ClientreviewDto> convertedreview = allreview.stream().map((reviews)-> this.modelmapper.map(reviews,ClientreviewDto.class)).collect(Collectors.toList());
		
		return convertedreview;
	}

	@Override
	public void delete(long Id) {
	
		this.reviewrepo.deleteById(Id);
		
		
	}

}
