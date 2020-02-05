package com.projM.projMRMSapi.repositories;

import com.projM.projMRMSapi.entities.Equipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long>{


}