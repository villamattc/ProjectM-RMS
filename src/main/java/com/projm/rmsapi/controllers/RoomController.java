package com.projm.rmsapi.controllers;

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

    @RequestMapping(value = "/room/{id}/addinventory", method = RequestMethod.POST)
    public ResponseEntity<Object> addEquiptoRoom(@PathVariable("id") long id,
    @Valid @ModelAttribute("inventory")Inventory inventory,
    BindingResult result) {
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

    @RequestMapping(value = "/room/{id}/addequip", method = RequestMethod.POST)
    public ResponseEntity<Object> addInventorytoRoom(@PathVariable("id") long id,
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

    // not done... still need sessions
    @RequestMapping(value = "/testlogin", method = RequestMethod.POST)
    public ModelAndView adminLogin(@RequestParam String username, @RequestParam String password) {

        Admin userAdmin = new Admin(username,password);


        if(userAdmin.equals(adminRepo.findByAdminId((long)1)))
            return new ModelAndView("testindex", "admin", userAdmin);
        
        return new ModelAndView("testindex");
    }

    @RequestMapping(value = "/testcreateAdmin", method = RequestMethod.POST)
    public ModelAndView adminregister(@RequestParam String username, @RequestParam String password) {

        Admin admin = new Admin(username,password);
        adminRepo.save(admin);

        return new ModelAndView("testlogin"); 
    }

    }