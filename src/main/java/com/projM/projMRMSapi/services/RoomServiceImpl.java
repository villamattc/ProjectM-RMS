package com.projM.projMRMSapi.services;

import java.util.List;

import com.projM.projMRMSapi.entities.Room;
import com.projM.projMRMSapi.repositories.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    RoomRepository roomRepo;

    public boolean saveRoom(Room room){
        Room savedRoom = roomRepo.saveAndFlush(room);
        
        if(savedRoom!=null){
            return true;
        }
        return false;
    }

    public boolean deleteRoomById(Long id){
        return roomRepo.deleteByRoom_id(id);
    }

    public Room updateRoom(Room room){
        Room updateRoom = roomRepo.findByRoom_id(room.getRoom_id());
        updateRoom.setInfo(room);
        return updateRoom;
    }

    public List<Room> getAllRooms(){
        return roomRepo.findAll();
    }

    




}