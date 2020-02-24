package com.projm.rmsapi.services;

import java.util.List;

import com.projm.rmsapi.entities.Admin;
import com.projm.rmsapi.repositories.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRepository adminRepo;



    public boolean checkCredentials(String username, String password){


        Admin checkAdmin = adminRepo.findByUsername(username);
        if(checkAdmin==null)
            return false;

        if(checkAdmin.getPassword().equals(username))
            return true;

        return false;
    }

    }

