package com.caresoft.clinicapp;

public class User {
    protected Integer id;
    protected int pin;
    
    // TO DO: Getters and setters
    public Integer getId() {
    	return id;
    }
    public void setId(Integer id) {
    	this.id = id;
    }
    
    public Integer getPin() {
    	return pin;
    }
    public void setPin(int PIN) {
    	this.pin = PIN;
    }
    // Implement a constructor that takes an ID
    public User() {
    	
    }
    
    public User(Integer id) {
    	this.id = id;
    }
}

