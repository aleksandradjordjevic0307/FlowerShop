/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author Aleksandra
 */
public class Supplier {
    
    private int id;
    private String name;
    private String contactNumber;
    private int yearOfPartnership;
    private String description;

    public Supplier(String name, String contactNumber, int yearOfPartnership, String description) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.yearOfPartnership = yearOfPartnership;
        this.description = description;
    }

    public Supplier(int id, String name, String contactNumber, int yearOfPartnership, String description) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.yearOfPartnership = yearOfPartnership;
        this.description = description;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getYearOfPartnership() {
        return yearOfPartnership;
    }

    public void setYearOfPartnership(int yearOfPartnership) {
        this.yearOfPartnership = yearOfPartnership;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return   name + ", " + contactNumber;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Supplier other = (Supplier) obj;
        if (this.yearOfPartnership != other.yearOfPartnership) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.contactNumber, other.contactNumber)) {
            return false;
        }
        return Objects.equals(this.description, other.description);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
