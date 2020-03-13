package com.projm.rmsapi.controllers;

import javax.validation.Valid;

import com.projm.rmsapi.entities.Room;

import com.projm.rmsapi.repositories.AdminRepository;
import com.projm.rmsapi.repositories.EquipmentRepository;
import com.projm.rmsapi.repositories.InventoryRepository;
import com.projm.rmsapi.repositories.RoomRepository;
import com.projm.rmsapi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
public class RoomController {

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
    
    // ADD ROOM
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addRoom(@Valid @ModelAttribute("room") Room room, BindingResult result) {
        if (result.hasErrors()) {

            return new ModelAndView("redirect:/room");
        }
        try{
            roomRepo.save(room);
        }catch(Exception e){
            e.printStackTrace();
            return new ModelAndView("redirect:/room");
        }
        
        return new ModelAndView("redirect:/room");

        
    }

    // DELETE BUTTON ON THE ROW
    @RequestMapping(value = "/deleteroom/{id}",  method = RequestMethod.GET)
    public ModelAndView deleteRoom(@PathVariable("id") long id){
        
        roomRepo.deleteByRoomId(id);
        return new ModelAndView("redirect:/room");
    }
    
    // UPDATE THE VALUES OF ROOM
    @RequestMapping(value = "/updateroom/{id}", method = RequestMethod.POST)
    public ModelAndView updateRoom(@Valid @ModelAttribute("room") Room room, BindingResult result, @PathVariable("id") long id){
            if (result.hasErrors()) {
                return new ModelAndView("redirect:/viewroom/" + id);
            }

            Room updatedRoom = roomRepo.findByRoomId(id);
            updatedRoom.setRoomName(room.getRoomName());
            updatedRoom.setRoomStatus(room.getRoomStatus());
            updatedRoom.setRoomType(room.getRoomType());
            updatedRoom.setRoomClean(room.isRoomClean());

            return new ModelAndView("redirect:/viewroom/" + id);


    }

    //SEARCH BASED ON THE ROOMNAME
    @RequestMapping(value = "/searchroom", method = RequestMethod.GET)
    public ModelAndView searchRoom(@RequestParam String find){

        Room searchRoom = roomRepo.findByRoomName(find);
        if(searchRoom == null)
            return new ModelAndView("forward:/room");

        Long roomId = searchRoom.getRoomId();
        String redirectTo = ("redirect:/viewroom/" + roomId);
        return new ModelAndView(redirectTo);

    }
    
    


    }