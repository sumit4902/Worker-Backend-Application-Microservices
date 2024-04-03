package com.worker.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worker.Entities.Friend;
import com.worker.Entities.User;

public interface FriendRepo extends JpaRepository<Friend, Long> {
  // custom methods//
	List<Friend> findByUser(User user);
}
