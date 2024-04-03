package com.worker.ServiceImpl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.worker.Payload.WorkerDto;

@FeignClient(url = "http://localhost:9092",name = "WORKER-SERVICE-TWO")
public interface WorkerClient {

	@GetMapping("/api/service2/worker/user/{userId}")
	WorkerDto getWorkerByUserId(@PathVariable long userId);
}
