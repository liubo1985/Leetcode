package com.practice.pathfinder;

/*
 Imagine a robot sittting on the upper left corner of an X by Y grid. The robot can only move in two directions:
 right and down. hOW MANY POSSIBLE PATHS ARE THERE FOR THE ROBOT TO GO FROM (0, 0) to (X, Yß)
 */

import java.util.ArrayList;
/**
 * Created by bliu on 10/27/15.
 */
public class GetPath {

    public static void getPoint (int x, int y, ArrayList<Point> pointArray, ArrayList<ArrayList<Point>> pathArray)
    {
        pointArray.add(new Point(x,y));

        if (x < 0 || y < 0)
            return;

        if (x == 0 && y == 0)
        {
            pathArray.add(pointArray);
            return;
        }

        getPoint(x-1, y, new ArrayList<Point>(pointArray),pathArray);
        getPoint(x, y - 1, new ArrayList<Point>(pointArray), pathArray);



    }

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Point>> allpath = new ArrayList<ArrayList<Point>>();
        getPoint(3,3,new ArrayList<Point>(), allpath);
        for (ArrayList<Point> al : allpath)
        {
            for (Point pt : al)
            {
                System.out.print("(" + pt.getX() + "," + pt.getY() + "),");
            }
            System.out.println();
        }
        System.out.println(allpath);

    }

}
