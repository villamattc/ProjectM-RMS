package com.projm.rmsapi.controllers;

import com.projm.rmsapi.repositories.RoomRepository;
import com.projm.rmsapi.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController{

    @Autowired
    private  RoomService rs;
    @Autowired
    private RoomRepository roomRepo;

    // test view for pure testing random shit
    @RequestMapping(value = "index")
    public String testJsp(ModelMap map){
        map.addAttribute("roomlist", roomRepo.findAll());
        return "index";
    }
    // test view for pure testing random shit
    @RequestMapping(value = "room")
    public String testJsp1(ModelMap map){
        map.addAttribute("roomlist", roomRepo.findAll());
        return "room";
    }


}
