package com.Nithin;


//-----------------------------------------------------------------------------------------------------------
/*CSE 205: <Class 17566> / <MW 4.35PM-5.50PM>

Assignment: <Assignment 6>
Package : com.Nithin;

Author: <Nithin Sagar Nallagula> & <1212968092>

Description: <Base Hamburger class which manages the Base hamburger food item the company has
                This is the base class of the programa and the classes of other two food items extend this class>*/
//------------------------------------------------------------------------------------------------------------

import java.io.File;
import java.util.Scanner;


public class BaseHamburger {

    //Instance Variables
    private String rollType;
    private String meat;
    private double price;
    private boolean lettuce;
    private double priceLettuce;
    private boolean tomato;
    private double priceTomato;
    private boolean carrot;
    private double priceCarrot;
    private boolean onions;
    private double priceOnions;
    private int itemsCount;

    //Constructor
    public BaseHamburger(String rollType, String meat, double price) {

        this.rollType = rollType;
        this.meat = meat;
        this.price = price;
        this.lettuce = false;
        this.carrot = false;
        this.onions = false;
        this.tomato = false;
        this.itemsCount = 0;

        //trying to find the file which has the additions's prices
        try {
            Scanner scan = new Scanner(new File("BaseHamburger.txt"));

            this.priceLettuce = scan.nextDouble();
            this.priceCarrot = scan.nextDouble();
            this.priceOnions = scan.nextDouble();
            this.priceTomato = scan.nextDouble();

        }catch (Exception e){
            System.out.println("File not found");
        }

    }


    //if the user says yes, add the addition's price to the total bill
    public void isLettuce(boolean yes){
        System.out.println();
        if (yes == true){
            itemsCount++;
            this.price += priceLettuce;
        }

    }

    //if the user says yes, add the addition's price to the total bill
    public void isOnions(boolean yes){

        if (yes == true){
            itemsCount++;
            price+=priceOnions;
        }

    }

    //if the user says yes, add the addition's price to the total bill
    public void isTomato(boolean yes){

        if (yes == true){
            itemsCount++;
            price+=priceTomato;
        }

    }

    //if the user says yes, add the addition's price to the total bill
    public void isCarrot(boolean yes){

        if (yes == true){
            itemsCount++;
            price+=priceCarrot;
        }

    }

    //get method to get the total price
    public double getPrice() {

        return price;
    }

    //get method to get the itemscount
    public int getItemsCount(){

        return itemsCount;
    }
}
