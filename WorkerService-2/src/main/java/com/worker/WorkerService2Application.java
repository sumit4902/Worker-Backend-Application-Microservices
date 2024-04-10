package com.worker;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.worker.Payload.TeamResponse;
import com.worker.Payload.WorkerResponse;

@SpringBootApplication
@ComponentScan("com.worker")
@EnableJpaRepositories("com.worker.Repositories")
@EntityScan("com.worker.Entities")
@EnableDiscoveryClient
public class WorkerService2Application {

	public static void main(String[] args) {
		SpringApplication.run(WorkerService2Application.class, args);
	}

	@Bean
	ModelMapper modelmapper()
	{
		return new ModelMapper();
	}
	
	@Bean
	TeamResponse teamResponse()
	{
		return new TeamResponse();
	}
	
	@Bean
	WorkerResponse workerResponse()
	{
		return new WorkerResponse();
	}
}
