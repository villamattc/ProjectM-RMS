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
    private Long roomId;

    private String roomName;

    private int roomStatus;

    private boolean roomClean = false;

    @OneToMany(mappedBy = "room")
    private Set<Inventory> invents = new HashSet<>();

    @OneToMany(mappedBy = "room")
    private Set<Equipment> equips = new HashSet<>();

    @OneToMany(mappedBy = "room")
    private Set<User> users = new HashSet<>();

    public Room() {
    }
    public Room(String name, int status, boolean clean) {
        this.setRoomName(name);
        this.setRoomStatus(status);
        this.setRoomClean(clean);
    }
    public Room(String name, int status){
        this.setRoomName(name);
        this.setRoomStatus(status);
    }

    public Long getRoomId(){
        return this.roomId;
    }
    public void setRoomId(Long id){
        this.roomId=id;
    }

    public boolean isRoomClean() {
        return roomClean;
    }

    public void setRoomClean(boolean roomClean) {
        this.roomClean = roomClean;
    }

    public int getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(int roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }



    public Set<Inventory> getInvents() {
        return this.invents;
    }

    public Set<Equipment> getEquips() {
        return this.equips;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users){
        this.users=users;
    }
    public void setEquips(Set<Equipment> equips){
        this.equips=equips;
    }
    public void setInvents(Set<Inventory> invents){
        this.invents=invents;
    }

    public void setInfo(Room room) {
        this.setRoomName(room.getRoomName());
        this.setRoomStatus(room.getRoomStatus());
        this.setRoomClean(room.isRoomClean());
        this.invents = room.getInvents();
        this.equips = room.getEquips();
        this.users = room.getUsers();
    }

    // public void addUser(User user){
    //     Set<User> newUser = this.getUsers();
    //     newUser.add(user);
    //     this.setUsers(newUser);
    // }
    // public void addInvent(Inventory invent){
    //     Set<Inventory> newInvent = this.getInvents();
    //     newInvent.add(invent);
    //     this.setInvents(newInvent);
    // }
    // public void addEquip(Equipment equip){
    //     Set<Equipment> newEquip = this.getEquips();
    //     newEquip.add(equip);
    //     this.setEquips(newEquip);
    // }

    public void addUser(User u){
        users.add(u);
        u.setRoom(this);
    }
    


}