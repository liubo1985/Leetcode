package com.practice.boxStack;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by bliu on 11/29/15.
 */
public class BoxStack {

    public static void main(String[] args){
        Box[] A = new Box[4];
        A[0] = new Box(4,6,7);
        A[1] = new Box(1,2,3);
        A[2] = new Box(4,5,6);
        A[3] = new Box(10,12,32);

        System.out.println(maxStackHight(A, A.length));
    }

    public static int maxStackHight(Box[] box, int numberOfBox){
        //create 3*numberOfBox Boxes
        Box[] rotation = new Box[3*numberOfBox];
        int index = 0;
        for(int i = 0; i < numberOfBox; i++)
        {
            //copy original one
            rotation[index] = box[i];
            index++;

            //rotate width as hight
            rotation[index] = new Box();
            rotation[index].h = box[i].w;
            rotation[index].w = Math.max(box[i].h, box[i].d);
            rotation[index].d = Math.min(box[i].h, box[i].d);
            index++;

            //rotate depth as hight
            rotation[index] = new Box();
            rotation[index].h = box[i].d;
            rotation[index].w = Math.max(box[i].h, box[i].w);
            rotation[index].d = Math.min(box[i].h, box[i].w);
            index++;

        }

        //Sort the 3*numberOfBoxes boxes
        Arrays.sort(rotation, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o2.w * o2.d - o1.w * o1.d;
            }
        });

        int[] maxh = new int[3*numberOfBox];
        for(int i = 0; i < 3*numberOfBox; i++){
            maxh[i] = rotation[i].h;
        }

        for(int i = 0; i < 3*numberOfBox; i++)
        {
            for(int j = 0; j < i; j++){
                if(rotation[i].d < rotation[j].d && rotation[i].w < rotation[j].w){
                    maxh[i] = Math.max(maxh[i], maxh[j] + rotation[i].h);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < 3*numberOfBox; i++){
            if (maxh[i] > max)
               max = maxh[i];
        }

        return max;
    }


    public static class Box{
        public int h;
        public int w;
        public int d;

        public Box(){

        }

        public Box(int h, int w, int d){
            this.h = h;
            this.w = w;
            this.d = d;
        }
    }
}
