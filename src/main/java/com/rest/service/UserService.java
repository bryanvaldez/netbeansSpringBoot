/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.service;

import com.rest.persistence.model.User;
import java.util.List;

/**
 *
 * @author bvaldez
 */
public interface UserService {
    User findById(Long id);      
    User findByUser(String user);      
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);   
    List<User> findAllUsers();    
}
