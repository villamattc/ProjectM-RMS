package com.projm.rmsapi.controllers;

import java.util.List;

import com.projm.rmsapi.entities.Room;
import com.projm.rmsapi.repositories.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class IntegrateMeController {

    @Autowired
    RoomRepository roomRepo;

    // idk wth is wrong with this.. fml
    @RequestMapping(value = "integRoomNameList")
    public List<Room> integRoomList() {
        return roomRepo.findAll();
    }

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    // GETS ROOM LIST ONLY BY ROOM NAME

    @RequestMapping(value = "vacantRoomList")
    public List<String> vacantRoomNameList() {
        return roomRepo.findVacantRoomNameList();
    }

    @RequestMapping(value = "reservedRoomList")
    public List<String> reservedRoomNameList() {
        return roomRepo.findReservedRoomNameList();
    }

    @RequestMapping(value = "occupiedRoomList")
    public List<String> occupiedRoomNameList() {
        return roomRepo.findOccupiedRoomNameList();
    }


}