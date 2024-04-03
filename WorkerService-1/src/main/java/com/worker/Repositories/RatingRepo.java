package com.worker.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worker.Entities.Rating;
import com.worker.Entities.User;

public interface RatingRepo extends JpaRepository<Rating, Long> {

	List<Rating>findByUser(User user);
}
