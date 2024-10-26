/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Flower;
import model.FlowerType;
import model.Supplier;


/**
 *
 * @author Aleksandra
 */
public class DBBroker {

    public List<Flower> getFlowerListFromDataBase() {
        List<Flower> flowerList = new ArrayList<>();
        try {
            String query = "SELECT * FROM FLOWER f JOIN SUPPLIER s ON f.supplier=s.id";
            
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            
            while(rs.next()){
               
                int id = rs.getInt("f.id");
                String name = rs.getString("f.name");
                String ft = rs.getString("f.type");
                FlowerType type = FlowerType.valueOf(ft);
                String color = rs.getString("f.color");
                int yoa = rs.getInt("f.yearOfArrival");
                 
                
                int suppId= rs.getInt("s.id");
                String suppName = rs.getString("s.name");
                String conNumber = rs.getString("s.contactNumber");
                int yop = rs.getInt("yearOfPartnership");
                String desc = rs.getString("description");
               
                
                Supplier supplier = new Supplier(suppId, suppName, conNumber, yop, desc);
                Flower flower = new Flower(id, name, type, color, yoa, supplier);
                
          
                flowerList.add(flower);
                
                DBConnection.getInstance().getConnection().commit();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flowerList;
    }

    public List<Supplier> getSuppliersFromDatabase() {
        List<Supplier> suppliers = new ArrayList<>();
        try {
            String query = "SELECT * FROM SUPPLIER";
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String conNum = rs.getString("contactNumber");
                int yop = rs.getInt("yearOfPartnerShip");
                String desc = rs.getString("description");
                
                Supplier sup = new Supplier(id, name, conNum, yop, desc);
                suppliers.add(sup);
            }    
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    return suppliers;
    }

    public void deleteFlowerFromDatabase(Flower flower) {
        try {
            String query = "delete from flower where id=?";
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, flower.getId());
            
            ps.executeUpdate();
            DBConnection.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addFlowerToDatabase(Flower f) {
        try {
            String query = "INSERT INTO flower(NAME, TYPE, color, yearOfArrival, supplier) VALUES (?,?,?,?,?)";
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setString(1, f.getName());
            ps.setString(2, f.getType().toString());
            ps.setString(3, f.getColor());
            ps.setInt(4, f.getYearOfArrival());
            ps.setInt(5,f.getSupplier().getId());
            
            ps.executeUpdate();
            DBConnection.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public void changeFlowerInDataBase(Flower flowerForChange) {
        try {
            String query = "UPDATE flower SET NAME=?, TYPE=?, color=?, yearOfArrival=?, supplier=? WHERE id=?";
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setString(1, flowerForChange.getName());
            ps.setString(2, flowerForChange.getType().toString());
            ps.setString(3, flowerForChange.getColor());
            ps.setInt(4, flowerForChange.getYearOfArrival());
            ps.setInt(5, flowerForChange.getSupplier().getId());
            ps.setInt(6, flowerForChange.getId());
            
            ps.executeUpdate();
            DBConnection.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
