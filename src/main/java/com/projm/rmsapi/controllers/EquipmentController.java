package com.projm.rmsapi.controllers;

import java.util.List;

import javax.validation.Valid;

import com.projm.rmsapi.entities.Equipment;
import com.projm.rmsapi.entities.EquipmentLog;
import com.projm.rmsapi.entities.Room;
import com.projm.rmsapi.repositories.AdminRepository;
import com.projm.rmsapi.repositories.EquipmentLogRepository;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@ControllerAdvice
public class EquipmentController {

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

    @Autowired
    EquipmentLogRepository equipmentLogRepo;

    @RequestMapping(value = "/room/{id}/addequip", method = RequestMethod.POST)
    public ModelAndView addEquiptoRoom(@PathVariable("id") long id,
            @Valid @ModelAttribute("equip") Equipment equip, BindingResult result) {
        if (result.hasErrors()) {
            
        }

        try {

            Room getRoom = roomRepo.findByRoomId(id);
            getRoom.addEquipment(equip);
            equipmentRepo.save(equip);
            roomRepo.save(getRoom);

        } catch (Exception e) {

            e.printStackTrace();
            return new ModelAndView("forward:/viewroom/"+id+"/addequipform");
        }

        return new ModelAndView("redirect:/viewroom/"+id);
    }

    @RequestMapping(value = "/deleteequip/{id}", method = RequestMethod.GET)
    public ModelAndView deleteEquip(@PathVariable("id") long id) {

        Equipment deleteEquip = equipmentRepo.findByEquipId(id);
        Long roomId = deleteEquip.getRoom().getRoomId();

        equipmentRepo.deleteByEquipId(id);

        
        return new ModelAndView("redirect:/viewroom/" + roomId +"/viewequip");
    }

    @RequestMapping(value = "/updateequip/{id}", method = RequestMethod.POST)
    public ResponseEntity<Object> updateEquip(@Valid @ModelAttribute("equip") Equipment equipment, BindingResult result,
            @PathVariable("id") long id) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("EQUIPMENT UPDATE FAILED", HttpStatus.FORBIDDEN);
        }

        Equipment updateEquip = equipmentRepo.findByEquipId(id);
        System.out.println(equipment.getDescription());

        EquipmentLog eqLog = new EquipmentLog();
        eqLog.saveToLogs(id, equipment, "admin");
        equipmentLogRepo.save(eqLog);
       
        updateEquip.setEquipName(equipment.getEquipName());
        updateEquip.setEquipStatus(equipment.getEquipStatus());
        updateEquip.setDateOfPurchase(equipment.getDateOfPurchase());
        updateEquip.setDateOfLastMaintenance(equipment.getDateOfLastMaintenance());
        updateEquip.setFunctionalLife(equipment.getFunctionalLife());
        updateEquip.setFunctionality(equipment.getFunctionality());
        updateEquip.setCompletenessOfParts(equipment.getCompletenessOfParts());
        updateEquip.setAppearance(equipment.getAppearance());
        updateEquip.setAssessmentScore(updateEquip.computeAssessmentScore());
        
        return new ResponseEntity<>("EQUIPMENT UPDATE SUCCESS", HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "/searchequipbyroom", method = RequestMethod.GET)
    public ModelAndView searchRoom(@RequestParam String find){

        Room searchRoom = roomRepo.findByRoomName(find);
        if(searchRoom == null)
            return new ModelAndView("forward:/equipment");

        Long roomId = searchRoom.getRoomId();
        String redirectTo = ("redirect:/viewroom/" + roomId+ "/viewequip");
        return new ModelAndView(redirectTo);

        
    }

}