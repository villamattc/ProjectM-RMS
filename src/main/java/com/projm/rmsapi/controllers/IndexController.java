package com.projm.rmsapi.controllers;

import com.projm.rmsapi.entities.Room;
import com.projm.rmsapi.entities.User;
import com.projm.rmsapi.repositories.RoomRepository;
import com.projm.rmsapi.repositories.UserRepository;
import com.projm.rmsapi.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController{

    @Autowired
    private  RoomService roomService;
    @Autowired
    private RoomRepository roomRepo;
    @Autowired
    private UserRepository userRepo;

    @RequestMapping(value = "index")
    public ModelAndView testJsp(ModelMap map){

        map.addAttribute("roomlist", roomRepo.findAll());
        return new ModelAndView("index", "room", new Room());
    }

    @RequestMapping(value = "room/{id}")
    public ModelAndView roomtestJsp(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);

        map.addAttribute("room", getRoom);
        return new ModelAndView("index2");
    }

    @RequestMapping(value = "room/{id}/adduserform")
    public ModelAndView roomuseraddtestJsp(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);

        map.addAttribute("roomId", id);
        map.addAttribute("room", getRoom);
        map.addAttribute("user", new User());
        return new ModelAndView("indexadduser");
    }

    @RequestMapping(value = "room/{id}/showusers")
    public ModelAndView showusertestJsp(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);
        map.addAttribute("userlog", getRoom.getUsers());
        return new ModelAndView("indexshowusers");
    }



    

}
