package com.Nithin;

//-----------------------------------------------------------------------------------------------------------
/*CSE 205: <Class 17566> / <MW 4.35PM-5.50PM>

Assignment: <Assignment 6>
Package : com.Nithin;

Author: <Nithin Sagar Nallagula> & <1212968092>

Description: <Write a class called MyArrayList that implements MyList and to write methods like add, size,
                at, insertAt, removeAt >*/
//------------------------------------------------------------------------------------------------------------

import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T>  {

    private int capacity = 16;
    private Object[ ] array = new Object [capacity];
    private int size = 0;


    @Override
    //Method at add an object passed to the array
    public void add(T n) {

        //Add method to add more size if there is no space to add the object
        add();

        for (int i = 0; i < array.length; i++){

            if (array[i] == null){
                array[i] = n;
                break;
            }

        }
        //Incrementing size when an object is added to the array
        size++;

    }



    //@Override
    //Returning the size of the array i.e number of elements present in the array
    public int size() {

        int count = 0;
        for (int i = 0; i < array.length; i++){

            if (array[i] == null){
                break;
            }
            count++;
        }

        return count;

    }

    //@Override
    //Returning the object present at a particular index that is passed as an argument
    public T at(int index) {

        //Declaring temporary object
        T temp = null;
        for (int i = 0; i < size(); i++){
            if (i == index){
                temp = (T)array[i];
                break;
            }
        }

        return temp;
    }

    //@Override
    //Adding an object at a particular index that is passed as an argument
    public void insertAt(int index, T o) {

        //Add method to add more size if there is no space to add the object
        add();

        for(int i=0; i< size; i++) {

            if (i == index){

                for (int j = size; j > index; j-- ){
                    array[j]= array[j-1];
                }

                array[index]=o;
            }

        }
        //Incrementing size when an object is added to the array
        size++;

    }

    public void setAt(int index, T item) {
        if (index >= size)
            throw new NoSuchElementException();

        array[index] = item;
    }


    //@Override
    //Removing an object present at a particular index that is passed as an argument
    public void removeAt(int index) {

        for (int i = 0; i < size(); i++) {
            if (i == index) {
                for (int j = i; j < size(); j++) {
                    array[j] = array[j+1];
                }
                //Decreasing size after removing the object
                size--;
                break;
            }
        }

    }


    //This method will take an int minCapacity as an argument.
    // If minCapacity is less than current size, it simply returns without doing anything
    // If minCapacity is less than 16, then new Capacity is 16.
    // It creates new array of onjects with new capacity and copies all the elements from old one to this
    public void ensureCapacity(int minCapacity) {

        int newCapacity = 0;
        if(minCapacity < size()){
            return;
        }

        if (minCapacity < 16){
            newCapacity = 16;
        }

        newCapacity += minCapacity;

        Object[ ] newArray = new Object [newCapacity];

        for (int i = 0; i < array.length; i++){

            newArray[i] = array[i];

        }

        this.array = newArray;

    }

    //add method to increases size of the array when needed
    private void add(){
        if (array.length == this.capacity){
            ensureCapacity(capacity*2);
        }
    }


    private void trimToSize() {
        ensureCapacity(size);
    }

    // Do not alter the code below .  . -----
    //@Override
    public MyListIterator getIterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements MyListIterator {
        int currentIndex = - 1;

        @Override
        public Object next( ) {
            currentIndex++;
            return array[currentIndex];
        }

        @Override
        public boolean hasNext( ) {
            return currentIndex +1 < size;
        }
    }
}



