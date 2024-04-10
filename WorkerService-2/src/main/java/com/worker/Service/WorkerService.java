package com.worker.Service;

import java.util.List;


import com.worker.Payload.WorkerDto;
import com.worker.Payload.WorkerResponse;

public interface WorkerService {

	
	WorkerDto createWorker(WorkerDto workerdto);
	
	WorkerDto updateWorker(WorkerDto workerdto ,long Id);
	WorkerDto getById(long Id);
	
	void deleteWorker(long Id);
	
	
	
	// for filter
    WorkerResponse GetAllWorker(String name,String address,String expertise,int PageNo,int pageSize,String sortBy,String direc);
	
    
    
    
    //For microservice
	WorkerDto getWorkerByUserId(long userId);
	
}
