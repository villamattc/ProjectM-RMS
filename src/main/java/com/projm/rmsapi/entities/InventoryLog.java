package com.projm.rmsapi.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTORYLOG")
public class InventoryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inventLogId;

    private LocalTime logTime;

    private LocalDate logDate;

    private String username;

    private Long invent_id;

    // @@ CHANGES IN DESCRIPTION @@@@@@@@@

    private int currentQuantity;

    public LocalTime getLogTime() {
        return logTime;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public Long getInvent_id() {
        return invent_id;
    }

    public void setInvent_id(Long invent_id) {
        this.invent_id = invent_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public void setLogTime(LocalTime logTime) {
        this.logTime = logTime;
    }


    



}