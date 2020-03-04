package com.projm.rmsapi.controllers;

import java.util.List;

import javax.validation.Valid;

import com.projm.rmsapi.entities.Inventory;
import com.projm.rmsapi.entities.Room;
import com.projm.rmsapi.model.ListAttach;
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
public ModelAndView addInventorytoRoom(@PathVariable("id") long id,
    @Valid @ModelAttribute("inventory")Inventory inventory, BindingResult result) {
if (result.hasErrors()) {
    return new ModelAndView("forward:/viewroom/"+id+"/viewinvent");
}

try{ //@

    Room getRoom = roomRepo.findByRoomId(id);
    getRoom.addInventory(inventory);
    inventRepo.save(inventory);
    roomRepo.save(getRoom);
    
}catch(Exception e){

    e.printStackTrace();
    return new ModelAndView("forward:../");
}

    return new ModelAndView("redirect:/viewroom/"+id);
}

@RequestMapping(value = "/{id}/testupdateinvent", method = RequestMethod.POST)
public ModelAndView updateInventory(@Valid @ModelAttribute("attachInvents") ListAttach attachInvents, BindingResult result,
        @PathVariable("id") long id) {
    if (result.hasErrors()) {
        return new ModelAndView("forward:/viewroom/"+id+"/viewinvent");
    }


    List<Inventory> invents = inventRepo.getInventoryByRoomId(id);
    
    List<Inventory> updatedInvents = attachInvents.getList();
    Inventory[] updatedInventsArray = new Inventory[updatedInvents.size()];
    updatedInventsArray = updatedInvents.toArray(updatedInventsArray);
    // //Inventory[] updatedInventsArray = updatedInvents.stream().toArray(Inventory[]::new);
    
    int x = 0;
    for(Inventory i : invents){

        i.setInventCurrentQuantity(updatedInventsArray[x].getInventCurrentQuantity());
        x++;
    }


    return new ModelAndView("redirect:/viewroom/"+id+"/viewinvent");
    

}

@RequestMapping(value = "/deleteinvent/{id}", method = RequestMethod.GET)
public ModelAndView deleteInventory(@PathVariable("id") long id) {

    Inventory deleteInvent = inventRepo.findByInventId(id);
    Long roomId = deleteInvent.getRoom().getRoomId();

    inventRepo.deleteByInventId(id);

    
    return new ModelAndView("redirect:/viewroom/" + roomId);
}

@RequestMapping(value = "/searchinventbyroom", method = RequestMethod.GET)
public ModelAndView searchRoom(@RequestParam String find){

    Room searchRoom = roomRepo.findByRoomName(find);
    if(searchRoom == null)
        return new ModelAndView("forward:/inventory");

    Long roomId = searchRoom.getRoomId();
    String redirectTo = ("redirect:/viewroom/" + roomId+ "/viewinvent");
    return new ModelAndView(redirectTo);

    
}

}