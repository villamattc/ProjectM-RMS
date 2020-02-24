package com.projm.rmsapi.repositories;

import com.projm.rmsapi.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

    public Room findByRoomName(String roomName);
    public Room findByRoomId(Long id);
    // public List<Room> findAllByRoomStatus(int status);
    public abstract List<Room> findAllByRoomStatus(int status);
    public boolean deleteByRoomId(Long id);

}