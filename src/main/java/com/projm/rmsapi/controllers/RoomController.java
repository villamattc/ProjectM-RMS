package com.projm.rmsapi.controllers;

import java.util.List;

import com.projm.rmsapi.entities.Room;
import com.projm.rmsapi.repositories.RoomRepository;
import com.projm.rmsapi.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController{


    @Autowired
    private  RoomService rs;

    @Autowired
    RoomRepository rr;

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public ResponseEntity<Object> newRoom(@RequestParam String room_name, @RequestParam int room_status, @RequestParam boolean room_clean){

        Room newRoom = new Room(room_name,room_status,room_clean);
        boolean truth = rs.saveRoom(newRoom);

        if(truth==true)
            return new ResponseEntity<>("ROOM CREATION SUCCESS", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("ROOM CREATION FAILED", HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value="/room/{id}/adduser", method=RequestMethod.POST)
    public ResponseEntity<Object> requestMethodName(@PathVariable("id") long id) {

        Room getRoom = rr.findByRoomId(id);
        
        

        return new ResponseEntity<>("ROOM CREATION FAILED", HttpStatus.FORBIDDEN);
    }


    

}