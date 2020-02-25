package com.projm.rmsapi.services;

import java.util.List;

import com.projm.rmsapi.entities.Equipment;




public interface EquipmentLogService{

    public void addToLogs(Equipment e, String adminUsername, String changeDescription);

}