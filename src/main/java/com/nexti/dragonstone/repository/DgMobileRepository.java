/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexti.dragonstone.repository;

import com.nexti.dragonstone.entity.DgMobile;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author ISCesar
 */
@RepositoryRestResource
public interface DgMobileRepository extends JpaRepository<DgMobile, Integer> {
    
    //single JPA-JPQL query implementation
    DgMobile findByIdMobile(@Param("id") int idMobile);
    
    //single JPA-JPQL query implementation with custom param names
    DgMobile findByImei(@Param("imei") String imei );
    
    //JPA-JPQL implementation for complex or native queries
    @Query(nativeQuery = false, name = "DgMobile.findWhereVersionLessThan")
    List<DgMobile> findWhereVersionLessThan(@Param("version") int version);
    
    //JPA-SQL implementation for complex or native queries
    // with custom param and method names
    //@Query(nativeQuery = true, name = "DgMobile.findWhereVersionGreaterThan")
    //List<DgMobile> findWhereVersionGreaterThan(@Param("version") int version);
    
    List<DgMobile> findByVersionGreaterThan();
}
