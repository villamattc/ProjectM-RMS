package com.projm.rmsapi.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
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
import org.springframework.web.bind.annotation.DeleteMapping;
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
    
    // add room
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addRoom(@Valid @ModelAttribute("room") Room room, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("ROOM CREATION FAILED", HttpStatus.FORBIDDEN);
        }

        boolean truth = roomService.saveRoom(room);

        if (truth)
            return new ResponseEntity<>("ROOM CREATION SUCCESS", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("ROOM CREATION FAILED", HttpStatus.FORBIDDEN);
    }

    // DELETE BUTTON ON THE ROW
    @RequestMapping(value = "/deleteroom/{id}",  method = RequestMethod.GET)
    public ModelAndView deleteRoom(@PathVariable("id") long id){

        roomRepo.deleteByRoomId(id);
        return new ModelAndView("redirect:/room");
    }
    
    // HAVE TO EDIT THE VIEW ROOM IN A WAY TO MATCH THIS @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    @RequestMapping(value = "/updateroom/{id}", method = RequestMethod.POST)
    public ResponseEntity<Object> updateRoom(@Valid @ModelAttribute("room") Room room, BindingResult result, @PathVariable("id") long id){
            if (result.hasErrors()) {
                return new ResponseEntity<>("ROOM UPDATE FAILED", HttpStatus.FORBIDDEN);
            }

            Room updatedRoom = roomRepo.findByRoomId(id);
            updatedRoom.setRoomName(room.getRoomName());
            updatedRoom.setRoomStatus(room.getRoomStatus());
            updatedRoom.setRoomType(room.getRoomType());
            updatedRoom.setRoomClean(room.isRoomClean());

            return new ResponseEntity<>("ROOM UPDATE SUCCESS", HttpStatus.ACCEPTED);


    }

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