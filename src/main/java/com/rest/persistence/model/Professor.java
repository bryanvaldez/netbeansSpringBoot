package com.rest.persistence.model;
// Generated 30/03/2018 04:43:55 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Professor generated by hbm2java
 */
@Entity
@Table(name="professor"
    ,catalog="test"
)
public class Professor  implements java.io.Serializable {


     private Long idProfessor;
     private String firstName;
     private String lastName;
     private Short gender;
     private Short hireType;
     private Date birthDate;
     private String emailAddress;
     private String userCreated;
     private Date dateCreated;
     private Byte status;
     private Set<Enrollmentdetail> enrollmentdetails = new HashSet<Enrollmentdetail>(0);

    public Professor() {
    }

    public Professor(String firstName, String lastName, Short gender, Short hireType, Date birthDate, String emailAddress, String userCreated, Date dateCreated, Byte status, Set<Enrollmentdetail> enrollmentdetails) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.gender = gender;
       this.hireType = hireType;
       this.birthDate = birthDate;
       this.emailAddress = emailAddress;
       this.userCreated = userCreated;
       this.dateCreated = dateCreated;
       this.status = status;
       this.enrollmentdetails = enrollmentdetails;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idProfessor", unique=true, nullable=false)
    public Long getIdProfessor() {
        return this.idProfessor;
    }
    
    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    
    @Column(name="firstName", length=100)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="lastName", length=100)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="gender")
    public Short getGender() {
        return this.gender;
    }
    
    public void setGender(Short gender) {
        this.gender = gender;
    }

    
    @Column(name="hireType")
    public Short getHireType() {
        return this.hireType;
    }
    
    public void setHireType(Short hireType) {
        this.hireType = hireType;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="birthDate", length=19)
    public Date getBirthDate() {
        return this.birthDate;
    }
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    
    @Column(name="emailAddress", length=100)
    public String getEmailAddress() {
        return this.emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="professor")
    public Set<Enrollmentdetail> getEnrollmentdetails() {
        return this.enrollmentdetails;
    }
    
    public void setEnrollmentdetails(Set<Enrollmentdetail> enrollmentdetails) {
        this.enrollmentdetails = enrollmentdetails;
    }




}


