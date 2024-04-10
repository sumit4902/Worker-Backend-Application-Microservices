package com.worker.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.worker.Entities.Team;
import com.worker.Entities.Worker;

public interface TeamRepo extends JpaRepository<Team, Long> {
	
	//You may Create the Custom finder Mehtod //  
	
	Team findByWorker(Worker worker); 
	
	// this method will filter data according to the parameters 
	Page<Team> findByLeaderNameContainingIgnoreCaseAndAddressContainingIgnoreCaseAndExpertiseContainingIgnoreCase(String leaderName, String address, String expertise, Pageable pageable);


}
