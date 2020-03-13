package com.projm.rmsapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import com.projm.rmsapi.entities.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{

    public Inventory findByInventId(Long id);

    @Query(value = "SELECT * FROM Inventory ORDER BY invent_current_quantity", nativeQuery = true)
    public List<Inventory> ascInventoryQuant();

    @Query(value = "SELECT * FROM inventory i WHERE i.room_id=? ORDER BY invent_current_quantity", nativeQuery = true)
    public List<Inventory> getInventoryByRoomId(Long id);

    @Query(value = "SELECT room_name FROM room,inventory  WHERE inventory.room_id = room.room_id ORDER BY invent_current_quantity" ,nativeQuery = true)
    public List<String> ascInventoryQuantRoomName();

    @Query(value = "SELECT DISTINCT inventory.room_id FROM room,inventory WHERE inventory.room_id = room.room_id ORDER BY room_name ",nativeQuery = true)
    public List<Long> DistinctRoomIdWithInvetories();

    @Transactional
    public void deleteByInventId(Long id);
    
}