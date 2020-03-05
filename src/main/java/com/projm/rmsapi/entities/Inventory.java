package com.projm.rmsapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTORY")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inventId;

    private String inventName;

    private int inventCurrentQuantity;

    private int inventMaxQuantity;

 

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public Inventory(){}
    public Inventory(final Long inventId, final String inventName, final int inventCurrentQuantity, final int inventMaxQuantity){
        this.inventId=inventId;
        this.inventName=inventName;
        this.inventCurrentQuantity=inventCurrentQuantity;
        this.inventMaxQuantity=inventMaxQuantity;
    }

    public Long getInventId() {
        return inventId;
    }

    public Long setInventId(Long inventId) {
        return inventId;
    }

    public String getInventName() {
        return inventName;
    }

    public int getInventMaxQuantity() {
        return inventMaxQuantity;
    }

    public void setInventMaxQuantity(final int inventMaxQuantity) {
        this.inventMaxQuantity = inventMaxQuantity;
    }

    public int getInventCurrentQuantity() {
        return inventCurrentQuantity;
    }

    public void setInventCurrentQuantity(final int inventCurrentQuantity) {
        this.inventCurrentQuantity = inventCurrentQuantity;
    }

    public void setInventName(final String inventName) {
        this.inventName = inventName;
    }

    public void setRoom(final Room room){
        this.room = room;
    }

    public Room getRoom(){
        return this.room;
    }
    
   

 
}