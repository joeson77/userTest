package org.demo.service;

import java.util.List;

import org.demo.entity.User;
import org.demo.entity.Users;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
	
	public int insertUser(User user);
	
	public List<User> getAllUser();
	
	public List<Users> getAllUsers();
	
	public int updateUserPwd(User user);
	
	public int updateUsersPwd(Users users);
	
	public String uniteUpdate(User user,Users users) throws Exception;
	
}
