package com.projm.rmsapi.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EQUIPMENT")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long equipId;

    private String equipName;

    private String equipStatus;

    private Date dateOfPurchase;

    private Date dateOfLastMaintenance;

    // refers to the life span according to the manufacturer
    private int functionalLife; 

    //  the 3 attributes below is a score system that determines whether the equipments 
    //  needs to have maintenance/repairs or be replace.. the criteria weight is determined by the engineer

    // score 1-100 based on presence and condition of the parts of the equipment
    private int completenessOfParts;

    // score 1-100 based on the outer physical appearance 
    private int appearance;

    // score 1-100 based on the how 
    private int functionality;

    


    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public void setRoom(Room room){
        this.room = room;
    }
    
    


}