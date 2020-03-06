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
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    private String lastName;

    private String firstName;

    private Date checkin;

    private Date checkout;

    private int nationality;

    private int age;

    private int adults;

    private int children;

    private String occupation;
    // refers to the number of visits
    
    // 1 for business and 2 for vacation
    private int businessOrvacay;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public User() {
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public User(String lastName, String firstName, Date checkin, Date checkout, int nationality, int age,
            String occupation, int businessOrvacay) {
       
        this.lastName=lastName;
        this.firstName=firstName;
        this.checkin=checkin;
        this.checkout=checkout;
        this.nationality=nationality;
        this.age=age;
        this.occupation=occupation;
        this.businessOrvacay=businessOrvacay;
    }


    public String getLastName() {
        return lastName;
    }

    public int getBusinessOrvacay() {
        return businessOrvacay;
    }

    public void setBusinessOrvacay(int businessOrvacay) {
        this.businessOrvacay = businessOrvacay;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNationality() {
        return nationality;
    }

    public void setNationality(int nationality) {
        this.nationality = nationality;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setRoom(Room room){
        this.room = room;
    }
    

}
