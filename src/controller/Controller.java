/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.sun.corba.se.pept.broker.Broker;
import database.DBBroker;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;
import model.Flower;
import model.Supplier;
import model.FlowerType;

/**
 *
 * @author Aleksandra
 */
public class Controller {
    
    List<Flower> flowers = new ArrayList<>();
    List<Supplier> suppliers = new ArrayList<>();
    private DBBroker dbBroker;
    
    private static Controller instance;
    
    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    private Controller() {
        
        dbBroker = new DBBroker();
        
        /*Supplier s1 = new Supplier("Blossom Haven", "+1 555-123-4567", 2015, "Specializes in sourcing rare and exotic flowers from around the world.");
        Supplier s2 = new Supplier("Petal Pros", "+1 555-987-6543", 2018, "Known for their high-quality roses and tulips, with a focus on sustainable farming practices.");
        Supplier s3 = new Supplier("Floral Creations", "+1 555-234-5678", 2020, "A local supplier offering a wide variety of seasonal flowers with fast delivery services.");
        
        Flower f1 = new Flower("Eternal Flame", FlowerType.ROSE, "red", 2021,s1);
        Flower f2 = new Flower("Golden Sunrise", FlowerType.TULIP, "yellow", 2019,s2);
        Flower f3 = new Flower("Snow Queen", FlowerType.ORCHID, "white", 2023,s3);
        Flower f4 = new Flower("Midnight Velvet", FlowerType.ROSE, "black", 2020,s2);
        
        suppliers.add(s1);
        suppliers.add(s2);
        suppliers.add(s3);
        
        flowers.add(f1);
        flowers.add(f2);
        flowers.add(f3);
        flowers.add(f4);*/
    
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void deleteFlower(Flower flower) {
       flowers.remove(flower);
    }

    public List<Flower> getFlowerListFromDatabase() {
       return  dbBroker.getFlowerListFromDataBase();
    }

    public List<Supplier> getSuppliersFromDatabase() {
        return dbBroker.getSuppliersFromDatabase();
    }

    public void deleteFlowerFromDatabase(Flower flower) {
        dbBroker.deleteFlowerFromDatabase(flower);
    }

    public void addFlowerToDatabase(Flower f) {
        dbBroker.addFlowerToDatabase(f);
    }

    public void updateFlowerInDatabase(Flower flowerForChange) {
        dbBroker.changeFlowerInDataBase(flowerForChange);
    }
    
    
    
}
