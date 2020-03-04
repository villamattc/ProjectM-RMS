package com.projm.rmsapi.controllers;

import com.projm.rmsapi.entities.Admin;
import com.projm.rmsapi.entities.Equipment;
import com.projm.rmsapi.entities.Inventory;
import com.projm.rmsapi.entities.Room;
import com.projm.rmsapi.entities.User;
import com.projm.rmsapi.model.ListAttach;
import com.projm.rmsapi.repositories.EquipmentLogRepository;
import com.projm.rmsapi.repositories.EquipmentRepository;
import com.projm.rmsapi.repositories.InventoryRepository;
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
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomRepository roomRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private EquipmentRepository equipRepo;
    @Autowired
    private InventoryRepository inventRepo;
    @Autowired
    private EquipmentLogRepository equipmentLogRepo;

    @RequestMapping(value="")
    public ModelAndView defaultPage(){
        return new ModelAndView("redirect:/dashboard");
    }



    @RequestMapping(value = "room")
    public ModelAndView Room(ModelMap map) {

        // map.addAttribute("roomlist", roomRepo.findAll());

        Map<Integer, String> roomStatusOptions = new HashMap<Integer, String>();
        roomStatusOptions.put(1, "Vacant");
        roomStatusOptions.put(2, "Occupied");
        roomStatusOptions.put(3, "Reserved");

        Map<Integer, String> roomTypeOptions = new HashMap<Integer, String>();
        roomTypeOptions.put(1, "Deluxe Room");
        roomTypeOptions.put(2, "Amuma Spa Suite");
        roomTypeOptions.put(3, "Premier Deluxe Room");
        roomTypeOptions.put(4, "Royal Bungalow");

        Map<Boolean, String> roomCleanOptions = new HashMap<Boolean, String>();
        roomCleanOptions.put(true, "Room is clean");
        roomCleanOptions.put(false, "Room is UNCLEAN");


        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@"+roomRepo.countByRoomStatus(1));

        
        map.addAttribute("vacantNumbers", roomRepo.countByRoomStatus(1));
        map.addAttribute("occupiedNumbers", roomRepo.countByRoomStatus(2));
        map.addAttribute("reservedNumbers", roomRepo.countByRoomStatus(3));
        map.addAttribute("vacantRooms", roomService.getAllVacantRooms());
        map.addAttribute("occupiedRooms", roomService.getAllOccupiedRooms());
        map.addAttribute("reservedRooms", roomService.getAllReservedRooms()); 
                                                                              
        map.addAttribute("roomCleanOptions", roomCleanOptions);                                                                     
        map.addAttribute("roomStatusOptions", roomStatusOptions);
        map.addAttribute("roomTypeOptions", roomTypeOptions);

        return new ModelAndView("room", "room", new Room());

    }

    @RequestMapping(value = "viewroom/{id}")
    public ModelAndView viewRoomDetails(@PathVariable("id") long id, ModelMap map) {

        Room getRoom = roomRepo.findByRoomId(id);

        Map<Integer, String> roomTypeOptions = new HashMap<Integer, String>();
        roomTypeOptions.put(1, "Deluxe Room");
        roomTypeOptions.put(2, "Amuma Spa Suite");
        roomTypeOptions.put(3, "Premier Deluxe Room");
        roomTypeOptions.put(4, "Royal Bungalow");

        Map<Integer, String> roomStatusOptions = new HashMap<Integer, String>();
        roomStatusOptions.put(1, "Vacant");
        roomStatusOptions.put(2, "Occupied");
        roomStatusOptions.put(3, "Reserved");

        Map<Boolean, String> roomCleanOptions = new HashMap<Boolean, String>();
        roomCleanOptions.put(true, "Room is clean");
        roomCleanOptions.put(false, "Room is UNCLEAN");

        map.addAttribute("roomCleanOptions", roomCleanOptions);                                                                     
        map.addAttribute("roomStatusOptions", roomStatusOptions);
        map.addAttribute("roomTypeOptions", roomTypeOptions);
        map.addAttribute("room", getRoom);


        // Room getRoom = roomRepo.findByRoomId(id);

        //List of Invents
        map.addAttribute("room",getRoom);
        map.addAttribute("invent", getRoom.getInvents());

        //List of Equips
        map.addAttribute("equip", getRoom.getEquips());
        map.addAttribute("equipment", new Equipment());
      

        return new ModelAndView("viewroom");
    }

    // login
    @RequestMapping(value = "login")
    public ModelAndView Login(ModelMap map) {

        return new ModelAndView("login");
    }

    @RequestMapping(value = "viewroom/{id}/adduserform")
    public ModelAndView AddUserForm(@PathVariable("id") long id, ModelMap map) {

        Room getRoom = roomRepo.findByRoomId(id);

        Map<Integer, String> business1OrVacation2 = new HashMap<Integer, String>();
        business1OrVacation2.put(1, "Business");
        business1OrVacation2.put(2, "Vacation");

        map.addAttribute("busiOrVacaOption",business1OrVacation2);
        map.addAttribute("roomId", id);
        map.addAttribute("room", getRoom);
        map.addAttribute("user", new User());
        return new ModelAndView("adduserform");
    }

    @RequestMapping(value = "viewroom/{id}/addequipform")
    public ModelAndView AddEquipForm(@PathVariable("id") long id, ModelMap map) {

        Room getRoom = roomRepo.findByRoomId(id);

        Map<Integer, String> equipmentStatus = new HashMap<Integer, String>();
        equipmentStatus.put(1, "Good Condition");
        equipmentStatus.put(2, "Need Maintainance");
        equipmentStatus.put(3, "Need Repair");
        equipmentStatus.put(4, "Need Replacement");

        map.addAttribute("equipmentStatusOptions", equipmentStatus);

        map.addAttribute("roomId", id);
        map.addAttribute("room", getRoom);
        map.addAttribute("equip", new Equipment());
        return new ModelAndView("addequipform");
    }

    @RequestMapping(value = "viewroom/{id}/addinventoryform")
    public ModelAndView AddInventoryForm(@PathVariable("id") long id, ModelMap map) {

        Room getRoom = roomRepo.findByRoomId(id);

        map.addAttribute("roomId", id);
        map.addAttribute("room", getRoom);
        map.addAttribute("inventory", new Inventory());
        return new ModelAndView("addinventoryform");
    }

    @RequestMapping(value = "viewroom/{id}/viewusers")
    public ModelAndView ViewUsers(@PathVariable("id") long id, ModelMap map) {

        Room getRoom = roomRepo.findByRoomId(id);
        map.addAttribute("user", getRoom.getUsers());
        return new ModelAndView("viewusers");
    }

    @RequestMapping(value = "viewroom/{id}/viewequip")
    public ModelAndView ViewEquipment(@PathVariable("id") long id, ModelMap map) {
        //@@
        Room getRoom = roomRepo.findByRoomId(id);
        map.addAttribute("equip", getRoom.getEquips());
        map.addAttribute("equipment", new Equipment());
        return new ModelAndView("viewequip");
    }

    @RequestMapping(value = "viewroom/{id}/viewinvent")
    public ModelAndView ViewInventory(@PathVariable("id") long id, ModelMap map) {

        Room getRoom = roomRepo.findByRoomId(id);
        map.addAttribute("room",getRoom);
        map.addAttribute("invent", getRoom.getInvents());
        return new ModelAndView("viewinvent");
    }

    // EQUIPMENT OPENING PAGE
    @RequestMapping(value = "equipment")
    public ModelAndView Equipment(ModelMap map) {

        List<Equipment> goodCondition = equipRepo.findAllByEquipStatus(1);
        List<Equipment> needsMaint = equipRepo.findAllByEquipStatus(2);
        List<Equipment> needsRepair = equipRepo.findAllByEquipStatus(3);
        List<Equipment> needReplace = equipRepo.findAllByEquipStatus(4);

        List<String> roomNames1 = new ArrayList<>();
        List<String> roomNames2 = new ArrayList<>();
        List<String> roomNames3 = new ArrayList<>();
        List<String> roomNames4 = new ArrayList<>();

        for (Equipment equips : goodCondition) {

            Room room = equips.getRoom();
            roomNames1.add(room.getRoomName());

        }

        map.addAttribute("goodconditionRoomName", roomNames1);

        for (Equipment equips : needsMaint) {

            Room room = equips.getRoom();
            roomNames2.add(room.getRoomName());

        }

        map.addAttribute("needsmaintRoomName", roomNames2);

        for (Equipment equips : needsRepair) {

            Room room = equips.getRoom();
            roomNames3.add(room.getRoomName());

        }

        map.addAttribute("needsrepairRoomName", roomNames3);

        for (Equipment equips : needReplace) {

            Room room = equips.getRoom();
            roomNames4.add(room.getRoomName());

        }

        map.addAttribute("needreplaceRoomName", roomNames4);

        map.addAttribute("goodcondition", equipRepo.findAllByEquipStatus(1));
        map.addAttribute("needsmaint", equipRepo.findAllByEquipStatus(2));
        map.addAttribute("needsrepair", equipRepo.findAllByEquipStatus(3));
        map.addAttribute("needreplace", equipRepo.findAllByEquipStatus(4));

        map.addAttribute("countGoodCondition", equipRepo.countByEquipStatus(1));
        map.addAttribute("countNeedsMaint", equipRepo.countByEquipStatus(2));
        map.addAttribute("countNeedsRepair", equipRepo.countByEquipStatus(3));
        map.addAttribute("countNeedReplace", equipRepo.countByEquipStatus(4));
        return new ModelAndView("equipment");
    }

    // inventory
    @RequestMapping(value = "inventory")
    public ModelAndView Inventory(ModelMap map) {
        
        List<Inventory> inventList = inventRepo.descendingInventoryQuant();
        List<String> inventName = new ArrayList<>();
        List<Room> roomIdList = new ArrayList<>();
        

        for(Inventory invent : inventList){
            Room room = invent.getRoom();
            inventName.add(room.getRoomName());
            int x = 0;
            for(Room id : roomIdList){
                if(id.getRoomId() == room.getRoomId())   
                    x++;
            } //sad
            if(x==0)
            roomIdList.add(room);
        }
        
        map.addAttribute("inventListRoomName", inventName);
        map.addAttribute("inventList", inventList);
        map.addAttribute("room", roomIdList);
        return new ModelAndView("inventory");
    }

    // viewroominventory
    @RequestMapping(value = "viewroominvent")
    public ModelAndView viewRoomInventory(ModelMap map) {

        return new ModelAndView("viewroominvent");
    }

   
    

    @RequestMapping(value = "updateequip/{id}")
    public ModelAndView updateEquip(@PathVariable("id") long id, ModelMap map) {
        
        Equipment updateEquip = equipRepo.findByEquipId(id);
        map.addAttribute("updateequip", updateEquip );

        Room previousRoom = updateEquip.getRoom();
        map.addAttribute("prevRoomId", previousRoom.getRoomId());

        Map<Integer, String> equipmentStatus = new HashMap<Integer, String>();
        equipmentStatus.put(1, "Good Condition");
        equipmentStatus.put(2, "Need Maintainance");
        equipmentStatus.put(3, "Need Repair");
        equipmentStatus.put(4, "Need Replacement");

        map.addAttribute("equipmentStatusOptions", equipmentStatus);
        return new ModelAndView("updateequipform");
    
    }
 
    @RequestMapping(value = "dashboard")
    public ModelAndView Dashboard (ModelMap map){
   //Equipment Status//
     map.addAttribute("goodCondition", equipRepo.countByEquipStatus(1));
     map.addAttribute("needMaintenance", equipRepo.countByEquipStatus(2));
     map.addAttribute("needRepair", equipRepo.countByEquipStatus(3));
     map.addAttribute("needReplacement", equipRepo.countByEquipStatus(4));
    //Nationality//
    map.addAttribute("filipino", userRepo.countByNationality("Filipino"));
    map.addAttribute("chinese", userRepo.countByNationality("Chinese"));
    map.addAttribute("korean", userRepo.countByNationality("Korean"));
    map.addAttribute("american", userRepo.countByNationality("American"));
    map.addAttribute("japanese", userRepo.countByNationality("Japanese"));
    map.addAttribute("vietnamese", userRepo.countByNationality("Vietnamese"));
    map.addAttribute("taiwanese", userRepo.countByNationality("Taiwanese"));
    map.addAttribute("others", userRepo.countByNationality("Others"));
    //Room type//
    map.addAttribute("deluxeRoom", roomRepo.countByRoomType(1));
    map.addAttribute("amumaSpaSuite", roomRepo.countByRoomType(2));
    map.addAttribute("premierDeluxeRoom", roomRepo.countByRoomType(3));
    map.addAttribute("royalBungalow", roomRepo.countByRoomType(4));
    //Room Status//
    map.addAttribute("vacant", roomRepo.countByRoomStatus(1));
    map.addAttribute("occupied", roomRepo.countByRoomStatus(2));
    map.addAttribute("reserved", roomRepo.countByRoomStatus(1));
        return new ModelAndView("dashboard");
 }

@RequestMapping(value = "inventory/{id}")
public ModelAndView updateInventory(@PathVariable("id") long id, ModelMap map){

    Room room = roomRepo.findByRoomId(id); //testindex
    List<Inventory> roomInvents = inventRepo.getInventoryByRoomId(id);    
    List<Inventory> inventList = inventRepo.descendingInventoryQuant();
    List<String> inventName = new ArrayList<>();
    List<Room> roomIdList = new ArrayList<>();
    ListAttach inventoryAttach = new ListAttach(); //testindex
    List<Inventory> updatedInvents = room.getInvents(); //testindex
        
    for(Inventory invent : inventList){
        Room distinctRoom = invent.getRoom();
        inventName.add(distinctRoom.getRoomName());
        int x = 0;
        for(Room r : roomIdList){
            if(r.getRoomId() == distinctRoom.getRoomId())   
                x++;
        } //sad
        if(x==0)
        roomIdList.add(distinctRoom);
    }

    inventoryAttach.setList(updatedInvents);
        map.addAttribute("attachInvents", inventoryAttach);

        
            List<Inventory> invents = inventRepo.getInventoryByRoomId(id);
        //ArrayList<Inventory> currentQuant = new ArrayList<Inventory>(invents);

        
        map.addAttribute("invents", invents);
        map.addAttribute("roomInvents", roomInvents);
        map.addAttribute("room", roomIdList);
    return new ModelAndView("updateinvent");


}

@RequestMapping(value = "viewroom/{id}/viewequip/equiplogs/{eid}")
public ModelAndView viewEquipmentLogs(@PathVariable("eid") long eid, ModelMap map){

   //sad

   map.addAttribute("equipLog", equipmentLogRepo.findAllByEqId(eid));

    return new ModelAndView("equiplogs");
}


}
