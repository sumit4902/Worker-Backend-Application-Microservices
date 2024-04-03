package com.worker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worker.Payload.ApiResponse;
import com.worker.Payload.WorkerDto;
import com.worker.Service.WorkerService;

@RestController
@RequestMapping("/api/service2")
public class WorkerController {

	
	@Autowired
	private WorkerService workerservice;
	
	@PostMapping("/worker/create")
	ResponseEntity<WorkerDto> createWorker(@RequestBody WorkerDto workerdto)
	{
		WorkerDto savedworker = this.workerservice.createWorker(workerdto);
		return new ResponseEntity<WorkerDto>(savedworker,HttpStatus.CREATED);
	}
	
	@PutMapping("/worker/update/{Id}")
	ResponseEntity<WorkerDto> updateWorker(@RequestBody WorkerDto workerdto ,@PathVariable long Id)
	{
	  WorkerDto worker =	this.workerservice.updateWorker(workerdto, Id);
	  return new ResponseEntity<WorkerDto>(worker,HttpStatus.OK);
	}
	
	@GetMapping("/worker/{Id}")
	ResponseEntity<WorkerDto> getWorkerById(@RequestBody @PathVariable long Id)
	{
		WorkerDto worker = this.workerservice.getById(Id);
		return new ResponseEntity<WorkerDto>(worker,HttpStatus.OK);
	}
	
	@GetMapping("/worker/all")
	ResponseEntity<List<WorkerDto>> getAllWorkers()
	{
		List<WorkerDto> allworker =  this.workerservice.GetAllWorker();
		return new ResponseEntity<List<WorkerDto>>(allworker,HttpStatus.OK);
		
	}
	@DeleteMapping("/worker/delete/{Id}")
	ResponseEntity<ApiResponse> deleteWorker(@RequestBody @PathVariable long Id)
	{
		this.workerservice.deleteWorker(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Worker Deleted Successfully",true),HttpStatus.OK);
	}
	
	//For microservices
	
	@GetMapping("/worker/user/{userId}")
	ResponseEntity<WorkerDto> getWorkerByuserId(@RequestBody @PathVariable long userId)
	{
		WorkerDto worker = this.workerservice.getWorkerByUserId(userId);
		return new ResponseEntity<WorkerDto>(worker,HttpStatus.OK);
	}
	
}
