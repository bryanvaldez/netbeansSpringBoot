/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.controller;

import com.rest.controller.resource.CourseResource;
import com.rest.persistence.model.Course;
import com.rest.persistence.repository.CourseRepository;
import com.rest.service.enums.CourseTypeEnum;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Bryan Valdez Jara <Bryan at bryanvaldez.com>
 */
@Controller
@RequestMapping("/hateoas")
public class ControllerHateoas {

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(value = "/findAllCourses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public HttpEntity<List<CourseResource>> findAllCourses() { 
        
        List<Course> courseList = courseRepository.findAll();
        List<CourseResource> courseResourceList = new ArrayList<>();
        for (Course course : courseList) {
            CourseTypeEnum ct = null;
            for (CourseTypeEnum en : CourseTypeEnum.values()) {
                if (en.getValue() == course.getCourseType().intValue()) {
                    ct = en;
                }
            }

            CourseResource resource = new CourseResource(
                    course.getIdCourse(),
                    course.getCourseName(),
                    course.getDescription(),
                    course.getPrerequisite(),
                    course.getNumberOfHours(),
                    course.getCourseCode(),
                    ct.toString()
            );
            methodOn(CourseController.class).deleteCourse(Long.valueOf(0));
            resource.add(linkTo(methodOn(CourseController.class).deleteCourse(Long.valueOf(0))).withSelfRel());

            
            courseResourceList.add(resource);
        }
        
        return new ResponseEntity<>(courseResourceList,HttpStatus.OK);
    }

}
