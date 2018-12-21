package org.demo.dao;

import java.util.List;

import org.demo.entity.User;
import org.demo.entity.Users;

public interface UserMapper {
	
    int insert(User record);
    
    List<User> getAllUser();
    
    List<Users> getAllUsers();
    
    int updateUserPwd(User user);
    
    int updateUsersPwd(Users users);

}