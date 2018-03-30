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
public enum StatusEnum {
    ACTIVE(1),
    INACTIVE(2);
    
    private int value;
    
    StatusEnum(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}
