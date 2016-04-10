package com.practice.hanoi;

import java.util.Stack;

/**
 * Created by bliu on 2/17/16.
 */
public class Tower {
    private Stack<Integer> stacks;
    private int index;

    public Tower(int index){
        stacks = new Stack<Integer>();
        this.index = index;
    }

    public int getIndex(){
        return index;
    }

    public void add(int d){
        if(!stacks.isEmpty() && stacks.peek() < d)
            return;
        else stacks.push(d);
    }

    public void moveTopTo(Tower tower){
        int top = stacks.pop();

        tower.add(top);
        System.out.println("Move from tower" + getIndex() + " to tower" + tower.getIndex());
    }

    public void moveDisks(int n, Tower destination, Tower buffer){
        if (n == 0)
            return;
        moveDisks(n - 1, buffer, destination);
        moveTopTo(destination);
        buffer.moveDisks(n - 1, destination, this);
    }

    public static void main(String[] args){
        int numberOfDisks = 3;
        Tower[] towers = new Tower[3];
        for(int i = 0; i < 3; i++){
            towers[i] = new Tower(i);
        }
        for(int i = numberOfDisks - 1; i >= 0; i-- ){
            towers[0].add(i);
        }

        towers[0].moveDisks(numberOfDisks, towers[2], towers[1]);
    }
}
