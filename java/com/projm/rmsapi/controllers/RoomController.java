package com.projm.rmsapi.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projm.rmsapi.entities.Room;
import com.projm.rmsapi.entities.User;
import com.projm.rmsapi.repositories.RoomRepository;
import com.projm.rmsapi.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<Object> newRoom(@RequestParam String roomName, @RequestParam int roomStatus, @RequestParam boolean roomClean){

        Room newRoom = new Room(roomName,roomStatus,roomClean);
        boolean truth = rs.saveRoom(newRoom);

        if(truth)
            return new ResponseEntity<>("ROOM CREATION SUCCESS", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("ROOM CREATION FAILED", HttpStatus.FORBIDDEN);
    }

    // @RequestMapping(value="/room/{id}/adduser", method=RequestMethod.POST)
    // public ResponseEntity<Object> addUsertoRoom(@PathVariable("id") long id, @RequestParam int ) {

    //     Room getRoom = rr.findByRoomId(id);


    //     getRoom.addUser(user);
        

    //     return new ResponseEntity<>("ROOM CREATION FAILED", HttpStatus.FORBIDDEN);
    // }


    

}