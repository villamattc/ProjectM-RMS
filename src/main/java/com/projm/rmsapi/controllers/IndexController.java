package com.projm.rmsapi.controllers;

import com.projm.rmsapi.entities.Admin;
import com.projm.rmsapi.entities.Equipment;
import com.projm.rmsapi.entities.Inventory;
import com.projm.rmsapi.entities.Room;
import com.projm.rmsapi.entities.User;
import com.projm.rmsapi.repositories.RoomRepository;
import com.projm.rmsapi.repositories.UserRepository;
import com.projm.rmsapi.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController{

    @Autowired
    private  RoomService roomService;
    @Autowired
    private RoomRepository roomRepo;
    @Autowired
    private UserRepository userRepo;

    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@TESTING VIEW@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    @RequestMapping(value = "testindex")
    public ModelAndView testJsp(ModelMap map, HttpSession session){
        String username = (String)session.getAttribute("userSession");
        if(username == null){
            return new ModelAndView("test/testlogin");
        }

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
    public ModelAndView testlogin(HttpSession session){

        String x = (String)session.getAttribute("userSession");

        if(session.getAttribute("userSession")==null){
            return new ModelAndView("test/testlogin");
        }
        System.out.println("wtf is going on la????"+x+x+x+x+x+x);
        return new ModelAndView("redirect:/testindex");
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

    @RequestMapping(value = "createadminpage")
    public ModelAndView createAdminPage(ModelMap map){


        map.addAttribute("admin", new Admin());
        return new ModelAndView("test/createadminpage");
    }

     //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//asda


    @RequestMapping(value = "room")
    public ModelAndView Room(ModelMap map){

        //map.addAttribute("roomlist", roomRepo.findAll());

        Map<Integer, String> options = new HashMap<Integer, String>();
        options.put(1, "Vacant");
        options.put(2, "Occupied");
        options.put(3, "Reserved");

        map.addAttribute("vacantRooms", roomService.getAllVacantRooms());
        map.addAttribute("occupiedRooms", roomService.getAllOccupiedRooms());
        map.addAttribute("reservedRooms", roomService.getAllReservedRooms()); //<c:forEach items="${vacantRooms}" var="item">
        map.addAttribute("options", options);

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

}
