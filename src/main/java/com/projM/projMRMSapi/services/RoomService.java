package com.projM.projMRMSapi.services;

import java.util.List;

import com.projM.projMRMSapi.entities.Room;
import org.springframework.stereotype.Service;



@Service
public interface RoomService{

    public abstract boolean saveRoom(Room room);
    public abstract boolean deleteRoomById(Long id);
    public abstract Room updateRoom(Room room);
    public abstract List<Room> getAllRooms();

    
    



}