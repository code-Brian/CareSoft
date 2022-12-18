package com.caresoft.clinicapp;

import java.util.Date;
import java.util.ArrayList;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
//... imports class definition...
    
    // Inside class:
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
    // TO DO: Implement a constructor that takes an ID and a role

    public AdminUser(Integer id, String role) {
    	this.id = id;
    	this.role = role;
    }
    // TO DO: Implement HIPAACompliantUser!
    public boolean assignPin(int pin) {
    	
    	if (Integer.toString(pin).length() < 6) {
    		return false;
    	}
    	return true;
    }
    
    public boolean accessAuthorized(Integer confirmedAuthID) {
//    	System.out.println("Access auth test with value: " + confirmedAuthID);
//    	System.out.println("Access auth id value: " + id);
    	if(confirmedAuthID == id) {
//    		System.out.println("Access auth test returned true!");
    		return true;	
    	} else {
    		authIncident();
    		return false;
    	}
    }
    
    // TO DO: Implement HIPAACompliantAdmin!
   public ArrayList<String> reportSecurityIncidents(){
	   return securityIncidents;
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    // TO DO: Setters & Getters
    
    public void setRole(String role) {
    	this.role = role;
    }
    
    public String getRole() {
    	return role;
    }
    
//    public void setSecurityIncidents() {
//    	this.securityIncidents = new ArrayList<String>();
//    }
    
    public ArrayList<String> getSecurityIncidents(){
    	return securityIncidents;
    }

}
