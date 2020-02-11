package com.projm.rmsapi.repositories;

import com.projm.rmsapi.entities.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{


}