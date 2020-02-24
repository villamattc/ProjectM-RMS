package com.projm.rmsapi.repositories;

import com.projm.rmsapi.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

    public Admin findByAdminId(Long id);
    public Admin findByUsername(String username);
    

}