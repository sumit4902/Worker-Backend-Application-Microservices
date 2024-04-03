package com.worker.Services;

import java.util.List;

import com.worker.Payload.NotificationDto;

public interface NotificationService {

	NotificationDto createNotifi (NotificationDto notifidto,long userId );
	List<NotificationDto>getNotificationByUserId(long userId);
	NotificationDto updateNotifi (NotificationDto notifidto , long Id);
	NotificationDto getById (long Id);
	List<NotificationDto> getAllNotifi();
	void deleteNotifi(long Id);
}
