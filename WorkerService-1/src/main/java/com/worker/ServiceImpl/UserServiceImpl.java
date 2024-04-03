package com.worker.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worker.Entities.User;
import com.worker.Payload.UserDao;
import com.worker.Repositories.UserRepo;
import com.worker.Services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private WorkerClient workerclient;
	
	@Override
	public UserDao createUser(UserDao userdao) {
		User user= this.modelmapper.map(userdao, User.class);
		User saveduser = this.userrepo.save(user);		
		return this.modelmapper.map(saveduser, UserDao.class);
	}

	@Override
	public UserDao updateUser(UserDao userdao, long Id) {
		User user = this.userrepo.findById(Id).orElseThrow(()-> new RuntimeException("User Not Found"));
		user.setName(userdao.getName());
		user.setPassword(userdao.getPassword());
		user.setEmail(userdao.getEmail());
		user.setAddress(userdao.getAddress());
		user.setContact(userdao.getContact());
        User saved =this.userrepo.save(user);
		return this.modelmapper.map(saved, UserDao.class);
	}

	@Override
	public UserDao getUserById(long Id) {
		// TODO Auto-generated method stub
		User user = this.userrepo.findById(Id).orElseThrow(()-> new RuntimeException("User not Found"));
		UserDao userdao = this.modelmapper.map(user, UserDao.class);
		try {
			userdao.setWorker(this.workerclient.getWorkerByUserId(userdao.getUserId()));
		}
	  	catch (Exception e) {
			System.out.println("worker not found from workerservice two" + e);
		}
		
		
	  	return userdao;
	}

	@Override
	public List<UserDao> getAllUser() {
		List<User> users = this.userrepo.findAll();
		
		List<UserDao> convertedUsers = users.stream()
			    .map(user -> {
			        UserDao userDao = this.modelmapper.map(user, UserDao.class);
			       try {
			    	   
    			        userDao.setWorker(this.workerclient.getWorkerByUserId(user.getUserId()));
			       }
			       catch (Exception e) {
					System.out.println("Worker Not Found from workerService Two " + e);
				}
			        return userDao;
			    })
			    .collect(Collectors.toList());
		
       // List<UserDao> newuserlist =  convertedusers.stream().map(user->{user.setWorker(this.workerclient.getWorkerByUserId(user.getUserId()));
       // return user;}).collect(Collectors.toList());
        
		return convertedUsers;
	}
	

	@Override
	public void deleteUser(long Id) {
		
		this.userrepo.deleteById(Id);
	}

}
