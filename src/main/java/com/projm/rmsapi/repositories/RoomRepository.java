package com.projm.rmsapi.repositories;

import com.projm.rmsapi.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

    public Room findByRoomName(String roomName);
    public Room findByRoomId(Long id);
    // public List<Room> findAllByRoomStatus(int status);
    public abstract List<Room> findAllByRoomStatus(int status);
    // public List<Inventory> findAllBy
    public int countByRoomType(int rType);

    public int countByRoomStatus(int status);


    @Query(value = "SELECT room_name FROM room WHERE room.room_status = 1" ,nativeQuery = true)
    public List<String> findVacantRoomNameList();

    @Query(value = "SELECT room_name FROM room WHERE room.room_status = 2" ,nativeQuery = true)
    public List<String> findOccupiedRoomNameList();

    @Query(value = "SELECT room_name FROM room WHERE room.room_status = 3" ,nativeQuery = true)
    public List<String> findReservedRoomNameList();

    @Transactional
    public void deleteByRoomId(Long id);



}