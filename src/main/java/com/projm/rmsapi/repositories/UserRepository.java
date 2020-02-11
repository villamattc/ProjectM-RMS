package com.projm.rmsapi.repositories;

import java.util.List;

import com.projm.rmsapi.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    

}