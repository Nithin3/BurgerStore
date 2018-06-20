package com.Nithin;

//-----------------------------------------------------------------------------------------------------------
/*CSE 205: <Class 17566> / <MW 4.35PM-5.50PM>

Assignment: <Assignment 6>
Package : com.Nithin;

Author: <Nithin Sagar Nallagula> & <1212968092>

Description: <Delux Hamburger class which manages the Delux hamburger food item the company has
                This is the extended class of the Base Hamburger class and it's methods>*/
//------------------------------------------------------------------------------------------------------------
import java.io.File;
import java.util.Scanner;


public class DeluxBurger extends HealthyBurger {

    //instance variables
    private boolean chips;
    private double priceChips;
    private boolean coke;
    private double priceCoke;
    private boolean frenchFries;
    private double priceFrenchFries;

    private int count = 0;
    private double price;
    private int itemsCount;

    //constructor
    public DeluxBurger(String meat, double price) {
        super(meat, price);
        this.chips = false;
        this.coke = false;
        this.frenchFries = false;
        this.itemsCount =0;

        //trying to find the file which has the additions's prices
        try {
            Scanner scan = new Scanner(new File("DeluxBurger.txt"));

            this.priceChips = scan.nextDouble();
            this.priceCoke = scan.nextDouble();
            this.priceFrenchFries = scan.nextDouble();

        }catch (Exception e){
            System.out.println("File not found");
        }
    }

    //if the user says yes, add the addition's price to the total bill
    public void isChips(boolean yes){

        if (yes == true){
            count++;

            if (itemsCount < super.getItemsCount()) {
                this.itemsCount = super.getItemsCount();
                itemsCount++;
            }else {
                itemsCount++;
            }
            if (price < super.getPrice()) {
                this.price = super.getPrice();
                price += priceChips;
            }else {
                price += priceChips;
            }
        }

    }

    //if the user says yes, add the addition's price to the total bill
    public void isCoke(boolean yes){

        if (yes == true){
            count++;
            if (itemsCount < super.getItemsCount()) {
                this.itemsCount = super.getItemsCount();
                itemsCount++;
            }else {
                itemsCount++;
            }
            if (price < super.getPrice()) {
                this.price = super.getPrice();
                price += priceCoke;
            }else {
                price += priceCoke;
            }
        }

    }

    //if the user says yes, add the addition's price to the total bill
    public void isFrenchFries(boolean yes){

        if (yes == true){
            count++;
            if (itemsCount < super.getItemsCount()) {
                this.itemsCount = super.getItemsCount();
                itemsCount++;
            }else {
                itemsCount++;
            }
            if (price < super.getPrice()) {
                this.price = super.getPrice();
                price += priceFrenchFries;
            }else {
                price += priceFrenchFries;
            }
        }

    }

    //get method to get the price
    @Override
    public double getPrice() {
        //System.out.println(super.getPrice());
        if (count ==0){
           this.price = super.getPrice();
        }
        return price;
    }

    //get method to get the number of items choosen
    @Override
    public int getItemsCount() {
        if (count ==0){
             this.itemsCount = super.getItemsCount();
        }
        return itemsCount;
    }
}
