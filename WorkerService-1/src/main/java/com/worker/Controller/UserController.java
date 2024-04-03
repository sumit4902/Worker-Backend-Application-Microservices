package com.worker.Controller;

import java.util.List;

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
import com.worker.Payload.UserDao;
import com.worker.Services.UserService;

@RestController
@RequestMapping("/api/service1")
public class UserController {
	
  @Autowired
  private UserService userservice;
  
  @PostMapping("/User/Create")
  ResponseEntity<UserDao> createUser( @RequestBody UserDao userdao)
  {
	 UserDao user = this.userservice.createUser(userdao);
	 return new ResponseEntity<UserDao>(user,HttpStatus.CREATED);
  }
  
  @PutMapping("/User/Update/{Id}")
  ResponseEntity<UserDao> UpdateUser(@RequestBody UserDao userdao,@PathVariable long Id)
  {
	 UserDao updateduser = this.userservice.updateUser(userdao, Id);
	 return new ResponseEntity<UserDao>(updateduser,HttpStatus.OK);
  }
  
  @GetMapping("/User/{Id}")
  ResponseEntity<UserDao> getUserById(@RequestBody @PathVariable long Id)
  {
	 UserDao user = this.userservice.getUserById(Id);
	 return new ResponseEntity<UserDao>(user,HttpStatus.OK);
  }
  
  @GetMapping("/User/All")
  ResponseEntity<List<UserDao>> GetAllUser()
  {
	 List<UserDao> users = this.userservice.getAllUser();
	 return new ResponseEntity<List<UserDao>>(users,HttpStatus.OK);
  }
  @DeleteMapping("/User/Delete/{Id}")
  ResponseEntity<ApiResponse> deleteUser(@RequestBody @PathVariable long Id)
  {
	  this.userservice.deleteUser(Id);
	  return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully..",true),HttpStatus.OK);
  }
}
