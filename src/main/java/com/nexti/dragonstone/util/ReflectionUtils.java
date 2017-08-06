/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexti.dragonstone.util;

import java.util.ArrayList;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author ISCesar
 */
public class ReflectionUtils {
    
    public static void copyObjectAListToObjectBList(ArrayList objectAList, ArrayList objectBList, Class objectBClass) throws Exception{
        if (objectAList!=null){
            if (objectBList==null)
                objectBList = new ArrayList<>();
            for (Object objectA :  objectAList){
                Object objectB = objectBClass.newInstance() ;
                BeanUtils.copyProperties(objectA, objectB);
                objectBList.add(objectB);
            }
        }else{
            throw new Exception("Nothing to copy. Source Object List is null.");
        }
    }
    
}
