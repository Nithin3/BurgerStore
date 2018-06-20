package com.Nithin;

//-----------------------------------------------------------------------------------------------------------
/*CSE 205: <Class 17566> / <MW 4.35PM-5.50PM>

Assignment: <Assignment 6>
Package : com.Nithin;

Author: <Nithin Sagar Nallagula> & <1212968092>

Description: <class called Customer which helps to add the information a customer has like name, phone number etc
                to a customer object>*/
//------------------------------------------------------------------------------------------------------------

//Customer class
public class Customer {

    //Instance Variables
    private String name;
    private String phoneNumber;
    private String itemPurchased;
    private double bill;

    //Default constructor
    public Customer() {
        name = "";
        phoneNumber = "";
    }

    //Customer constructor
    public Customer(String name, String phoneNumber, String itemPurchased, double bill){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.itemPurchased = itemPurchased;
        this.bill = bill;
    }

    //get method
    public double getBill() {
        return bill;
    }

    //set method
    public void setBill(double bill) {
        this.bill = bill;
    }

    //get method
    public String getItemPurchased() {
        return itemPurchased;
    }

    //set method
    public void setItemPurchased(String itemPurchased) {
        this.itemPurchased = itemPurchased;
    }

    //get method
    public String getName() {
        return name;
    }

    //set method
    public void setName(String name) {
        this.name = name;
    }

    //set method
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //get method
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
