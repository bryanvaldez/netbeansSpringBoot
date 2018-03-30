package com.rest.persistence.model;
// Generated 30/03/2018 04:43:55 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Grade generated by hbm2java
 */
@Entity
@Table(name="grade"
    ,catalog="test"
)
public class Grade  implements java.io.Serializable {


     private Long idGrade;
     private Enrollmentdetail enrollmentdetail;
     private String gradeName;
     private BigDecimal gradeValue;
     private String userCreated;
     private Date dateCreated;
     private Byte status;

    public Grade() {
    }

    public Grade(Enrollmentdetail enrollmentdetail, String gradeName, BigDecimal gradeValue, String userCreated, Date dateCreated, Byte status) {
       this.enrollmentdetail = enrollmentdetail;
       this.gradeName = gradeName;
       this.gradeValue = gradeValue;
       this.userCreated = userCreated;
       this.dateCreated = dateCreated;
       this.status = status;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idGrade", unique=true, nullable=false)
    public Long getIdGrade() {
        return this.idGrade;
    }
    
    public void setIdGrade(Long idGrade) {
        this.idGrade = idGrade;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idEnrollmentDetail")
    public Enrollmentdetail getEnrollmentdetail() {
        return this.enrollmentdetail;
    }
    
    public void setEnrollmentdetail(Enrollmentdetail enrollmentdetail) {
        this.enrollmentdetail = enrollmentdetail;
    }

    
    @Column(name="gradeName", length=30)
    public String getGradeName() {
        return this.gradeName;
    }
    
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    
    @Column(name="gradeValue", precision=4)
    public BigDecimal getGradeValue() {
        return this.gradeValue;
    }
    
    public void setGradeValue(BigDecimal gradeValue) {
        this.gradeValue = gradeValue;
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




}


