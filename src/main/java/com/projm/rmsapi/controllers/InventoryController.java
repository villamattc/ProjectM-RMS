package com.projm.rmsapi.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.projm.rmsapi.entities.Admin;
import com.projm.rmsapi.entities.Equipment;
import com.projm.rmsapi.entities.Inventory;
import com.projm.rmsapi.entities.Room;
import com.projm.rmsapi.entities.User;
import com.projm.rmsapi.repositories.AdminRepository;
import com.projm.rmsapi.repositories.EquipmentRepository;
import com.projm.rmsapi.repositories.InventoryRepository;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@ControllerAdvice
public class InventoryController {

    @Autowired
    private RoomService roomService;

    @Autowired
    RoomRepository roomRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    EquipmentRepository equipmentRepo;

    @Autowired
    AdminRepository adminRepo;

    @Autowired
    InventoryRepository inventRepo;
    
    
// add inventory through viewing the room info
@RequestMapping(value = "/room/{id}/addinventory", method = RequestMethod.POST)
public ResponseEntity<Object> addInventorytoRoom(@PathVariable("id") long id,
    @Valid @ModelAttribute("inventory")Inventory inventory, BindingResult result) {
if (result.hasErrors()) {
    return new ResponseEntity<>("FAILED TO ADD INVENTORY", HttpStatus.FORBIDDEN);
}

try{

    Room getRoom = roomRepo.findByRoomId(id);
    getRoom.addInventory(inventory);
    inventRepo.save(inventory);
    roomRepo.save(getRoom);
    
}catch(Exception e){

    e.printStackTrace();
    return new ResponseEntity<>("FAILED TO ADD INVENTORY", HttpStatus.FORBIDDEN);
}

    return new ResponseEntity<>("SUCCESSFULLY ADDED INVENTORY", HttpStatus.CREATED);
}


    


    }