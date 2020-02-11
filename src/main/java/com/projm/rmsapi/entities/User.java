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

    private String nationality;

    private int age;

    private String occupation;
    // refers to the number of visits
    //private int visits; // removed cuz u can just count in the log or smthing idk

    private int businessOrvacay;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public User(){
    }
    public User(String lastName, String firstName, Date checkin, Date checkout, String nationality, int age, String occupation, int businessOrvacay){
       
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
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
