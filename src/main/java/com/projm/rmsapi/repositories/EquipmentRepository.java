package com.projm.rmsapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import com.projm.rmsapi.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long>{

    
    public List<Equipment> findAllByEquipStatus(int status);
    
    @Query(value = "SELECT * FROM inventory i WHERE i.room_id=? ", nativeQuery = true)
    public List<Equipment> findAllByRoomId(Long id);

    public Equipment findByEquipId(Long id);
    public Equipment findByEquipName(String equipName);
    public int countByEquipStatus(int eqStatus);

    @Transactional
    public void deleteByEquipId(Long id);

    @Query(value = "SELECT DISTINCT room_id FROM inventory" ,nativeQuery = true)
    public List<Long> getDistinctRoomId();

    @Query(value = "SELECT * FROM equipment e WHERE e.date_of_last_maintenance + 60 < now() ORDER BY date_of_last_maintenance", nativeQuery = true )
    public List<Equipment> getEquipmentOneMonthBeforeMaintenance();
}