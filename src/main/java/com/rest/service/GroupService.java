/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.service;

import com.rest.persistence.model.Group;
import java.util.List;

/**
 *
 * @author bvaldez
 */
public interface GroupService {
    Group findById(Long id);         
    void saveGroup(Group group);
    void updateGroup(Group group);
    void deleteGroupById(Long id);   
    List<Group> findAllGroups();        
}
