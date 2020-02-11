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
    private Long equip_id;

    private String equip_name;

    private String equip_status;

    private Date dateof_purchase;

    private Date dateof_lastMaintenance;


    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public String getEquip_name() {
        return equip_name;
    }

    public Date getDateof_lastMaintenance() {
        return dateof_lastMaintenance;
    }

    public void setDateof_lastMaintenance(Date dateof_lastMaintenance) {
        this.dateof_lastMaintenance = dateof_lastMaintenance;
    }

    public Date getDateof_purchase() {
        return dateof_purchase;
    }

    public void setDateof_purchase(Date dateof_purchase) {
        this.dateof_purchase = dateof_purchase;
    }

    public String getEquip_status() {
        return equip_status;
    }

    public void setEquip_status(String equip_status) {
        this.equip_status = equip_status;
    }

    public void setEquip_name(String equip_name) {
        this.equip_name = equip_name;
    }


    
    


}