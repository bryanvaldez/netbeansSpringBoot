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
import com.rest.service.enums.CourseTypeEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
            CourseTypeEnum ct = null;
            for (CourseTypeEnum en : CourseTypeEnum.values()) {
                if(en.getValue() == course.getCourseType().intValue()){
                    ct = en;
                }
            }            
            courseDTOList.add(
                new CourseDTO(
                    course.getIdCourse(),
                    course.getCourseName(),
                    course.getDescription(),
                    course.getPrerequisite(),
                    course.getNumberOfHours(),
                    course.getCourseCode(),
                    ct.toString()
                )
            );
        }        
        return courseDTOList;
        
    }

    @Override
    public void deleteCourse(Long idCourse) {
        Course course = new Course();
        course.setIdCourse(idCourse);
        courseRepository.delete(course);
    }
    
}
