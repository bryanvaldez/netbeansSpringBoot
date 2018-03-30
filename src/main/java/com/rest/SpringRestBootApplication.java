/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author Bryan Valdez Jara <Bryan at bryanvaldez.com>
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.rest")
public class SpringRestBootApplication {
    
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringRestBootApplication.class);
        application.run();        
    }
    
}
