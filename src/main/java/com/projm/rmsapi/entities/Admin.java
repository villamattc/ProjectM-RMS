package com.projm.rmsapi.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminId;

    private String username;
    private String password;
    private String name = "Admin";

    public Admin() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin(String username, String password) {

        this.setUsername(username);
        this.setPassword(password);
    }


    @Override
    public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o == null)
        return false;

    if (getClass() != o.getClass())
        return false;

    Admin admin = (Admin) o;

    return Objects.equals(username, admin.username)
            && Objects.equals(password, admin.password)
            && Objects.equals(name, admin.name);
}
}