/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.service.impl;

import com.rest.persistence.model.Course;
import com.rest.persistence.repository.CourseRepository;
import com.rest.service.CourseService;
import com.rest.service.dto.CourseDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bryan Valdez Jara <Bryan at bryanvaldez.com>
 */
@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;
    
    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public List<CourseDTO> findAllCourse() {
        
        List<Course> courseList = courseRepository.findAll();
        List<CourseDTO> courseDTOList = new ArrayList<>();
        for (Course course : courseList) {                   
            courseDTOList.add(
                new CourseDTO(
                    course.getIdCourse(),
                    course.getCourseName(),
                    course.getDescription(),
                    course.getPrerequisite(),
                    course.getNumberOfHours(),
                    course.getCourseCode(),
                ""));
        }        
        return courseDTOList;
        
//        return courseRepository.findAll().stream().map(course -> 
//                new CourseDTO(
//                course.getIdCourse(),
//                course.getCourseName(),
//                course.getDescription(),
//                course.getPrerequisite(),
//                course.getNumberOfHours(),
//                course.getCourseCode(),
//                "")).collect(Collectors.toList());
    }

    @Override
    public void deleteCourse(Long idCourse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
