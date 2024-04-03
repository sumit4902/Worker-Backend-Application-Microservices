package com.worker.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worker.Entities.Worker;
import com.worker.Payload.WorkerDto;
import com.worker.Repositories.WorkerRepo;
import com.worker.Service.WorkerService;

@Service
public class WorkerServiceImpl implements WorkerService {

	
	@Autowired
	private WorkerRepo  workerrepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public WorkerDto createWorker(WorkerDto workerdto) {
		
		Worker handyworker = this.modelmapper.map(workerdto, Worker.class);
		handyworker.setDate(new Date());
	
		  Worker handyworkersaved = this.workerrepo.save(handyworker);
		return this.modelmapper.map(handyworkersaved, WorkerDto.class);
	}

	@Override
	public WorkerDto updateWorker(WorkerDto workerdto, long Id) {
		Worker handyworker = this.workerrepo.findById(Id).orElseThrow(()-> new RuntimeException("Worker Not Found"));
		handyworker.setName(workerdto.getName());
		handyworker.setAddress(workerdto.getAddress());
		handyworker.setContact(workerdto.getContact());
		handyworker.setExpertise(workerdto.getExpertise());
		handyworker.setRate(workerdto.getRate());
		
		Worker updatesworker = this.workerrepo.save(handyworker);
		return this.modelmapper.map(updatesworker, WorkerDto.class);
	}

	@Override
	public WorkerDto getById(long Id) {
		Worker handyworker = this.workerrepo.findById(Id).orElseThrow(()-> new RuntimeException("Worker Not Found"));
		return this.modelmapper.map(handyworker,WorkerDto.class);
	}

	@Override
	public List<WorkerDto> GetAllWorker() {
		List<Worker> allworker = this.workerrepo.findAll();
		List<WorkerDto> convertedwrker = allworker.stream().map((worker)-> this.modelmapper.map(worker,WorkerDto.class)).collect(Collectors.toList());
		return convertedwrker;
	}

	@Override
	public void deleteWorker(long Id) {
	
		this.workerrepo.deleteById(Id);
		
	}

	// For Microservice
	
	@Override
	public WorkerDto getWorkerByUserId(long userId) {
		Worker worker = this.workerrepo.findByUserId(userId);
		return this.modelmapper.map(worker, WorkerDto.class);
	}

}
