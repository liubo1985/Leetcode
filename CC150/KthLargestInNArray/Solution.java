public class Solution {
    /**
     * @param arrays: a list of array
     * @param k: An integer
     * @return: an integer, K-th largest element in N arrays
     */
    class Element{
        int row;
        int col;
        int val;
        Element(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int KthInArrays(int[][] arrays, int k) {
        // write your code here
        if (arrays == null || arrays.length == 0){
            return 0;
        }

        PriorityQueue<Element> pq = new PriorityQueue<>(k, new Comparator<Element>(){
            public int compare(Element a, Element b){
                return b.val - a.val;
            }
        });

        for (int i = 0; i < arrays.length; i++){
            Arrays.sort(arrays[i]);
            if (arrays[i].length > 0){
                pq.offer(new Element(i, arrays[i].length - 1, arrays[i][arrays[i].length - 1]));
            }
        }

        for (int i = 0; i < k - 1; i++){
            Element cur = pq.poll();
            if (--cur.col >= 0){
                pq.offer(new Element(cur.row, cur.col, arrays[cur.row][cur.col]));
            }
        }
        return pq.peek().val;
    }
}