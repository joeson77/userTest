package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.User;
import org.lanqiao.entity.Users;

public interface UserMapper {
	
    int insert(User record);
    
    List<User> getAllUser();
    
    List<Users> getAllUsers();
    
    int updateUserPwd(User user);
    
    int updateUsersPwd(Users users);

}