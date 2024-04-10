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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.worker.Payload.ApiResponse;
import com.worker.Payload.WorkerDto;
import com.worker.Payload.WorkerResponse;
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
	ResponseEntity<WorkerResponse> getAllWorkers(@RequestBody 
			@RequestParam(name = "name",defaultValue = "",required = false) String name,
	        @RequestParam(name = "address",defaultValue = "",required = false) String address,
	        @RequestParam(name = "expertise",defaultValue = "",required = false) String expertise,
	        @RequestParam(name = "pageNo",defaultValue ="0",required = false) int pageNo,
	        @RequestParam(name = "pageSize",defaultValue ="20",required = false) int pageSize,
	        @RequestParam(name = "sortBy",defaultValue = "workerId",required = false) String sortBy,
	        @RequestParam(name = "direc",defaultValue = "desc",required = false) String direc)
	  	{
		WorkerResponse  allworker =  this.workerservice.GetAllWorker(name, address, expertise, pageNo, pageSize, sortBy, direc);
		return new ResponseEntity<WorkerResponse>(allworker,HttpStatus.OK);
		
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
