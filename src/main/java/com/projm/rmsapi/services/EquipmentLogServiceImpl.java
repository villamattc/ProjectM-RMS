package com.projm.rmsapi.services;

import java.util.List;

import com.projm.rmsapi.entities.Equipment;
import com.projm.rmsapi.entities.EquipmentLog;
import com.projm.rmsapi.repositories.EquipmentLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentLogServiceImpl implements EquipmentLogService{

    @Autowired
    EquipmentLogRepository equipLogRepo;

    
    public void addToLogs(Equipment e, String adminUsername, String changeDescription){

        EquipmentLog eqLog = new EquipmentLog();

        eqLog.setLogTime(java.time.LocalTime.now());
        eqLog.setLogDate(java.time.LocalDate.now());
        eqLog.setEquipmentChanges(e);
        eqLog.setUsername(adminUsername);
        eqLog.setEquipId(e.getEquipId());
        eqLog.setChangeDescription(changeDescription);
        
        equipLogRepo.save(eqLog);


    }




    }

