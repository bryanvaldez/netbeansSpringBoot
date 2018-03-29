/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.persistence.repository;

import com.rest.persistence.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bryan Valdez Jara <Bryan at bryanvaldez.com>
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
