/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Flower;


/**
 *
 * @author Aleksandra
 */
public class ModelOfTable extends AbstractTableModel{
    
    //redovi
    List<Flower> flowers = controller.Controller.getInstance().getFlowers();

    //kolone
    private String[] columns = {"Name", "Type", "Color", "Year of arrival", "Supplier"};

    public ModelOfTable(List<Flower> flowerList) {
        this.flowers=flowerList;
    }
    
    @Override
    public int getRowCount() {
        return flowers.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Flower f = flowers.get(rowIndex);
        switch(columnIndex){
            case 0:
                return f.getName();
            case 1: 
                return f.getType();
            case 2: 
                return f.getColor();
            case 3: 
                return f.getYearOfArrival();
            case 4:
                return f.getSupplier();
            default:
                return null;
                
        }
        
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
   
    public void refreshData(){
        fireTableDataChanged();
    }
    
    
}
