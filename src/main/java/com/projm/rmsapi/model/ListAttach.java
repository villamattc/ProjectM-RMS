package com.projm.rmsapi.model;

import java.util.List;

import com.projm.rmsapi.entities.Inventory;

public class ListAttach {

    private String attach;

    private List<Inventory> list;

    public String getAttach() {
        return attach;
    }

    public List<Inventory> getList() {
        return list;
    }

    public void setList(List<Inventory> list) {
        this.list = list;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }



}