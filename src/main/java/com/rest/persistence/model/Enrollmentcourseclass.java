package com.rest.persistence.model;
// Generated 25/03/2018 05:56:17 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Enrollmentcourseclass generated by hbm2java
 */
@Entity
@Table(name="enrollmentcourseclass"
    ,catalog="test"
)
public class Enrollmentcourseclass  implements java.io.Serializable {


     private Long idEnrollmentCourseClass;
     private Enrollmentdetail enrollmentdetail;
     private Long idCourseClass;
     private String userCreated;
     private Date dateCreated;
     private Byte status;
     private Set courseclassattendances = new HashSet(0);

    public Enrollmentcourseclass() {
    }

    public Enrollmentcourseclass(Enrollmentdetail enrollmentdetail, Long idCourseClass, String userCreated, Date dateCreated, Byte status, Set courseclassattendances) {
       this.enrollmentdetail = enrollmentdetail;
       this.idCourseClass = idCourseClass;
       this.userCreated = userCreated;
       this.dateCreated = dateCreated;
       this.status = status;
       this.courseclassattendances = courseclassattendances;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idEnrollmentCourseClass", unique=true, nullable=false)
    public Long getIdEnrollmentCourseClass() {
        return this.idEnrollmentCourseClass;
    }
    
    public void setIdEnrollmentCourseClass(Long idEnrollmentCourseClass) {
        this.idEnrollmentCourseClass = idEnrollmentCourseClass;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idEnrollmentDetail")
    public Enrollmentdetail getEnrollmentdetail() {
        return this.enrollmentdetail;
    }
    
    public void setEnrollmentdetail(Enrollmentdetail enrollmentdetail) {
        this.enrollmentdetail = enrollmentdetail;
    }

    
    @Column(name="idCourseClass")
    public Long getIdCourseClass() {
        return this.idCourseClass;
    }
    
    public void setIdCourseClass(Long idCourseClass) {
        this.idCourseClass = idCourseClass;
    }

    
    @Column(name="userCreated", length=100)
    public String getUserCreated() {
        return this.userCreated;
    }
    
    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dateCreated", length=19)
    public Date getDateCreated() {
        return this.dateCreated;
    }
    
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    
    @Column(name="status")
    public Byte getStatus() {
        return this.status;
    }
    
    public void setStatus(Byte status) {
        this.status = status;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="enrollmentcourseclass")
    public Set getCourseclassattendances() {
        return this.courseclassattendances;
    }
    
    public void setCourseclassattendances(Set courseclassattendances) {
        this.courseclassattendances = courseclassattendances;
    }




}


