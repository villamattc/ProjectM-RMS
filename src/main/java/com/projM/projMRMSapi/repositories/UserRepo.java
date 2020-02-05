package com.projM.projMRMSapi.repositories;


import com.projM.projMRMSapi.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Long>{
    

}