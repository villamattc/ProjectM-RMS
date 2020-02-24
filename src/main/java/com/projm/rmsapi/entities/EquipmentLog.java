package com.projm.rmsapi.entities;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.tomcat.jni.Time;

public class EquipmentLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long equipLogId;

    private Time logTime;

    private Date logDate;

    private String username;

    private Long equipId;

    private static Equipment equipmentChanges;

    private String changeDescription;

    public Time getLogTime() {
        return logTime;
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

    public static Equipment getEquipmentChanges() {
        return equipmentChanges;
    }

    public static void setEquipmentChanges(Equipment equipmentChanges) {
        EquipmentLog.equipmentChanges = equipmentChanges;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public void setLogTime(Time logTime) {
        this.logTime = logTime;
    }

    








}