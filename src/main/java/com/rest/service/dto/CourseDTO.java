/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.service.dto;

/**
 *
 * @author User
 */
public class CourseDTO {
    private Long idCourse;
    private String courseName;
    private String description;
    private String prerequisite;
    private Short numberOfHours;
    private String courseCode;
    private String courseType;

    public CourseDTO() {
    }

    public CourseDTO(Long idCourse, String courseName, String description, String prerequisite, Short numberOfHours, String courseCode, String courseType) {
        this.idCourse = idCourse;
        this.courseName = courseName;
        this.description = description;
        this.prerequisite = prerequisite;
        this.numberOfHours = numberOfHours;
        this.courseCode = courseCode;
        this.courseType = courseType;
    }    
    
    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public Short getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(Short numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    
}
