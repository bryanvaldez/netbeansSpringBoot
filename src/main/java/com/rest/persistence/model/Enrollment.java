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
 * Enrollment generated by hbm2java
 */
@Entity
@Table(name="enrollment"
    ,catalog="test"
)
public class Enrollment  implements java.io.Serializable {


     private Long idEnrollment;
     private Semester semester;
     private Service service;
     private Student student;
     private String userCreated;
     private Date dateCreated;
     private Byte status;
     private Set enrollmentdetails = new HashSet(0);

    public Enrollment() {
    }

    public Enrollment(Semester semester, Service service, Student student, String userCreated, Date dateCreated, Byte status, Set enrollmentdetails) {
       this.semester = semester;
       this.service = service;
       this.student = student;
       this.userCreated = userCreated;
       this.dateCreated = dateCreated;
       this.status = status;
       this.enrollmentdetails = enrollmentdetails;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idEnrollment", unique=true, nullable=false)
    public Long getIdEnrollment() {
        return this.idEnrollment;
    }
    
    public void setIdEnrollment(Long idEnrollment) {
        this.idEnrollment = idEnrollment;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idSemester")
    public Semester getSemester() {
        return this.semester;
    }
    
    public void setSemester(Semester semester) {
        this.semester = semester;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idService")
    public Service getService() {
        return this.service;
    }
    
    public void setService(Service service) {
        this.service = service;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idStudent")
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }

    
    @Column(name="userCreated", length=45)
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="enrollment")
    public Set getEnrollmentdetails() {
        return this.enrollmentdetails;
    }
    
    public void setEnrollmentdetails(Set enrollmentdetails) {
        this.enrollmentdetails = enrollmentdetails;
    }




}


