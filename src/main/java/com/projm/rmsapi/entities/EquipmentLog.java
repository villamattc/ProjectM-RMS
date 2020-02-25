package com.projm.rmsapi.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EQUIPMENTLOG")
public class EquipmentLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long equipLogId;

    private LocalTime logTime;

    private LocalDate logDate;

    private String username;

    private Long equipId;

    private Equipment equipmentChanges;

    private String changeDescription;

    public LocalTime getLogTime() {
        return logTime;
    }

    public Equipment getEquipmentChanges() {
        return equipmentChanges;
    }

    public void setEquipmentChanges(Equipment equipmentChanges) {
        this.equipmentChanges = equipmentChanges;
    }

    public Long getEquipId() {
        return equipId;
    }

    public void setEquipId(Long equipId) {
        this.equipId = equipId;
    }

    public String getChangeDescription() {
        return changeDescription;
    }

    public void setChangeDescription(String changeDescription) {
        this.changeDescription = changeDescription;
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