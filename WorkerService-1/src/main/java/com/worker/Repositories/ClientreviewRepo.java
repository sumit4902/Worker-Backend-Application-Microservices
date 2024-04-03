package com.worker.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worker.Entities.ClientReview;

public interface ClientreviewRepo extends JpaRepository<ClientReview,Long> {

	//Custom Methods //
	
}
