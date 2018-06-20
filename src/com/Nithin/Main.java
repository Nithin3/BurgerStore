package com.Nithin;

//-----------------------------------------------------------------------------------------------------------
/*CSE 205: <Class 17566> / <MW 4.35PM-5.50PM>

Assignment: <Assignment 6>
Package : com.Nithin;

Author: <Nithin Sagar Nallagula> & <1212968092>

Description: <My program is a data base management system. it's a burger store system which has two flexible
                options i.e office mode and customer mode. you can switch between both of them
                   It has three food items which the user can choose and respective chosable additions. Also,
                   the office mode enables office people to acces the customers entered on that particular day
                   It also enable office people to sor the customers entered according to their names.
                   It also enables them to know the profit made on a particular day.

                   The user should enter all the valid inputs
                   >*/
//------------------------------------------------------------------------------------------------------------


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    private static Scanner scan;

    public static void main(String[] args) {

        //Declaring arraylist of customers
        MyArrayList<Customer> customers = new MyArrayList<Customer>();

        double profitMade = 0;
        scan = new Scanner(System.in);
        boolean mainSwitch = false;


        //do while loop
        do {

            System.out.println("1) Office Mode");
            System.out.println("2) Customer Mode");
            System.out.println("3) Quit the whole application");
            int mainChoice = scan.nextInt();

            switch (mainChoice) {

                case 1:

                    officeMenu();
                    int officeChoice = scan.nextInt();

                    switch (officeChoice){

                        case 1:

                            for (int i = 0; i < customers.size(); i++){

                                System.out.println("Name: "+customers.at(i).getName() +
                                                    "   Phone Number: "+customers.at(i).getPhoneNumber()+
                                                    "   Item Purchased: "+customers.at(i).getItemPurchased()
                                                    );
                            }
                            break;

                        case 2:

                            for (int i = 0; i < customers.size(); i++){

                                System.out.println("Name: "+customers.at(i).getName() +
                                        "   Phone Number: "+customers.at(i).getPhoneNumber()+
                                        "   Item Purchased: "+customers.at(i).getItemPurchased()+
                                        "   Total Bill: "+ customers.at(i).getBill());

                            }
                            break;

                        case 3:
                            //Returned an array with sorted names

                            ArrayList<String> customerNames = new ArrayList<String>();

                            for (int i = 0; i < customers.size(); i++){
                                String name = customers.at(i).getName();
                                customerNames.add(i,name);
                            }

                            //returned the ArrayList after sorting the customer names
                            sortWithNames(customerNames);


                            for(int i = 0; i < customerNames.size(); i++){

                                for (int j = 0; j < customers.size(); j++){

                                    if (customerNames.get(i).equals(customers.at(j).getName())){

                                        //Swapping the object with the found object with the name in an ascending order
                                        Customer temp = customers.at(i);
                                        customers.setAt(i,customers.at(j));
                                        customers.setAt(j,temp);

                                    }

                                }
                            }

                            break;


                        case 4:
                            //Profit made by the company
                            System.out.println("WE MADE "+profitMade+"TODAY!!");
                            break;
                    }
                 break;

                case 2:

                    //To format the price
                    NumberFormat formatter = NumberFormat.getCurrencyInstance();
                    double totalBill = 0;
                    String reply;

                    System.out.println();
                    System.out.println("*************************************************** ");
                    System.out.println("            WELCOME TO BURGER STORE ");
                    System.out.println("*************************************************** ");

                    do {

                        System.out.println();
                        String customerName, tempString;

                        //do while loop to check if the input is legit
                        do {
                            System.out.println("Please enter your Name");
                            customerName = scan.next();
                            tempString = "abcd";
                            if (customerName.getClass() != tempString.getClass()){
                                System.out.println("Please enter name as a String");
                            }
                        }while (customerName.getClass() != tempString.getClass());

                        boolean isValidInteger = false;
                        String customerPhoneNumber;
                        //do while loop to check if the input is legit
                        do {
                            System.out.println("Please enter your Phone Number");
                            customerPhoneNumber = scan.next();
                            try
                            {
                                Integer.parseInt(customerPhoneNumber);

                                isValidInteger = true;
                            }
                            catch (NumberFormatException ex)
                            {
                                System.out.println("Please enter a valid Phone Number");
                            }

                        }while (!isValidInteger);

                        System.out.println();
                        printMenu();
                        System.out.println("What would you like today? \n" +
                                "Please select an option!");


                        int opt = scan.nextInt();
                        Scanner in = new Scanner(System.in);
                        System.out.println();

                        Customer tempCustomer = new Customer();
                        tempCustomer.setName(customerName);
                        tempCustomer.setPhoneNumber(customerPhoneNumber);


                        if (opt == 1){
                            tempCustomer.setItemPurchased("Basic Burger");
                        } else if (opt == 2) {
                            tempCustomer.setItemPurchased("Healthy Burger");
                        }else if (opt == 3){
                            tempCustomer.setItemPurchased("Deluxe Burger");
                        }else {
                            throw new InputMismatchException("You have only 3 options");
                        }


                        switch (opt) {


                            case 1:

                                String meat1;
                                //do while loop to check if the input is legit
                                do {
                                    System.out.println("What kind of meat would you like today?");
                                    meat1 = in.nextLine();
                                    if (meat1.getClass() != tempString.getClass()){
                                        System.out.println("Please enter meat as a String");
                                    }
                                }while (meat1.getClass() != tempString.getClass());

                                System.out.println();

                                String roll1;
                                //do while loop to check if the input is legit
                                do {
                                    System.out.println("What kind of a roll would you like today?");
                                    roll1 = in.nextLine();
                                    if (roll1.getClass() != tempString.getClass()){
                                        System.out.println("Please enter roll as a String");
                                    }
                                }while (roll1.getClass() != tempString.getClass());


                                System.out.println();
                                BaseHamburger hamburger = new BaseHamburger(roll1, meat1, 5.55);

                                System.out.println("You now have " + roll1 + " roll and the meat as " + meat1 + " for the base price of $5.55 ");
                                System.out.println();
                                System.out.println("We have 4 additions which are tomatoes, onions, lettuce and carrot for this Ham Burger today!");

                                System.out.println();
                                String choice1;
                                //do while loop to check if the input is legit
                                do {
                                    System.out.println("Would you like to add tomato? (yes/no)");
                                     choice1 = in.nextLine();

                                     //If the user wanted to choose addition, the price adds to the total bill
                                    //else not add that addition's money
                                    if (choice1.equals("yes")) {
                                        hamburger.isTomato(true);
                                    }else if (choice1.equals("no")) {
                                        hamburger.isTomato(false);
                                    }else {
                                        System.out.println("Please enter either yes or no");
                                    }
                                }while (choice1.getClass() != tempString.getClass());


                                System.out.println();
                                String choice2;
                                //do while loop to check if the input is legit
                                do {
                                    System.out.println("Would you like to add onions? (yes/no)");
                                    choice2 = in.nextLine();

                                    //If the user wanted to choose addition, the price adds to the total bill
                                    //else not add that addition's money
                                    if (choice2.equals("yes")) {
                                        hamburger.isOnions(true);
                                    }else if (choice2.equals("no")) {
                                        hamburger.isOnions(false);
                                    }else {
                                        System.out.println("Please enter either yes or no");
                                    }
                                }while (choice2.getClass() != tempString.getClass());

                                String choice3;
                                System.out.println();
                                //do while loop to check if the input is legit
                                do{
                                    System.out.println("Would you like to add lettuce? (yes/no)");
                                    choice3 = in.nextLine();

                                    //If the user wanted to choose addition, the price adds to the total bill
                                    //else not add that addition's money
                                    if (choice3.equals("yes")) {
                                        hamburger.isLettuce(true);
                                    }else if (choice3.equals("no")) {
                                        hamburger.isLettuce(false);
                                    }else {
                                        System.out.println("Please enter either yes or no");
                                    }
                                }while (choice3.getClass() != tempString.getClass());


                                System.out.println();

                                String choice4;
                                //do while loop to check if the input is legit
                                do {
                                    System.out.println("Would you like to add carrot? (yes/no)");
                                    choice4 = in.nextLine();
                                    //If the user wanted to choose addition, the price adds to the total bill
                                    //else not add that addition's money
                                    if (choice4.equals("yes")) {
                                        hamburger.isCarrot(true);
                                    }else if (choice4.equals("no")) {
                                        hamburger.isCarrot(false);
                                    }else {
                                        System.out.println("Please enter either yes or no");
                                    }
                                }while (choice4.getClass() != tempString.getClass());


                                System.out.println();
                                System.out.println("You selected " + hamburger.getItemsCount() + " additions to your Ham Burger");
                                System.out.println();
                                System.out.println("The price for this Ham Burger now is " + formatter.format(hamburger.getPrice()));
                                System.out.println();
                                totalBill += hamburger.getPrice();
                                profitMade += totalBill;

                                //setting the information of the paid bill to the customer object
                                tempCustomer.setBill(totalBill);

                                //creating a customer object
                                customers.add(tempCustomer);

                                break;

                            case 2:

                                System.out.println();
                                System.out.println("The fixed roll for this Ham Burger is Wheat Bread because you chose 'Healthy' Burger!");
                                System.out.println();
                                System.out.println("What kind of meat would you like today?");
                                String meat2 = in.nextLine();

                                System.out.println();
                                HealthyBurger healthyBurger = new HealthyBurger(meat2, 6.75);
                                System.out.println("You now have wheat bread and the meat as " + meat2 + " for the base price of $6.75");
                                System.out.println();
                                System.out.println("We have six additions which are tomatoes, onions, lettuce, carrot, cheese and olives for this Ham Burger today!");

                                System.out.println();
                                System.out.println("Would you like to add tomato? (yes/no)");
                                choice1 = in.nextLine();

                                //If the user wanted to choose addition, the price adds to the total bill
                                //else not add that addition's money
                                if (choice1.equals("yes")) {
                                    healthyBurger.isTomato(true);
                                }

                                System.out.println();
                                System.out.println("Would you like to add onions? (yes/no)");
                                choice2 = in.nextLine();

                                //If the user wanted to choose addition, the price adds to the total bill
                                //else not add that addition's money
                                if (choice2.equals("yes")) {
                                    healthyBurger.isOnions(true);
                                }

                                System.out.println();
                                System.out.println("Would you like to add lettuce? (yes/no)");
                                choice3 = in.nextLine();

                                //If the user wanted to choose addition, the price adds to the total bill
                                //else not add that addition's money
                                if (choice3.equals("yes")) {
                                    healthyBurger.isLettuce(true);
                                }

                                System.out.println();
                                System.out.println("Would you like to add carrot? (yes/no)");
                                choice4 = in.nextLine();

                                //If the user wanted to choose addition, the price adds to the total bill
                                //else not add that addition's money
                                if (choice4.equals("yes")) {
                                    healthyBurger.isCarrot(true);
                                }

                                System.out.println();
                                System.out.println("Would you like to add cheese? (yes/no)");
                                String choice5 = in.nextLine();

                                //If the user wanted to choose addition, the price adds to the total bill
                                //else not add that addition's money
                                if (choice5.equals("yes")) {
                                    healthyBurger.isCheese(true);
                                }

                                System.out.println();
                                System.out.println("Would you like to add olives? (yes/no)");
                                String choice6 = in.nextLine();

                                //If the user wanted to choose addition, the price adds to the total bill
                                //else not add that addition's money
                                if (choice6.equals("yes")) {
                                    healthyBurger.isOlives(true);
                                }


                                System.out.println();
                                System.out.println("You selected " + healthyBurger.getItemsCount() + " additions to your Ham Burger");
                                System.out.println();
                                System.out.println("The price for this Ham Burger now is " + formatter.format(healthyBurger.getPrice()));
                                System.out.println();
                                totalBill += healthyBurger.getPrice();
                                profitMade += totalBill;

                                tempCustomer.setBill(totalBill);
                                customers.add(tempCustomer);

                                break;

                            case 3:


                                System.out.println();
                                System.out.println("What kind of a roll would you like today?");
                                String roll3 = in.nextLine();
                                System.out.println();
                                System.out.println("You can choose more than one type of meat for this Ham Burger! What would you like?");
                                String meat3 = in.nextLine();
                                System.out.println();

                                DeluxBurger db = new DeluxBurger("Bacon and Chicken", 7.79);
                                System.out.println("You now have " + roll3 + " roll and the meat as " + meat3 + " for the base price of $7.99");
                                System.out.println();
                                System.out.println("We have nine additions which are tomatoes, onions, lettuce, carrot, cheese, olives, chips, french fries and coke for this Ham Burger today!");
                                System.out.println();

                                System.out.println("Would you like to add tomato? (yes/no)");
                                choice1 = in.nextLine();

                                //If the user wanted to choose addition, the price adds to the total bill
                                //else not add that addition's money
                                if (choice1.equals("yes")) {
                                    db.isTomato(true);
                                }

                                System.out.println();
                                System.out.println("Would you like to add onions? (yes/no)");
                                choice2 = in.nextLine();

                                //If the user wanted to choose addition, the price adds to the total bill
                                //else not add that addition's money
                                if (choice2.equals("yes")) {
                                    db.isOnions(true);
                                }

                                System.out.println();
                                System.out.println("Would you like to add lettuce? (yes/no)");
                                choice3 = in.nextLine();

                                //If the user wanted to choose addition, the price adds to the total bill
                                //else not add that addition's money
                                if (choice3.equals("yes")) {
                                    db.isLettuce(true);
                                }

                                System.out.println();
                                System.out.println("Would you like to add carrot? (yes/no)");
                                choice4 = in.nextLine();

                                //If the user wanted to choose addition, the price adds to the total bill
                                //else not add that addition's money
                                if (choice4.equals("yes")) {
                                    db.isCarrot(true);
                                }

                                System.out.println();
                                System.out.println("Would you like to add cheese? (yes/no)");
                                choice5 = in.nextLine();

                                //If the user wanted to choose addition, the price adds to the total bill
                                //else not add that addition's money
                                if (choice5.equals("yes")) {
                                    db.isCheese(true);
                                }

                                System.out.println();
                                System.out.println("Would you like to add olives? (yes/no)");
                                choice6 = in.nextLine();

                                //If the user wanted to choose addition, the price adds to the total bill
                                //else not add that addition's money
                                if (choice6.equals("yes")) {
                                    db.isOlives(true);
                                }

                                System.out.println();
                                System.out.println("Would you like to get chips? (yes/no)");
                                String choice7 = in.nextLine();

                                //If the user wanted to choose addition, the price adds to the total bill
                                //else not add that addition's money
                                if (choice7.equals("yes")) {
                                    db.isChips(true);
                                }

                                System.out.println();
                                System.out.println("Would you like to get french fries? (yes/no)");
                                String choice8 = in.nextLine();

                                //If the user wanted to choose addition, the price adds to the total bill
                                //else not add that addition's money
                                if (choice8.equals("yes")) {
                                    db.isFrenchFries(true);
                                }

                                System.out.println();
                                System.out.println("Would you like to get coke? (yes/no)");
                                String choice9 = in.nextLine();

                                //If the user wanted to choose addition, the price adds to the total bill
                                //else not add that addition's money
                                if (choice9.equals("yes")) {
                                    db.isCoke(true);
                                }

                                System.out.println();
                                System.out.println("You selected " + db.getItemsCount() + " additions to your Ham Burger");
                                System.out.println();
                                System.out.println("The price for this Ham Burger now is " + formatter.format(db.getPrice()));
                                System.out.println();

                                totalBill += db.getPrice();
                                profitMade += totalBill;

                                tempCustomer.setBill(totalBill);
                                customers.add(tempCustomer);

                                break;

                            default:
                                System.out.println("Invalid input");
                                printMenu();

                        }

                        System.out.println("Would you like anything more?");
                        reply = in.nextLine();
                        System.out.println();
                        if (reply.equals("yes")) {
                            System.out.println("Here is the menu:");
                            System.out.println();

                        } else {

                            System.out.println("Your total bill: " + formatter.format(totalBill));
                            System.out.println();
                            System.out.println("***************************************************");
                            System.out.println("           Thank you! Have a nice day!");
                            System.out.println("***************************************************");
                            break;

                        }

                    } while (reply != "yes");

                 break;


                case 3:
                    mainSwitch = true;
                    break;

            }


        } while (!mainSwitch);
    }

    //sorting the customers name using merge sort algorithm
    private static void sortWithNames(ArrayList<String> customerNames){


        int n = customerNames.size();
        int middle = n/2;

        if (n < 2){
            return;
        }

        //Creating two sub lists
        ArrayList<String> left = new ArrayList<String>();
        ArrayList<String> right = new ArrayList<String>();


        //Storing left elements of middle index from aList to left list
        for (int i = 0; i < middle; i++){
            left.add(customerNames.get(i));
        }

        //Storing left elements of middle index from aList to right list
        for (int j = middle; j < n; j++){
            right.add(customerNames.get(j));
        }

        //Recursive methods which help further divide the left and right lists
        sortWithNames(left);
        sortWithNames(right);

        //Finally merge the left and right lists by calling merge method
        mergeLists(left,right,customerNames);
    }

    //helper method for merge sort algorithms to sort customer names
    //it merges two lists
    private static void mergeLists(ArrayList<String> left, ArrayList<String> right, ArrayList<String> customerNames){
        /*
        if (compare < 0){
            System.out.println(a+" is before "+b);
        }
        else if (compare > 0) {
            System.out.println(b+" is before "+a);
        }
        else {
            System.out.println(b+" is same as "+a);
        }
        */

        int sizeOfLeft = left.size();
        int sizeOfRight = right.size();

        int i = 0; //index of smallest unpicked element in leftList
        int j = 0;//index of smallest unpicked element in rightList
        int k = 0; // index of position that needs to ve filled

        //this while loops runs until atleast one of the lists has no elements left
        while (i < sizeOfLeft && j < sizeOfRight){


            //if the element at index in the left list is smaller than that of rightList
            // then over write the k th element in aList with the smaller element of leftList
            if (left.get(i).compareToIgnoreCase(right.get(j)) <= 0){

                customerNames.set(k,left.get(i));
                k++;
                i++;


            }
            // else over write the k th element in aList with the smaller element of rightList
            else {

                customerNames.set(k,right.get(j));
                k++;
                j++;

            }
        }

        //if any of the list has no elements left, then store all the elements left in the
        //other list in the aList by over writing the values
        while (i < sizeOfLeft){
            customerNames.set(k,left.get(i));
            i++;
            k++;
        }
        while (j < sizeOfRight){
            customerNames.set(k, right.get(j));
            j++;
            k++;
        }

    }

    //method to generate a customer object based on given information
    private static Customer generateCustomer(String name, String number){

            Customer customer = new Customer();
            customer.setName(name);
            customer.setPhoneNumber(number);

            return customer;
    }

    //main menu
    private static void officeMenu(){

        System.out.println("1) View Today's Customers names");
        System.out.println("2) View Today's Customers details and their transaction with us");
        System.out.println("3) Sort customers by their names");
        System.out.println("4) View the profit made today");

    }

    //menu for the user og what to buy
    private static void printMenu(){

        System.out.print( "\n           You have three options \n"
                +"\n1. Basic Burger with four choosable additions \n"
                + "\n2. Healthy Burger with six choosable additions \n"
                + "\n3. Deluxe Burger with nine choosable additions \n");

    }
}
