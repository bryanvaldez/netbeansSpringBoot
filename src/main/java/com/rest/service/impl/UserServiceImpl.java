/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.service.impl;

import com.rest.persistence.model.User;
import com.rest.persistence.repository.UserRepository;
import com.rest.service.UserService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

///**
// *
// * @author bvaldez
// */
//@Service("userService")
//@Transactional
//public class UserServiceImpl implements UserService{
//    
//    @Autowired
//    private UserRepository userRepository;    
//
//    @Override
//    public User findById(Long id) {
//        return userRepository.findOne(id); 
//    }
//
//    @Override
//    public User findByUser(String user) {
//        return userRepository.findByUser(user);
//    }
//
//    @Override
//    public void saveUser(User user) {
//        userRepository.save(user);
//    }
//
//    @Override
//    public void updateUser(User user) {
//        saveUser(user);
//    }
//
//    @Override
//    public void deleteUserById(Long id) {
//        userRepository.delete(id);
//    }
//
//    @Override
//    public List<User> findAllUsers() {
//        return userRepository.findAll();
//    }
//    
//}
