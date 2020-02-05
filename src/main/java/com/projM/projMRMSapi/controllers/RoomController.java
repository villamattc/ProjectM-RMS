package com.projM.projMRMSapi.controllers;

import java.util.List;

import com.projM.projMRMSapi.entities.Room;
import com.projM.projMRMSapi.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController{

    @Autowired
    private  RoomService rs;
    

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public ResponseEntity<Object> newRoom(@RequestBody Room room){

        boolean truth = rs.saveRoom(room);
        if(truth)
           return new ResponseEntity<>("ROOM CREATED", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("ROOM CREATION FAILED", HttpStatus.FORBIDDEN);
    }
    

    


}