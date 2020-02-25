package com.projm.rmsapi.controllers;

import javax.validation.Valid;
import com.projm.rmsapi.entities.Equipment;
import com.projm.rmsapi.entities.Room;
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
public class EquipmentController {

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
    
    @RequestMapping(value = "/room/{id}/addequip", method = RequestMethod.POST)
    public ResponseEntity<Object> addEquiptoRoom(@PathVariable("id") long id,
    @Valid @ModelAttribute("equip")Equipment equip,
    BindingResult result) {
    if (result.hasErrors()) {
        return new ResponseEntity<>("FAILED TO ADD EQUIPMENT", HttpStatus.FORBIDDEN);
    }

    try{

        Room getRoom = roomRepo.findByRoomId(id);
        getRoom.addEquipment(equip);
        equipmentRepo.save(equip);
        roomRepo.save(getRoom);
        
    }catch(Exception e){

        e.printStackTrace();
        return new ResponseEntity<>("FAILED TO ADD EQUIPMENT", HttpStatus.FORBIDDEN);
    }

        return new ResponseEntity<>("SUCCESSFULLY ADDED EQUIPMENT", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/deleteequip/{id}", method = RequestMethod.POST)
    public ResponseEntity<Object> deleteEquip(@PathVariable("id") long id) {

        boolean truth = equipmentRepo.deleteByEquipId(id);
        if (truth)
            return new ResponseEntity<>("EQUIPMENT DELETEION SUCCESS", HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>("EQUIPMENT DELETIO FAILED", HttpStatus.FORBIDDEN);
    }


    @RequestMapping(value = "/updateequip/{id}", method = RequestMethod.POST)
    public ResponseEntity<Object> updateEquip(@PathVariable("id") long id) {

        boolean truth = equipmentRepo.deleteByEquipId(id);
        if (truth)
            return new ResponseEntity<>("EQUIPMENT DELETEION SUCCESS", HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>("EQUIPMENT DELETIO FAILED", HttpStatus.FORBIDDEN);
    }

    


    }