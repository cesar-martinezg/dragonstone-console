/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexti.dragonstone.temptest;

import com.nexti.dragonstone.dto.DgMobileDto;
import com.nexti.dragonstone.entity.DgMobile;
import com.nexti.dragonstone.entity.DgMobileControl;
import com.nexti.dragonstone.model.DgMobileModel;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ISCesar
 */
public class MiscTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        MiscTest test = new MiscTest();
        test.testCopyPropertiesFromListToAnother();
    }
    
    private void testCopyPropertiesFromListToAnother() throws Exception{
        DgMobileModel.EntityList entityList = new DgMobileModel.EntityList();
        DgMobileModel.DtoList dtoList = new DgMobileModel.DtoList();
        
        DgMobile entity = new DgMobile(1, "123", "test", new Date(), 1);
        DgMobileControl subEntity = new DgMobileControl(1, true, false, true, false, 3, new Date(), 1);
        subEntity.setAppsList("ab,c,d");
        entity.setDgMobileControl(subEntity);
        entityList.add(entity);
        
        DgMobileModel.copyFromEntityToDto(entityList, dtoList);
        
        
        System.out.println(entityList.toString());
        System.out.println(subEntity.toString());
        System.out.println(dtoList.toString());
        
    }
    
}
