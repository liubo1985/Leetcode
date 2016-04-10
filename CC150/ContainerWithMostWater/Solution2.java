package com.CC150.ContainerWithMostWater;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by bliu on 3/16/16.
 * O(nlogn)
 */
public class Solution2 {
    private class Edge{
        private int index;
        private int value;
        private Edge(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    private Comparator<Edge> EdgeComparator = new Comparator<Edge>() {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.value - o2.value;
        }
    };

    public int maxArea(int[] height) {
        if(height.length <= 0){
            return 0;
        }

        Edge[] EdgeList = new Edge[height.length];
        for(int i = 0; i < height.length; i++){
            //EdgeList[i].index = i;
            //EdgeList[i].value = height[i];
            EdgeList[i] = new Edge(i, height[i]);
        }
        //sort the EdgeList
        Arrays.sort(EdgeList, EdgeComparator);


        int start = EdgeList[EdgeList.length - 1].index;
        int end = start;
        int temp, area = 0;

        for(int j = EdgeList.length - 2; j >= 0; j--){
            start = Math.min(start, EdgeList[j + 1].index);
            end = Math.max(end, EdgeList[j + 1].index);
            temp = Math.max(Math.abs(start - EdgeList[j].index)*EdgeList[j].value , Math.abs(end - EdgeList[j].index)*EdgeList[j].value);
            area = Math.max(temp, area);
        }
        return area;

    }
}
