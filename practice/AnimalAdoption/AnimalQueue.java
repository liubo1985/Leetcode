package com.practice.AnimalAdoption;

import java.util.LinkedList;

/**
 * Created by bliu on 2/19/16.
 */
public class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;

    public void enqueue(Animal a){
        a.setOrder(order);
        order++;

        if(a instanceof Dog){
            dogs.addLast((Dog) a);

        }
        else
            cats.addLast((Cat) a);
    }

    public Dog dequeueDogs(){
        return dogs.poll();
    }

    public Cat dequeueCats(){
        return cats.poll();
    }

    public Animal dequeueAny(){
        if(dogs.size() == 0){
            return dequeueCats();

        }
        if(cats.size() == 0){
            return dequeueDogs();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if(dog.isOrderThan(cat))
            return dequeueDogs();
        else
            return dequeueCats();
    }
}
