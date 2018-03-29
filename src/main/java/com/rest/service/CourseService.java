/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.service;

import com.rest.persistence.model.Course;
import com.rest.service.dto.CourseDTO;
import java.util.List;

/**
 *
 * @author Bryan Valdez Jara <Bryan at bryanvaldez.com>
 */
public interface CourseService {
    
    void saveCourse(Course course);    
    List<CourseDTO> findAllCourse();
    void deleteCourse(Long idCourse);
}
