package com.projm.rmsapi.controllers;

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

    // ADD EQUIPMENT TO THE ROOM
    @RequestMapping(value = "/room/{id}/addequip", method = RequestMethod.POST)
    public ModelAndView addEquiptoRoom(@PathVariable("id") long id,
            @Valid @ModelAttribute("equip") Equipment equip, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("forward:/viewroom/"+id+"/addequipform");
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

    // DELETE THE EQUIPMENT BASED ON THE EQUIPMENT ID
    @RequestMapping(value = "/deleteequip/{id}", method = RequestMethod.GET)
    public ModelAndView deleteEquip(@PathVariable("id") long id) {

        Equipment deleteEquip = equipmentRepo.findByEquipId(id);
        Long roomId = deleteEquip.getRoom().getRoomId();

        equipmentRepo.deleteByEquipId(id);

        
        return new ModelAndView("redirect:/viewroom/" + roomId +"/viewequip");
    }

    //UPDATE EQUIPMENT 
    @RequestMapping(value = "/updateequip/{id}", method = RequestMethod.POST)
    public ModelAndView updateEquip(@Valid @ModelAttribute("equip") Equipment equipment, BindingResult result,
            @PathVariable("id") long id) {
        if (result.hasErrors()) {
            return new ModelAndView("forward:/updateequip/"+id);
        }


        Equipment updateEquip = equipmentRepo.findByEquipId(id);
        Room room = updateEquip.getRoom();
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
        
        return new ModelAndView("redirect:/viewroom/"+room.getRoomId()+"/viewequip");
    }

    // SEARCH EQUIPMENT
    @RequestMapping(value = "/searchequipbyroom", method = RequestMethod.GET)
    public ModelAndView searchEquip(@RequestParam String find){

        Room searchRoom = roomRepo.findByRoomName(find);
        if(searchRoom == null)
            return new ModelAndView("forward:/equipment");

        Long roomId = searchRoom.getRoomId();
        return new ModelAndView("redirect:/viewroom/" + roomId+ "/viewequip");

        
    }

}