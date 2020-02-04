package com.projM.projMRMSapi.services;

import com.projM.projMRMSapi.entities.Room;
import com.projM.projMRMSapi.repositories.RoomRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class RoomService{

    @Autowired
    private RoomRepo roomRepo;
    
    public boolean saveRoom(Room room){
        Room savedRoom = roomRepo.saveAndFlush(room);
        if(savedRoom!=null){
            return true;
        }
        return false;
    }

    public Room updateRoom(Room room){

        Room updateRoom = roomRepo.findByRoom_id(room.getRoom_id());
        updateRoom.setInfo(room);
        return updateRoom;
    }



}