/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexti.dragonstone.repository;

import com.nexti.dragonstone.entity.DgMobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author ISCesar
 */
@RepositoryRestResource
public interface DgMobileRepository extends JpaRepository<DgMobile, Integer> {
    
}
