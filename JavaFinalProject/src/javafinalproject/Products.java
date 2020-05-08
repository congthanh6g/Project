/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinalproject;

/**
 *
 * @author abc
 */
public class Products {
    int id , quantityinS ;
    String name , description ;
    float price;
    
    public Products()
    {
        
    }

    public Products(int id, int quantityinS, String name, String description, float price) {
        this.id = id;
        this.quantityinS = quantityinS;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantityinS() {
        return quantityinS;
    }

    public void setQuantityinS(int quantityinS) {
        this.quantityinS = quantityinS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
    
}
