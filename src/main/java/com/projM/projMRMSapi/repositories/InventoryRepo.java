package com.projM.projMRMSapi.repositories;

import com.projM.projMRMSapi.entities.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Long>{


}