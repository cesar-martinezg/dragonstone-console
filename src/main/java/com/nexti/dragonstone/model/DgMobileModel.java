/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexti.dragonstone.model;

import com.nexti.dragonstone.dto.DgMobileDto;
import com.nexti.dragonstone.entity.DgMobile;
import com.nexti.dragonstone.entity.DgMobileControl;
import com.nexti.dragonstone.util.ReflectionUtils;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author ISCesar
 */
public class DgMobileModel {
    
    private final DgMobile dgMobile;
    private DgMobileDto dgMobileDto;

    public DgMobileModel(DgMobile dgMobile) {
        this.dgMobile = dgMobile;
    }
    
    public DgMobile getDgMobile() {
        return dgMobile;
    }

    public DgMobileDto getDgMobileDto() {
        if (dgMobileDto==null){
            dgMobileDto = new DgMobileDto();
            BeanUtils.copyProperties(dgMobile, dgMobileDto);
        }
        return dgMobileDto;
    }

    public void setDgMobileDto(DgMobileDto dgMobileDto) {
        this.dgMobileDto = dgMobileDto;
    }    
    
    public static void copyFromEntityToDto(ArrayList entityList, ArrayList dtoList) throws Exception{
        // copies the values of Top Entity
        ReflectionUtils.copyObjectAListToObjectBList(entityList, dtoList, DgMobileDto.class);
        // copies the values of sub Entity (one to one)
        int i = 0;
        for (Object entity : entityList){
            BeanUtils.copyProperties(((DgMobile)entity).getDgMobileControl(), dtoList.get(i));
            i++;
        }
    }
    
    // -------- Static Class for Lists ------- //
    public static class EntityList extends ArrayList<DgMobile> {    
    }
    
    public static class DtoList extends ArrayList<DgMobileDto> {    
    }
    
    protected static class DgMobileControlList extends ArrayList<DgMobileControl> {    
    }
    
}
