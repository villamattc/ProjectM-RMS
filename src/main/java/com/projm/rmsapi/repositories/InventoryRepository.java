package com.projm.rmsapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import com.projm.rmsapi.entities.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{

    @Query(value = "SELECT * FROM Inventory ORDER BY invent_current_quantity", nativeQuery = true)
    public List<Inventory> descendingInventoryQuant();

    @Query(value = "SELECT * FROM inventory i WHERE i.room_id=? ORDER BY invent_current_quantity", nativeQuery = true)
    public List<Inventory> getInventoryByRoomId(Long id);

    public Inventory findByInventId(Long id);
    
    @Transactional
    public void deleteByInventId(Long id);
}