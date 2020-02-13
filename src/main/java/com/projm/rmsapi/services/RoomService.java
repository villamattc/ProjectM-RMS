package com.projm.rmsapi.services;

import java.util.List;

import com.projm.rmsapi.entities.Room;


public interface RoomService{

    public abstract boolean saveRoom(Room room);
    public abstract boolean deleteRoomById(Long id);
    //public abstract Room updateRoom(Room room);
    public abstract List<Room> getAllRooms();
    public abstract List<Room> getAllVacantRooms();
    public abstract List<Room> getAllOccupiedRooms();
    public abstract List<Room> getAllReservedRooms();


}