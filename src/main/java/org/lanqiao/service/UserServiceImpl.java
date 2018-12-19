package org.lanqiao.service;

import java.sql.SQLDataException;
import java.util.List;

import javax.annotation.Resource;

import org.lanqiao.dao.UserMapper;
import org.lanqiao.entity.User;
import org.lanqiao.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

//@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userDao;
	@Autowired
    private PlatformTransactionManager platformTransactionManager; 
	
	public int insertUser(User user) {
		return userDao.insert(user);
	}

	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	public List<Users> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	public int updateUserPwd(User user) {
		return userDao.updateUserPwd(user);
	}
	
	public int updateUsersPwd(Users users) {
		return userDao.updateUsersPwd(users);
	}
	
	
	//手动提交事务
	public String uniteUpdate(User user, Users users) throws Exception {
		
		//关闭事务自动提交  
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();  
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);  
        TransactionStatus status = platformTransactionManager.getTransaction(def);
        
		int returnOne = userDao.updateUserPwd(user);
		int returnTwo =  userDao.updateUsersPwd(users);
		if (returnOne != 0 && returnTwo != 0) {
			platformTransactionManager.commit(status);
			return "true";
		} else {
			platformTransactionManager.rollback(status);
			throw new SQLDataException("数据错误不能对表进行update操作。。。。");
		}
	}
	
	
	//自动提交事务
//	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
//	public String uniteUpdate(User user, Users users) throws Exception {
//        
//		int returnOne = userDao.updateUserPwd(user);
//		int returnTwo =  userDao.updateUsersPwd(users);
//		if (returnOne != 0 && returnTwo != 0) {
//			return "true";
//		} else {
//			throw new SQLDataException("数据错误不能对表进行update操作。。。。");
//		}
//	}
	
}
