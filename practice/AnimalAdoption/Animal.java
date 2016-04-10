package com.practice.AnimalAdoption;

/**
 * Created by bliu on 2/19/16.
 */
public abstract class Animal {
    private int order;
    protected String name;

    public Animal(String name){
        this.name = name;
    }

    public void setOrder(int order){
        this.order = order;
    }

    public int getOrder(){
        return order;
    }

    public boolean isOrderThan(Animal a){
        if(order > a.getOrder())
            return true;
        else
            return false;
    }
}
