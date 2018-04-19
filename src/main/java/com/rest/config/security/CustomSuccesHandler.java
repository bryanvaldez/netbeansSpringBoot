/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.config.security;

import com.rest.persistence.model.User;
import com.rest.persistence.repository.rest.UserRestRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author bvaldez
 */
@Component 
public class CustomSuccesHandler extends SimpleUrlAuthenticationSuccessHandler{
    
    private RedirectStrategy redirectStrategy  = new DefaultRedirectStrategy();
    
    @Autowired
    private UserRestRepository userRestRepository;    
    
    @Override 
    protected void handle(HttpServletRequest request, 
                          HttpServletResponse response,
                          Authentication authentication) throws IOException, ServletException{
        
        String targetUrl = determineTargetUrl(authentication);
        
        if(response.isCommitted()){
            System.out.println("No se puede redireccionar");
            return;
        }
        User usuario = userRestRepository.findByUser(authentication.getName());
        request.getSession().setAttribute("USUARIO", usuario.getUser());
        request.getSession().setAttribute("GRUPO", usuario.getGroup().getId());        

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }       
    
    protected String determineTargetUrl(Authentication authentication){
        String url = "";
        Collection<? extends GrantedAuthority> authorities  = authentication.getAuthorities();
            List<String> roles = new ArrayList<String>();
            for(GrantedAuthority a : authorities){
                roles.add(a.getAuthority());
            }
            if(isObserver(roles)){
                url = "/contribuidor";
            } else if (isAdmin(roles)){
                url = "/admin";
            } else if(isUser(roles)){
                url = "/usuario";
            } else{
                url = "/accessDenied";
            }
        return url;
    } 

    private boolean isUser(List<String> roles){
        if(roles.contains("ROLE_USER")){
            return true;
        }
        return false;
    }  
    private boolean isAdmin(List<String> roles){
        if(roles.contains("ROLE_ADMIN")){
            return true;
        }
        return false;
    }
    private boolean isObserver(List<String> roles){
        if(roles.contains("ROLE_CONTRIB")){
            return true;
        }
        return false;
    }        
    
    public void setRedirectStrategy(RedirectStrategy redirectStrategy){
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy(){
        return redirectStrategy;
    }     
    
}
