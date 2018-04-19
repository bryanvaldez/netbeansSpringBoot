/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.persistence.repository.rest;

import com.rest.persistence.model.Grade;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author bvaldez
 */
@RepositoryRestResource(collectionResourceRel = "grade", path = "grade")
public interface GradeRestRepository extends PagingAndSortingRepository<Grade, Integer>{
    
}
