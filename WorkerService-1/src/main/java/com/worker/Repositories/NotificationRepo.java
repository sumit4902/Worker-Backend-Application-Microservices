package com.worker.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worker.Entities.Notification;
import com.worker.Entities.User;

public interface NotificationRepo extends JpaRepository<Notification, Long>{

	List<Notification>findByUser(User user);
}
