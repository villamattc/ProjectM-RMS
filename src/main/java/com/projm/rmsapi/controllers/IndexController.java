package com.projm.rmsapi.controllers;

import com.projm.rmsapi.entities.Room;
import com.projm.rmsapi.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController{

    @Autowired
    private  RoomService rs;

    @RequestMapping(value = "/index" , method = RequestMethod.GET)
    public String testJsp(Model model){
        return "index";
    }
    
    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public String newRoomm(@RequestParam String room_name, @RequestParam int room_status, @RequestParam boolean room_clean){

        System.out.println(room_name);
        System.out.println(room_status);
        System.out.println(room_clean);

        Room plswork = new Room(room_name,room_status,room_clean);
     //   rp.save(plswork);
        //rs.saveRoom(plswork);
        return "index";
    }

}
