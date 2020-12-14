/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystoremvc.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
/**
 *
 * @author George.Pasparakis
 */
public class Admin implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        ModelAndView model = new ModelAndView("admin");
        String projectName = (String)request.getAttribute("projectName");
        String username    = (String)request.getAttribute("username");
        model.addObject("projectName",projectName);
        model.addObject("username",username);
        return(model);
    }
    
}
