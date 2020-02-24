package com.projm.rmsapi.services;

import java.util.List;

import com.projm.rmsapi.entities.Admin;


public interface AdminService{

    public abstract boolean checkCredentials(String username, String password);

}