package com.projM.projMRMSapi.repositories;

import com.projM.projMRMSapi.entities.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

    public Room findByRoom_id(Long id);
    public boolean deleteByRoom_id(Long id);

}