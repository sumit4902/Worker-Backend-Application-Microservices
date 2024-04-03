package com.worker.Repositories;




import org.springframework.data.jpa.repository.JpaRepository;

import com.worker.Entities.Worker;

public interface WorkerRepo extends JpaRepository<Worker, Long> {

	Worker findByUserId(long userId);
}
