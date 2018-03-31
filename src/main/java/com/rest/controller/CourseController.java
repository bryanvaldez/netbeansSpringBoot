/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.controller;

import com.rest.controller.message.CourseMessageResponse;
import com.rest.persistence.model.Course;
import com.rest.service.CourseService;
import com.rest.service.dto.CourseDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @PostMapping(value="/saveCourse", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
    
    @GetMapping(value = "/findAllCourses", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CourseDTO> findAllCourses(){
        return courseService.findAllCourse();  
    }
    
    @DeleteMapping(value = "/deleteCourse/{idCourse}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CourseMessageResponse deleteCourse(@PathVariable Long idCourse){ 
        CourseMessageResponse message = new CourseMessageResponse(); 
        try {
            courseService.deleteCourse(idCourse);
            message.setCode(1);
            message.setMessage("successfully");
        } catch (Exception e) {
            message.setCode(-1);
            message.setMessage("There was as error");
            message.setError(e.getMessage());
        }
        return message;         
    }
}
