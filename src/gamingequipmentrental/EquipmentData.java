/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamingequipmentrental;

import java.sql.Date;

/**
 *
 * @author John
 */
public class EquipmentData {
    private Integer eqID;
    private String type;
    private String brand;
    private String model;
    private Double price;
    private String status;
    private Date date;
    private String image;
    
    public EquipmentData(Integer eqID, String type, String brand, String model, Double price, String status, String image, Date date) {
        this.eqID = eqID;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.status = status;
        this.image = image;
        this.date = date;
    }
    
    public Integer getEqID() {
        return eqID;
    }
    
    public String getType() {
        return type;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public String getStatus() {
        return status;
    }
    
    public String getImage() {
        return image;
    }
    
    public Date getDate() {
        return date;
    }
}
