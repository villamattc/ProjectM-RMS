package com.projm.rmsapi.repositories;

import java.util.List;

import com.projm.rmsapi.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long>{


    public List<Equipment> findAllByEquipStatus(int status);
    

}