package com.projm.rmsapi.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EQUIPMENT")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long equipId;

    private String equipName;

    // Good, Needs Repair, Needs Maintenance, Needs to be replaced // MAYBE
    // CONNECTED TO ASSESSMENT SCORE
    private int equipStatus;

    private Date dateOfPurchase;

    private Date dateOfLastMaintenance;

    // refers to the life span according to the manufacturer in years
    private int functionalLife;

    // the 3 attributes below is a score system that determines whether the
    // equipments
    // needs to have maintenance/repairs or be replace.. the criteria weight is
    // determined by the engineer

    // score 1-100 based on presence and condition of the parts of the equipment 35%
    private int completenessOfParts = 0;

    // score 1-100 based on the outer physical appearance 20%
    private int appearance = 0;

    // score 1-100 based on the how 45%
    private int functionality = 0;

    private double assessmentScore = 0;

    private String description;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public Equipment() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Equipment(String equipName,
            int equipStatus,
            Date dateOfPurchase, 
    Date dateOfLastMaintenance, int functionalLife){
        this.equipName=equipName;
        this.equipStatus=equipStatus;
        this.dateOfPurchase=dateOfPurchase;
        this.dateOfLastMaintenance=dateOfLastMaintenance;
        this.functionalLife=functionalLife;
        
    }

    public Room getRoom(){
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public int getFunctionalLife() {
        return functionalLife;
    }

    public void setFunctionalLife(int functionalLife) {
        this.functionalLife = functionalLife;
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
    
    public Long getEquipId(){
        return this.equipId;
    }

    public double getAssessmenScore(){
        return this.assessmentScore;
    }

    public void setAssessmentScore(double assessmentScore){
        this.assessmentScore=assessmentScore;
    }

    public double computeAssessmentScore(){
        this.assessmentScore = completenessOfParts * .35 + appearance * .20 + functionality * .45;
        return this.assessmentScore;
    }


}