package com.projm.rmsapi.controllers;

import javax.validation.Valid;

import com.projm.rmsapi.entities.Room;
import com.projm.rmsapi.entities.User;
import com.projm.rmsapi.repositories.AdminRepository;
import com.projm.rmsapi.repositories.EquipmentRepository;
import com.projm.rmsapi.repositories.InventoryRepository;
import com.projm.rmsapi.repositories.RoomRepository;
import com.projm.rmsapi.repositories.UserRepository;

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
import org.springframework.web.servlet.ModelAndView;


@RestController
@ControllerAdvice
public class UserController {

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
 

// add user through viewing the room info
@RequestMapping(value = "/room/{id}/adduser", method = RequestMethod.POST)
public ModelAndView addUsertoRoom(@PathVariable("id") long id, @Valid @ModelAttribute("user") User user,
    BindingResult result) {
    if (result.hasErrors()) {
        return new ModelAndView("forward:/"+id+"/adduserform");
    }

    try {
        
        Room getRoom = roomRepo.findByRoomId(id);
        getRoom.addUser(user);
        userRepo.save(user);
        roomRepo.save(getRoom);

    } catch (Exception e) {
        e.printStackTrace();
        return new ModelAndView("forward:/viewroom/"+id+"/adduserform");
    }

    return new ModelAndView("redirect:/viewroom/"+id);

}

    


    }