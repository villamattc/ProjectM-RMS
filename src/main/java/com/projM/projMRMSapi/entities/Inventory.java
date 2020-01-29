package com.projM.projMRMSapi.entities;


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
    private long invent_id;

    private String invent_name;

    private int invent_currentQuantity;

    private int invent_maxQuantity;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;


    public int getInvent_maxQuantity() {
        return invent_maxQuantity;
    }

    public String getInvent_name() {
        return invent_name;
    }

    public void setInvent_name(String invent_name) {
        this.invent_name = invent_name;
    }

    public int getInvent_currentQuantity() {
        return invent_currentQuantity;
    }

    public void setInvent_currentQuantity(int invent_currentQuantity) {
        this.invent_currentQuantity = invent_currentQuantity;
    }

    public void setInvent_maxQuantity(int invent_maxQuantity) {
        this.invent_maxQuantity = invent_maxQuantity;
    }





}