package com.projm.rmsapi.controllers;

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
    public ModelAndView testJsp(ModelMap map){

        List<Room> y = roomRepo.findAll();
        if(y.isEmpty())
            System.out.println("ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");


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
    public ModelAndView showusertestJsp(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);
        map.addAttribute("userlog", getRoom.getUsers());
        return new ModelAndView("test/indexshowusers");
    }


    @RequestMapping(value = "testroom")
    public ModelAndView testroom(ModelMap map){

        List<Room> y = roomRepo.findAll();
        if(y.isEmpty())
            System.out.println("ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");

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

     //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//asda


    @RequestMapping(value = "room")
    public ModelAndView Room(ModelMap map){

        //map.addAttribute("roomlist", roomRepo.findAll());

        Map<Integer, String> options = new HashMap<Integer, String>();
        options.put(1, "Vacant");
        options.put(2, "Occupied");
        options.put(3, "Reserved");

        List<Room> x = roomRepo.findAllByRoomStatus(1);
        List<Room> y = roomRepo.findAll();
        if(y.isEmpty())
            System.out.println("ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");

        if(x.isEmpty())
            System.out.println("fuck you reposirotyy go dieea;lkfsa;ldkfjlk");

        map.addAttribute("vacantRooms", roomService.getAllVacantRooms());
        map.addAttribute("occupiedRooms", roomService.getAllOccupiedRooms());
        map.addAttribute("reservedRooms", roomService.getAllReservedRooms()); //<c:forEach items="${vacantRooms}" var="item">
        map.addAttribute("options", options);




        return new ModelAndView("room", "room", new Room());


    }
    

//login
@RequestMapping(value = "login")
    public ModelAndView Login(ModelMap map){

        return new ModelAndView("login");
    }
//add user form
@RequestMapping(value = "room/{id}/adduserform")
    public ModelAndView AddUser(@PathVariable("id") long id, ModelMap map){

        Room getRoom = roomRepo.findByRoomId(id);

        map.addAttribute("roomId", id);
        map.addAttribute("room", getRoom);
        map.addAttribute("user", new User());
        return new ModelAndView("test/indexadduser");
    }

}
