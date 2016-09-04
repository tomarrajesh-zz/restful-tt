package com.websystique.springmvc.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.UserDao;
import com.websystique.springmvc.model.User;
 
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    
	@Autowired
	private UserDao userDao; 
	
    private static final AtomicLong counter = new AtomicLong();
    
    private static List<User> users;
     
    static{
        users= populateDummyUsers();
    }
 
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }
     
    public User findById(long id) {
        return userDao.findById((int)id);
    }
     
    public User findByName(String name) {
        return userDao.findUserByName(name);
    }
     
    public void saveUser(User user) {
        //user.setId(counter.incrementAndGet());
        //users.add(user);
        userDao.saveUser(user);
    }
 
    public void updateUser(User user) {
    	userDao.updateUser(user);
    }
 
    public void deleteUserById(long id) {
         
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }
 
    public boolean isUserExist(User user) {
        return findByName(user.getName())!=null;
    }
 
    private static List<User> populateDummyUsers(){
        List<User> users = new ArrayList<User>();
//        counter.incrementAndGet();
//        User
        //users.add(new User());
        
//        counter.incrementAndGet();        
        return users;
    }
 
    public void deleteAllUsers() {
        users.clear();
    }
 
}