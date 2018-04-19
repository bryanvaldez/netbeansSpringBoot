/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.config.security;

import com.rest.persistence.model.User;
import com.rest.persistence.repository.rest.UserRestRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author bvaldez
 */
@Service("customUserDetailsService")
public class CustomUserDetailService implements UserDetailsService{
    
    @Autowired
    private UserRestRepository userRestRepository;      

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User usuario  = userRestRepository.findByUser(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }        
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();  
        roles.add(new SimpleGrantedAuthority(usuario.getGroup().getName()));
        return new org.springframework.security.core.userdetails.User(usuario.getUser(), usuario.getPassword(), roles);           
    }
    
}
