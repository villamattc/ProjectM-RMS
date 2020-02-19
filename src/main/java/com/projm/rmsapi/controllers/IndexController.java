package com.projm.rmsapi.controllers;

import com.projm.rmsapi.entities.Admin;
import com.projm.rmsapi.entities.Equipment;
import com.projm.rmsapi.entities.Inventory;
import com.projm.rmsapi.entities.Room;
import com.projm.rmsapi.entities.User;
import com.projm.rmsapi.repositories.EquipmentRepository;
import com.projm.rmsapi.repositories.RoomRepository;
import com.projm.rmsapi.repositories.UserRepository;
import com.projm.rmsapi.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController{

    @Autowired
    private  RoomService roomService;
    @Autowired
    private RoomRepository roomRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private EquipmentRepository equipRepo;

    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@TESTING VIEW@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    @RequestMapping(value = "testindex")
    public ModelAndView testJsp(ModelMap map, Admin admin){



        map.addAttribute("vacantRooms", roomService.getAllVacantRooms());
        map.addAttribute("roomlist", roomRepo.findAll());
        return new ModelAndView("test/testindex", "room", new Room());
    }

    @RequestMapping(value = "testroom/{id}")
    public ModelAndView roomtestJsp(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);

        map.addAttribute("room", getRoom);
        return new ModelAndView("test/index2");
    }

    @RequestMapping(value = "testroom/{id}/adduserform")
    public ModelAndView roomuseraddtestJsp(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);

        map.addAttribute("roomId", id);
        map.addAttribute("room", getRoom);
        map.addAttribute("user", new User());
        return new ModelAndView("test/indexadduser");
    }

    @RequestMapping(value = "testroom/{id}/showusers")
    public ModelAndView showuserstestJsp(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);
        map.addAttribute("user", getRoom.getUsers());
        return new ModelAndView("test/indexshowusers");
    }

    @RequestMapping(value = "testroom/{id}/showequips")
    public ModelAndView showequipstestJsp(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);
        map.addAttribute("equip", getRoom.getEquips());
        return new ModelAndView("test/indexshowequips");
    }

    @RequestMapping(value = "testroom/{id}/showinvent")
    public ModelAndView showinventtestJsp(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);
        map.addAttribute("invent", getRoom.getInvents());
        return new ModelAndView("test/indexshowinvent");
    }

    @RequestMapping(value = "testroom")
    public ModelAndView testroom(ModelMap map){
        
        Map<Integer, String> options = new HashMap<Integer, String>();
        options.put(1, "Vacant");
        options.put(2, "Occupied");
        options.put(3, "Reserved");

        map.addAttribute("room", new Room());
        map.addAttribute("vacantRooms", roomService.getAllVacantRooms());
        map.addAttribute("occupiedRooms", roomService.getAllOccupiedRooms());
        map.addAttribute("reservedRooms", roomService.getAllReservedRooms());
        map.addAttribute("options", options);

        return new ModelAndView("test/danstestroom");
    }

    @RequestMapping(value = "testlogin")
    public ModelAndView testlogin(){
        return new ModelAndView("testlogin");
    }

    @RequestMapping(value = "testroom/{id}/addequipform")
    public ModelAndView roomequipaddtestJsp(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);

        map.addAttribute("roomId", id);
        map.addAttribute("room", getRoom);
        map.addAttribute("equip", new Equipment());
        return new ModelAndView("test/indexaddequip");
    }

    // /testroom/${room.roomId}/addinventoryform
    
    @RequestMapping(value = "testroom/{id}/addinventoryform")
    public ModelAndView roominventoryaddtestJsp(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);

        map.addAttribute("roomId", id);
        map.addAttribute("room", getRoom);
        map.addAttribute("inventory", new Inventory());
        return new ModelAndView("test/indexaddinventory");
    }

     //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//asda


    @RequestMapping(value = "room")
    public ModelAndView Room(ModelMap map){

        //map.addAttribute("roomlist", roomRepo.findAll());

        Map<Integer, String> roomStatusOptions = new HashMap<Integer, String>();
        roomStatusOptions.put(1, "Vacant");
        roomStatusOptions.put(2, "Occupied");
        roomStatusOptions.put(3, "Reserved");

        Map<Integer, String> roomTypeOptions = new HashMap<Integer, String>();
        roomTypeOptions.put(1, "Deluxe Room");
        roomTypeOptions.put(2, "Amuma Spa Suite");
        roomTypeOptions.put(3, "Premier Deluxe Room");
        roomTypeOptions.put(4, "Royal Bungalow");

        map.addAttribute("vacantRooms", roomService.getAllVacantRooms());
        map.addAttribute("occupiedRooms", roomService.getAllOccupiedRooms());
        map.addAttribute("reservedRooms", roomService.getAllReservedRooms()); //<c:forEach items="${vacantRooms}" var="item">
        map.addAttribute("roomStatusOptions", roomStatusOptions);
        map.addAttribute("roomTypeOptions", roomTypeOptions);

        return new ModelAndView("room", "room", new Room());


    }

    
    @RequestMapping(value = "viewroom/{id}")
    public ModelAndView viewRoomDetails(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);

        
        map.addAttribute("room", getRoom);
        return new ModelAndView("viewroom");
    }

 
    

    //login
    @RequestMapping(value = "login")
    public ModelAndView Login(ModelMap map){

        return new ModelAndView("login");
    }
    
    @RequestMapping(value = "viewroom/{id}/adduserform")
    public ModelAndView AddUserForm(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);

        map.addAttribute("roomId", id);
        map.addAttribute("room", getRoom);
        map.addAttribute("user", new User());
        return new ModelAndView("adduserform");
    }
    @RequestMapping(value = "viewroom/{id}/addequipform")
    public ModelAndView AddEquipForm(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);
        
        Map<Integer, String> equipmentStatus = new HashMap<Integer, String>();
        equipmentStatus.put(1, "Good Condition");
        equipmentStatus.put(2, "Need Maintainance");
        equipmentStatus.put(3, "Need Repair");
        equipmentStatus.put(4, "Need Replacement");

        map.addAttribute("equipmentStatusOptions",equipmentStatus);

        map.addAttribute("roomId", id);
        map.addAttribute("room", getRoom);
        map.addAttribute("equip", new Equipment());
        return new ModelAndView("addequipform");
    }
    @RequestMapping(value = "viewroom/{id}/addinventoryform")
    public ModelAndView AddInventoryForm(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);

        map.addAttribute("roomId", id);
        map.addAttribute("room", getRoom);
        map.addAttribute("inventory", new Inventory());
        return new ModelAndView("addinventoryform");
    }

    @RequestMapping(value = "viewroom/{id}/viewusers")
    public ModelAndView ViewUsers(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);
        map.addAttribute("user", getRoom.getUsers());
        return new ModelAndView("viewusers");
    }

    @RequestMapping(value = "viewroom/{id}/viewequip")
    public ModelAndView ViewEquipment(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);
        map.addAttribute("equip", getRoom.getEquips());
        return new ModelAndView("viewequip");
    }

    @RequestMapping(value = "viewroom/{id}/viewinvent")
    public ModelAndView ViewInventory(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);
        map.addAttribute("invent", getRoom.getInvents());
        return new ModelAndView("viewinvent");
    }


    //EQUIPMENT OPENING PAGE
 @RequestMapping(value = "equipment")
 public ModelAndView Equipment(ModelMap map){

    List<Equipment> goodCondition = equipRepo.findAllByEquipStatus(1);
    List<Equipment> needsMaint = equipRepo.findAllByEquipStatus(2);
    List<Equipment> needsRepair = equipRepo.findAllByEquipStatus(3);
    List<Equipment> needReplace = equipRepo.findAllByEquipStatus(4);

    List<String> roomNames1 = new ArrayList<>();
    List<String> roomNames2 = new ArrayList<>();
    List<String> roomNames3 = new ArrayList<>();
    List<String> roomNames4 = new ArrayList<>();

    for(Equipment equips: goodCondition){

        Room room = equips.getRoom();
        roomNames1.add(room.getRoomName());

    }



    map.addAttribute("goodconditionRoomName", roomNames1);

    for(Equipment equips: needsMaint){

        Room room = equips.getRoom();
        roomNames2.add(room.getRoomName());
        

    }

    map.addAttribute("needsmaintRoomName", roomNames2);

    for(Equipment equips: needsRepair){

        Room room = equips.getRoom();
        roomNames3.add(room.getRoomName());

    }

    map.addAttribute("needsrepairRoomName", roomNames3);

    for(Equipment equips: needReplace){

        Room room = equips.getRoom();
        roomNames4.add(room.getRoomName());

    }

    map.addAttribute("needreplaceRoomName", roomNames4);

    map.addAttribute("goodcondition", equipRepo.findAllByEquipStatus(1));
    map.addAttribute("needsmaint", equipRepo.findAllByEquipStatus(2));
    map.addAttribute("needsrepair", equipRepo.findAllByEquipStatus(3));
    map.addAttribute("needreplace", equipRepo.findAllByEquipStatus(4));

     return new ModelAndView("equipment");
 }

 //inventory
 @RequestMapping(value = "inventory")
 public ModelAndView Inventory(ModelMap map){

     return new ModelAndView("inventory");
 }
}
