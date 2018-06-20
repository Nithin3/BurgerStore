package com.Nithin;


//-----------------------------------------------------------------------------------------------------------
/*CSE 205: <Class 17566> / <MW 4.35PM-5.50PM>

Assignment: <Assignment 6>
Package : com.Nithin;

Author: <Nithin Sagar Nallagula> & <1212968092>

Description: <Healthy Hamburger class which manages the Helthy hamburger food item the company has
                This is the extended class of the Base Hamburger class and it's methods>*/
//------------------------------------------------------------------------------------------------------------
import java.io.File;
import java.util.Scanner;


public class HealthyBurger extends BaseHamburger{

    //instance variables
    private boolean cheese;
    private boolean olives;
    private double priceCheese;
    private double priceOlives;
    private int itemsCount;
    private double price;
    private int count = 0;

    //constructor
    public HealthyBurger( String meat, double price) {
        super("Wheat Bread", meat, price);
        this.cheese = false;
        this.olives = false;
        this.itemsCount=0;

        //trying to find the file which has the additions's prices
        try {
            Scanner scan = new Scanner(new File("HealthyBurger.txt"));

            this.priceCheese = scan.nextDouble();
            this.priceOlives = scan.nextDouble();


        }catch (Exception e){
            System.out.println("File not found");
        }
    }

    ////if the user says yes, add the addition's price to the total bill
    public void isOlives(boolean yes){

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
                price += priceOlives;
            }else {
                price += priceOlives;
            }
        }

    }
    //if the user says yes, add the addition's price to the total bill
    public void isCheese(boolean yes){

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
                price += priceCheese;
            }else {
                price += priceCheese;
            }

        }

    }
    //get method to get price
    @Override
    public double getPrice() {

        if (count == 0){
            this.price = super.getPrice();
        }
        return price;
    }

    //get method to get itemscount
    @Override
    public int getItemsCount() {
        if (count ==0){
            this.itemsCount = super.getItemsCount();
        }
        return itemsCount;
    }
}
