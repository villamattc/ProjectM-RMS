package com.projm.rmsapi.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.projm.rmsapi.entities.Admin;
import com.projm.rmsapi.repositories.AdminRepository;
import com.projm.rmsapi.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@ControllerAdvice
public class AdminController {


    @Autowired
    AdminRepository adminRepo;

    @Autowired
    AdminService adminService;

    @RequestMapping(value="/createadmin", method = RequestMethod.POST)
    public ResponseEntity<Object> createAdmin(@Valid @ModelAttribute("admin") Admin admin, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("ADMIN CREATION FAILED", HttpStatus.FORBIDDEN);
        }
        adminRepo.save(admin);

        return new ResponseEntity<>("ADMIN CREATION SUCCESS", HttpStatus.CREATED);

    }

    //needs work... fml
    @RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
    public ModelAndView LoginAsAdmin(@RequestParam("username") String username, 
        @RequestParam("password") String password ,HttpServletRequest request) {
        //@SuppressWarnings("unchecked")
         Admin admin = adminRepo.findByUsername(username);
         if(admin == null){
            System.out.println("User does not exist");
            return new ModelAndView("test/testlogin");
         }

        if(adminService.checkCredentials(username, password)){
            request.getSession().setAttribute("userSession", admin.getUsername());
            
            System.out.println("LOGIN SUCESSFUL");
            // set this to whatever home page
            return new ModelAndView("redirect:/testindex"); // "redirect:/redirectedUrl"

        }
    
        // add error here

        //set this back to login page
        System.out.println("WRONG PASSWORD");
        return new ModelAndView("redirect:/testlogin");

    }

        // not complete... just to add admin to a the database
        @RequestMapping(value = "/testcreateAdmin", method = RequestMethod.POST)
        public ModelAndView adminregister(@RequestParam String username, @RequestParam String password) {
    
            Admin admin = new Admin(username,password);
            adminRepo.save(admin);
    
            return new ModelAndView("testlogin"); 
        }
    
        @RequestMapping(value = "/destorysession", method = RequestMethod.POST)
        public void destroySession(HttpServletRequest request) {
            request.getSession().invalidate();
        }
        

    

    }