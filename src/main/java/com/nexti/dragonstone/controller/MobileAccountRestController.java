/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexti.dragonstone.controller;

import com.nexti.dragonstone.dto.DgMobileDto;
import com.nexti.dragonstone.entity.DgMobile;
import com.nexti.dragonstone.model.DgMobileModel;
import com.nexti.dragonstone.repository.DgMobileRepository;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 *
 * @author ISCesar
 */
@RestController
@RequestMapping(path = "/mobileAccount", produces = APPLICATION_JSON_VALUE)
public class MobileAccountRestController {
    
    private final DgMobileRepository dgMobileRepository;

    public MobileAccountRestController(DgMobileRepository dgMobileRepository) {
        this.dgMobileRepository = dgMobileRepository;
    }
    
    @RequestMapping(method = GET)
    public List<DgMobileDto> list() {
        ArrayList<DgMobile> dgMobileEntityList = (ArrayList<DgMobile>) this.dgMobileRepository.findAll();
        ArrayList<DgMobileDto> dgMobileDtoList = new ArrayList<>();
        try{
            DgMobileModel.copyFromEntityToDto(dgMobileEntityList, dgMobileDtoList);
        }catch(Exception e){
            e.printStackTrace();
        }
        return dgMobileDtoList;
    }
    
    @RequestMapping(value = "/{id}", method = GET)
    public Object get(@PathVariable int id) {
        DgMobileDto dgMobileDto = null;
        try{
            DgMobile dgMobile = this.dgMobileRepository.findByIdMobile(id);
            DgMobileModel dgMobileModel = new DgMobileModel(dgMobile);
            dgMobileDto = dgMobileModel.getDgMobileDto();
        }catch(Exception e){
            e.printStackTrace();
        }
        return dgMobileDto;
    }
    
    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @RequestMapping(value = "/{id}", method = POST)
    public ResponseEntity<?> post(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<Object> delete(@PathVariable String id) {
        return null;
    }
    
}
