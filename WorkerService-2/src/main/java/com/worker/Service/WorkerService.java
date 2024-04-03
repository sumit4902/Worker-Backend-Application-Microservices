package com.worker.Service;

import java.util.List;


import com.worker.Payload.WorkerDto;

public interface WorkerService {

	
	WorkerDto createWorker(WorkerDto workerdto);
	
	WorkerDto updateWorker(WorkerDto workerdto ,long Id);
	WorkerDto getById(long Id);
	List<WorkerDto> GetAllWorker();
	void deleteWorker(long Id);
	
	//For microservice
	WorkerDto getWorkerByUserId(long userId);
	
}
