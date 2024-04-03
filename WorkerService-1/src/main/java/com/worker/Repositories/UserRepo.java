package com.worker.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.worker.Entities.User;

public interface UserRepo extends JpaRepository<User, Long> {   //Entity ,Wrapper Class Id

	// custom finder methods //
}
