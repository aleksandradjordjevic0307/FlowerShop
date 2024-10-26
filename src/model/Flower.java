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
public class Flower {
    
    private int id;
    private String name;
    private FlowerType type;
    private String color;
    private int yearOfArrival;
    private Supplier supplier;

    public Flower(String name, FlowerType type, String color, int yearOfArrival, Supplier supplier) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.yearOfArrival = yearOfArrival;
        this.supplier = supplier;
    }

    public Flower(int id, String name, FlowerType type, String color, int yearOfArrival, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = color;
        this.yearOfArrival = yearOfArrival;
        this.supplier = supplier;
    }
    
    

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FlowerType getType() {
        return type;
    }

    public void setType(FlowerType type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYearOfArrival() {
        return yearOfArrival;
    }

    public void setYearOfArrival(int yearOfArrival) {
        this.yearOfArrival = yearOfArrival;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Flower other = (Flower) obj;
        if (this.yearOfArrival != other.yearOfArrival) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return Objects.equals(this.color, other.color);
    }

    @Override
    public String toString() {
        return "Flower{" + "name=" + name + ", type=" + type + ", color=" + color + ", yearOfArrival=" + yearOfArrival + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
