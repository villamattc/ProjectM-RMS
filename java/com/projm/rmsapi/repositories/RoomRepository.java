package com.projm.rmsapi.repositories;

import com.projm.rmsapi.entities.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

    public Room findByRoomName(Room room);
    public Room findByRoomId(Long id);
    //public boolean deleteByRoom_id(Long id);


}