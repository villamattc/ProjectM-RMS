package com.projm.rmsapi.entities;

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

    private boolean room_Clean = false;



    @OneToMany(mappedBy = "room")
    private Set<Inventory> invents = new HashSet<>();

    @OneToMany(mappedBy = "room")
    private Set<Equipment> equips = new HashSet<>();

    @OneToMany(mappedBy = "room")
    private Set<User> users = new HashSet<>();


    public Room(){}

    public Room(String name, int status, boolean clean){
        this.room_name= name;
        this.room_status=status;
        this.room_Clean=clean;
    }


    public Long getRoom_id(){
        return this.room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public boolean isRoom_Clean() {
        return room_Clean;
    }

    public void setRoom_Clean(boolean room_Clean) {
        this.room_Clean = room_Clean;
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

    public Set<Inventory> getInvents(){
        return this.invents;
    }
    public Set<Equipment> getEquips(){
        return this.equips;
    }
    public Set<User> getUsers(){
        return this.users;
    }

    public void setInfo(Room room){
        this.room_name=room.getRoom_name();
        this.room_status=room.getRoom_status();
        this.room_Clean = room.isRoom_Clean();
        this.invents = room.getInvents();
        this.equips = room.getEquips();
        this.users = room.getUsers();
    }


    


}