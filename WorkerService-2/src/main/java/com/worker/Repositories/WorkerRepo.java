package com.worker.Repositories;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.worker.Entities.Worker;

public interface WorkerRepo extends JpaRepository<Worker, Long> {

	Worker findByUserId(long userId);
	
	// Filter Method find the particular worker according to the parameters //
	Page<Worker> findByNameContainingIgnoreCaseAndAddressContainingIgnoreCaseAndExpertiseContainingIgnoreCase(String name, String address, String expertise, Pageable pageable);
	
}
