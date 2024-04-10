package com.worker.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.worker.Entities.Worker;
import com.worker.Payload.WorkerDto;
import com.worker.Payload.WorkerResponse;
import com.worker.Repositories.WorkerRepo;
import com.worker.Service.WorkerService;

@Service
public class WorkerServiceImpl implements WorkerService {

	
	@Autowired
	private WorkerRepo  workerrepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
   private WorkerResponse workerResponse;
	
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
	public WorkerResponse GetAllWorker(String name,String address,String expertise,int PageNo,int pageSize,String sortBy,String direc) {
		Pageable p;
		if(direc.equalsIgnoreCase("desc"))
		{
			p= PageRequest.of(PageNo, pageSize, Sort.by(sortBy).descending());
		}
		else {
			p = PageRequest.of(PageNo, pageSize, Sort.by(sortBy).ascending());
		}
	
		Page<Worker> workerpages = this.workerrepo.findByNameContainingIgnoreCaseAndAddressContainingIgnoreCaseAndExpertiseContainingIgnoreCase(name, address, expertise, p);
		
		List<Worker> workers = workerpages.getContent();
		List<WorkerDto> convertedwrker = workers.stream().map((worker)-> this.modelmapper.map(worker,WorkerDto.class)).collect(Collectors.toList());
		
		workerResponse.setContent(convertedwrker);
		workerResponse.setPageNo(workerpages.getNumber());
		workerResponse.setPageSize(workerpages.getSize());
		workerResponse.setTotalElements(workerpages.getTotalElements());
		workerResponse.setTotalPages(workerpages.getTotalPages());
		workerResponse.setLastpage(workerpages.isLast());
		return workerResponse;
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
