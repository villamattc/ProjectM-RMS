package com.projm.rmsapi.controllers;

import java.util.List;

import com.projm.rmsapi.entities.Room;
import com.projm.rmsapi.repositories.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class IntegrateMeController{

    @Autowired
    RoomRepository roomRepo;

    // idk wth is wrong with this.. fml
    @RequestMapping(value = "integRoomNameList")
    public List<Room> integRoomList(){
        return roomRepo.findAll();
    }

    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    // GETS ROOM LIST ONLY BY ROOM NAME

    @RequestMapping(value = "vacantRoomList")
    public List<String> vacantRoomNameList(){
        return roomRepo.findVacantRoomNameList();
    }
    @RequestMapping(value = "reservedRoomList")
    public List<Room> reservedRoomNameList(){
        return roomRepo.findAllByRoomStatus(2);
    }
    @RequestMapping(value = "occupiedRoomList")
    public List<Room> occupiedRoomNameList(){
        return roomRepo.findAllByRoomStatus(3);
    }

    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    /*

            Map<Integer, String> roomStatusOptions = new HashMap<Integer, String>();
        roomStatusOptions.put(1, "Vacant");
        roomStatusOptions.put(2, "Occupied");
        roomStatusOptions.put(3, "Reserved");

    */



}