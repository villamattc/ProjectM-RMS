package com.projm.rmsapi.controllers;

import javax.validation.Valid;

import com.projm.rmsapi.entities.Equipment;
import com.projm.rmsapi.entities.Inventory;
import com.projm.rmsapi.entities.Room;
import com.projm.rmsapi.entities.User;
import com.projm.rmsapi.repositories.EquipmentRepository;
import com.projm.rmsapi.repositories.RoomRepository;
import com.projm.rmsapi.repositories.UserRepository;
import com.projm.rmsapi.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    RoomRepository roomRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    EquipmentRepository equipmentRepo;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> newRoom(@Valid @ModelAttribute("room") Room room, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("ROOM CREATION FAILED", HttpStatus.FORBIDDEN);
        }

        boolean truth = roomService.saveRoom(room);

        if (truth)
            return new ResponseEntity<>("ROOM CREATION SUCCESS", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("ROOM CREATION FAILED", HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = "/room/{id}/adduser", method = RequestMethod.POST)
    public ResponseEntity<Object> addUsertoRoom(@PathVariable("id") long id, @Valid @ModelAttribute("user") User user,
            BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("FAILED TO ADD USER", HttpStatus.FORBIDDEN);
        }

        System.out.println(user.getLastName());
        System.out.println(user.getFirstName());
        System.out.println(user.getCheckin());
        System.out.println(user.getCheckout());
        System.out.println(user.getNationality());
        System.out.println(user.getOccupation());
        System.out.println(user.getBusinessOrvacay());
        System.out.println(user.getAge());

        try {

            Room getRoom = roomRepo.findByRoomId(id);
            getRoom.addUser(user);
            userRepo.save(user);
            roomRepo.save(getRoom);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("FAILED TO ADD USER", HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>("SUCCESSFULLY ADDED USER", HttpStatus.CREATED);

    }

    @RequestMapping(value = "/room/{id}/addequip", method = RequestMethod.POST)
    public ResponseEntity<Object> addEquiptoRoom(@PathVariable("id") long id,
    @Valid @ModelAttribute("equip")Equipment equip,
    BindingResult result) {
    if (result.hasErrors()) {
        return new ResponseEntity<>("FAILED TO ADD USER", HttpStatus.FORBIDDEN);
    }

    try{

        Room getRoom = roomRepo.findByRoomId(id);
        getRoom.addEquipment(equip);
        equipmentRepo.save(equip);
        roomRepo.save(getRoom);
        
    }catch(Exception e){

        e.printStackTrace();
        return new ResponseEntity<>("SUCCESSFULLY ADDED EQUIPMENT", HttpStatus.CREATED);
    }

        return new ResponseEntity<>("SUCCESSFULLY ADDED USER", HttpStatus.CREATED);
    }



    // @RequestMapping(value = "/room/{id}/addequip", method = RequestMethod.POST)
    // public ResponseEntity<Object> addInventtoRoom(@PathVariable("id") long id,
    // @Valid @ModelAttribute("invent")Inventory invent,
    // BindingResult result) {
    // if (result.hasErrors()) {
    // return new ResponseEntity<>("FAILED TO ADD USER", HttpStatus.FORBIDDEN);
    // }

    // Room getRoom = roomRepo.findByRoomId(id);
    // getRoom.addInvent(invent);

    // boolean truth = roomService.saveRoom(getRoom);

    // if (truth)
    // return new ResponseEntity<>("SUCCESSFULLY ADDED USER", HttpStatus.FORBIDDEN);
    // else
    // return new ResponseEntity<>("FAILED TO ADD USER", HttpStatus.FORBIDDEN);

    // }
    }