package com.worker.Services;

import java.util.List;

import com.worker.Payload.ClientreviewDto;

public interface ClientreviewService {

	ClientreviewDto createReview(ClientreviewDto reviewdto);
	
	ClientreviewDto  updateReview(ClientreviewDto reviewdto ,long Id);
	
	ClientreviewDto getreviewById(long Id);
	
	List<ClientreviewDto> getAllreview();
	
	public void delete(long Id);
}
