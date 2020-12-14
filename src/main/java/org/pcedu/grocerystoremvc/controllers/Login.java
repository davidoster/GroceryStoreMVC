/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystoremvc.controllers;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
/**
 *
 * @author George.Pasparakis
 */
public class Login implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
       String message = "";
       ModelAndView model = new ModelAndView("login");
       model.addObject("projectName", "John's Grocery Store");
       model.addObject("method", request.getMethod());
       model.addObject("username", "username");
       model.addObject("password", "password");
       
       // GET
       if(request.getMethod().equals("GET")) {
        model.addObject("action", "login.html");
        model.addObject("message", message);
       }
       
       // POST wrong credentials
       if(request.getMethod().equals("POST") && 
               !request.getParameter("username").equalsIgnoreCase("admin") && 
               !request.getParameter("password").equals("admin")) {
           message = "Wrong credentials, try again!";
           model.addObject("message", message);
       }
       
       // POST correct credentials
       if(request.getMethod().equals("POST") && 
               request.getParameter("username").equalsIgnoreCase("admin") && 
               request.getParameter("password").equals("admin")) {
//           message = "Correct credentials!!!";
//           model.addObject("message", message);
            RequestDispatcher rd =  request.getRequestDispatcher("/admin.html");
            request.setAttribute("projectName", "John's Grocery Store");
            request.setAttribute("username", request.getParameter("username"));
            rd.forward(request, response);
       }
       return(model);
    }
    
}
