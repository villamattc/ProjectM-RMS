package com.projM.projMRMSapi.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long room_id;

    private String room_name;

    private int room_status;

    private boolean room_toClean = false;

    @OneToMany(mappedBy="room")
    private Set<Inventory> invents = new HashSet<>();

    @OneToMany(mappedBy="room")
    private Set<Equipment> equips = new HashSet<>();

    @OneToMany(mappedBy="room")
    private Set<User> users= new HashSet<>();


    public String getRoom_name() {
        return room_name;
    }

    public boolean isRoom_toClean() {
        return room_toClean;
    }

    public void setRoom_toClean(boolean room_toClean) {
        this.room_toClean = room_toClean;
    }

    public int getRoom_status() {
        return room_status;
    }

    public void setRoom_status(int room_status) {
        this.room_status = room_status;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }



    


}