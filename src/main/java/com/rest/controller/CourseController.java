/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.controller;

import com.rest.controller.message.CourseMessageResponse;
import com.rest.persistence.model.Course;
import com.rest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bryan Valdez Jara <Bryan at bryanvaldez.com>
 */
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    
    @PostMapping(name="/saveCourse", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CourseMessageResponse saveCourse(@RequestBody Course course){
        CourseMessageResponse message = new CourseMessageResponse();
        try {
            courseService.saveCourse(course);
            message.setCode(1);
            message.setMessage("The course was saved successfully");
        } catch (Exception e) {
            message.setCode(-1);
            message.setMessage("There was as error");
            message.setError(e.getMessage());
        }
        return message;        
    }
}
