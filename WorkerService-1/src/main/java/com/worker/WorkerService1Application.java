package com.worker;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.worker.Repositories")
@ComponentScan("com.worker")
@EntityScan("com.worker.Entities")
@EnableFeignClients("com.worker.ServiceImpl")
@EnableDiscoveryClient
public class WorkerService1Application {

	public static void main(String[] args) {
		SpringApplication.run(WorkerService1Application.class, args);
	}
	
	@Bean
	ModelMapper modelmapper()
	{
		return new ModelMapper();
	}

}
