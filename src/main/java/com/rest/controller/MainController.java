/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.controller;

import com.rest.persistence.model.Group;
import com.rest.persistence.model.User;
import com.rest.persistence.repository.rest.GroupRestRepository;
import com.rest.persistence.repository.rest.UserRestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author bvaldez
 */
@Controller
public class MainController {
    
    @Autowired
    private UserRestRepository userRestRepository;    
    
    @Autowired
    private GroupRestRepository groupRestRepository;     
    
    
    @GetMapping("/")    
    public String getRoot(){
        return "/main";
    }
    
    @GetMapping("/main")
    public String getMain(){
        return "/main";
    }
    
    @GetMapping("/login")
    public String getLogin(){
        return "/login";
    }    
     
    @GetMapping("/admin")
    public String getAdmin(Model model){ 
        model.addAttribute("usuarios",userRestRepository.findAll());
        model.addAttribute("grupos",groupRestRepository.findAll());
        return "/admin";
    }        
    
    @GetMapping("/usuario")
    public String getUsuario(Model model){
        model.addAttribute("usuarios",userRestRepository.findAll());        
        return "/usuario";
    }   
    
    @GetMapping("/contribuidor")
    public String getContribuidor(Model model){
        model.addAttribute("grupos",groupRestRepository.findAll());        
        return "/contribuidor";
    }      
}
