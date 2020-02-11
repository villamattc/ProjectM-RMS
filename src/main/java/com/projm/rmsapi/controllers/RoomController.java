package com.projm.rmsapi.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.projm.rmsapi.entities.Equipment;
import com.projm.rmsapi.entities.Inventory;
import com.projm.rmsapi.entities.Room;
import com.projm.rmsapi.entities.User;
import com.projm.rmsapi.repositories.RoomRepository;
import com.projm.rmsapi.repositories.UserRepository;
import com.projm.rmsapi.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> newRoom(@Valid @ModelAttribute("room") Room room, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("ROOM CREATION FAILED", HttpStatus.FORBIDDEN);
        }

        // model.addAttribute("room", new Room());
        // model.addAttribute("roomName", "");

        // Room newRoom = new Room(roomName,roomStatus,roomClean);
        // boolean truth = rs.saveRoom(newRoom);
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

        try{

        Room getRoom = roomRepo.findByRoomId(id);
        getRoom.addUser(user);
        roomRepo.save(getRoom);

        }catch(Exception e){
            return new ResponseEntity<>("FAILED TO ADD USER", HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>("SUCCESSFULLY ADDED USER", HttpStatus.CREATED);

    }

    // @RequestMapping(value = "/room/{id}/addequip", method = RequestMethod.POST)
    // public ResponseEntity<Object> addEquiptoRoom(@PathVariable("id") long id, @Valid @ModelAttribute("equip")Equipment equip,
    //         BindingResult result) {
    //     if (result.hasErrors()) {
    //         return new ResponseEntity<>("FAILED TO ADD USER", HttpStatus.FORBIDDEN);
    //     }

    //     Room getRoom = roomRepo.findByRoomId(id);
    //     getRoom.addEquip(equip);

    //     boolean truth = roomService.saveRoom(getRoom);

    //     if (truth)
    //         return new ResponseEntity<>("SUCCESSFULLY ADDED USER", HttpStatus.FORBIDDEN);
    //     else
    //         return new ResponseEntity<>("FAILED TO ADD USER", HttpStatus.FORBIDDEN);

    // }

//     @RequestMapping(value = "/room/{id}/addequip", method = RequestMethod.POST)
//     public ResponseEntity<Object> addInventtoRoom(@PathVariable("id") long id, @Valid @ModelAttribute("invent")Inventory invent,
//             BindingResult result) {
//         if (result.hasErrors()) {
//             return new ResponseEntity<>("FAILED TO ADD USER", HttpStatus.FORBIDDEN);
//         }

//         Room getRoom = roomRepo.findByRoomId(id);
//         getRoom.addInvent(invent);

//         boolean truth = roomService.saveRoom(getRoom);

//         if (truth)
//             return new ResponseEntity<>("SUCCESSFULLY ADDED USER", HttpStatus.FORBIDDEN);
//         else
//             return new ResponseEntity<>("FAILED TO ADD USER", HttpStatus.FORBIDDEN);

//     }
 }