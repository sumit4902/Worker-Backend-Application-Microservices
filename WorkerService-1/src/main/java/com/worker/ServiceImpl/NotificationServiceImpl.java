package com.worker.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worker.Entities.Notification;
import com.worker.Entities.User;
import com.worker.Payload.NotificationDto;
import com.worker.Repositories.NotificationRepo;
import com.worker.Repositories.UserRepo;
import com.worker.Services.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationRepo notifirepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private UserRepo userrepo;
	
	@Override
	public NotificationDto createNotifi(NotificationDto notifidto,long userId) {
		
		User user = this.userrepo.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found"));
		
		Notification notifi = this.modelmapper.map(notifidto, Notification.class);
		notifi.setUser(user);
		notifi.setDate(new Date());
		notifi.setRead(false);
		Notification savedNotifi = this.notifirepo.save(notifi);
		
		return this.modelmapper.map(savedNotifi,NotificationDto.class);
	}
	// get Notification By userId
	@Override
	public List<NotificationDto> getNotificationByUserId(long userId) {
         User user = this.userrepo.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found"));
         List<Notification> allnotification = this.notifirepo.findByUser(user);
 		List<NotificationDto> convertednotifi = allnotification.stream().map(notifi->this.modelmapper.map(notifi,NotificationDto.class)).collect(Collectors.toList());
 		return convertednotifi;
	}

	@Override
	public NotificationDto updateNotifi(NotificationDto notifidto, long Id) {
	     
		  Notification notify = this.notifirepo.findById(Id).orElseThrow(()->new RuntimeException("Notification Not Found"));
		
		  notify.setMessage(notifidto.getMessage());
		  notify.setRead(notifidto.isRead());
		  Notification savednotify = this.notifirepo.save(notify);
		  
		
		return this.modelmapper.map(savednotify, NotificationDto.class);
	}

	@Override
	public NotificationDto getById(long Id) {
		 Notification notify = this.notifirepo.findById(Id).orElseThrow(()->new RuntimeException("Notification Not Found"));
		return this.modelmapper.map(notify, NotificationDto.class);
	}

	@Override
	public List<NotificationDto> getAllNotifi() {
		List<Notification> allnotification = this.notifirepo.findAll();
		List<NotificationDto> convertednotifi = allnotification.stream().map(notifi->this.modelmapper.map(notifi,NotificationDto.class)).collect(Collectors.toList());
		return convertednotifi;
	}

	@Override
	public void deleteNotifi(long Id) {
		this.notifirepo.deleteById(Id);
		}

	

}
