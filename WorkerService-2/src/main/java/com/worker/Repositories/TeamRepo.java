package com.worker.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worker.Entities.Team;
import com.worker.Entities.Worker;

public interface TeamRepo extends JpaRepository<Team, Long> {
	
	//You may Create the Custom finder Mehtod //  
	
	Team findByWorker(Worker worker); 

}
