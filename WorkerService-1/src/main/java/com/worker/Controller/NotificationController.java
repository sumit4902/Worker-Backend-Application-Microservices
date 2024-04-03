package com.worker.Controller;

import java.util.List;

import org.apache.catalina.connector.Response;
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
import com.worker.Payload.NotificationDto;
import com.worker.Services.NotificationService;

@RestController
@RequestMapping("/api/service1")
public class NotificationController {

	@Autowired
	private NotificationService  notifiservice;
	
	@PostMapping("/user/{userId}/notification/create")
	ResponseEntity<NotificationDto> createNotification(@RequestBody NotificationDto notifidto,@PathVariable long userId)
	{
		
	   NotificationDto notifi =	this.notifiservice.createNotifi(notifidto,userId);
	   return new ResponseEntity<NotificationDto>(notifi,HttpStatus.CREATED);
	}
	
	// find By UserId
	@GetMapping("/user/{userId}/Notification")
	ResponseEntity<List<NotificationDto>> getNotificationByUserId(@RequestBody @PathVariable long userId)
	{
		List<NotificationDto> allnotification = this.notifiservice.getNotificationByUserId(userId);
		return new ResponseEntity<List<NotificationDto>>(allnotification,HttpStatus.OK);
	}
	
	@PutMapping("/notification/update/{Id}")
	ResponseEntity<NotificationDto> updateNotification(@RequestBody NotificationDto nitifidto ,@PathVariable long Id)
	{
	  NotificationDto notifidto =	this.notifiservice.updateNotifi(nitifidto, Id);
	  return new ResponseEntity<NotificationDto>(notifidto,HttpStatus.OK);
	}
	
	@GetMapping("/notification/{Id}")
	ResponseEntity<NotificationDto> getNotifiById(@RequestBody @PathVariable long Id)
	{
	   NotificationDto notifi =	this.notifiservice.getById(Id);
	   return new ResponseEntity<NotificationDto>(notifi,HttpStatus.OK);
	}
	
	@GetMapping("/notification/all")
	ResponseEntity<List<NotificationDto>> GetAllNotification()
	{
	  List<NotificationDto> allnotifications =	this.notifiservice.getAllNotifi();
	  return new ResponseEntity<List<NotificationDto>>(allnotifications,HttpStatus.OK);
	}
	
	@DeleteMapping("/notification/delete/{Id}")
	ResponseEntity<ApiResponse> deleteNotification(@RequestBody @PathVariable long Id)
	{
		this.notifiservice.deleteNotifi(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Notification Deleted Successfully..",true),HttpStatus.OK);
	}
	
	
	
}
