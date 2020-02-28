package com.projm.rmsapi.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    private Long eq_id;

    // @@ CHANGES IN DESCRIPTION @@@@@@@@@
    private String changeDescription;

    private String equipName;

    private int equipStatus;

    private Date dateOfPurchase;

    private Date dateOfLastMaintenance;

    private int completenessOfParts = 0;

    private int appearance = 0;

    private int functionality = 0;
    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    private double assessmentScore = 0;

    public LocalTime getLogTime() {
        return logTime;
    }

    public Long getEq_id() {
        return eq_id;
    }

    public void setEq_id(Long eq_id) {
        this.eq_id = eq_id;
    }

    public double getAssessmentScore() {
        return assessmentScore;
    }

    public void setAssessmentScore(double assessmentScore) {
        this.assessmentScore = assessmentScore;
    }

    public int getFunctionality() {
        return functionality;
    }

    public void setFunctionality(int functionality) {
        this.functionality = functionality;
    }

    public int getAppearance() {
        return appearance;
    }

    public void setAppearance(int appearance) {
        this.appearance = appearance;
    }

    public int getCompletenessOfParts() {
        return completenessOfParts;
    }

    public void setCompletenessOfParts(int completenessOfParts) {
        this.completenessOfParts = completenessOfParts;
    }

    public Date getDateOfLastMaintenance() {
        return dateOfLastMaintenance;
    }

    public void setDateOfLastMaintenance(Date dateOfLastMaintenance) {
        this.dateOfLastMaintenance = dateOfLastMaintenance;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public int getEquipStatus() {
        return equipStatus;
    }

    public void setEquipStatus(int equipStatus) {
        this.equipStatus = equipStatus;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
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


    public void saveToLogs(Long id, Equipment e, String username, String changeDescription){

        this.logTime = java.time.LocalTime.now();
        this.logDate = java.time.LocalDate.now();
        this.changeDescription=changeDescription;
        this.username = username;
        this.eq_id = id;
        this.equipName = e.getEquipName();
        this.equipStatus = e.getEquipStatus();
        this.dateOfPurchase = e.getDateOfPurchase();
        this.dateOfLastMaintenance = e.getDateOfLastMaintenance();
        this.completenessOfParts = e.getCompletenessOfParts();
        this.appearance = e.getAppearance();
        this.functionality = e.getFunctionality();
    }


}