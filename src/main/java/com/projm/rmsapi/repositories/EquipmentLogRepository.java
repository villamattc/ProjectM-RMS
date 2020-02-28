package com.projm.rmsapi.repositories;

import com.projm.rmsapi.entities.EquipmentLog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentLogRepository extends JpaRepository<EquipmentLog, Long>{


}