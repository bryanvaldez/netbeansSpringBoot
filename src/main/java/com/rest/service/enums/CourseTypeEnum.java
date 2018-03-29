/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.service.enums;

/**
 *
 * @author Bryan Valdez Jara <Bryan at bryanvaldez.com>
 */
public enum CourseTypeEnum {
    GESTION(1),
    SOFTWARE(2),
    OFIMATICA(3),
    PROCESOS(4);
    
    private int value;
    
    CourseTypeEnum(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}
