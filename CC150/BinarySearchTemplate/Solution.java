public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0){
            return -1;
        }
        if (target > nums[nums.length -1] || target < nums[0]) {
            return -1;
        }

        int start = 0, end = nums.length -1;

        while(start + 1 < end) {
            int mid = start + (end -start)/2;
            if (nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if(nums[start] == target) {
            return start;
        }
        if (nums[end] == target){
            return end;
        }
        return -1;
    }
}








public class Solution {
    /**
     * @param A: An integer array
     * @return: The number of element in the array that
     *          are smaller that the given integer
     */
    class SegmentTreeNode {
        public int start, end;
        public int count;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }
    SegmentTreeNode root;
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if(start > end) {  // check core case
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);

        if(start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid);
            root.right = build(mid+1, end);
        } else {
            root.count =  0;
        }
        return root;
    }
    public int querySegmentTree(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(start == root.start && root.end == end) { // 相等
            return root.count;
        }


        int mid = (root.start + root.end)/2;
        int leftcount = 0, rightcount = 0;
        // 左子区
        if(start <= mid) {
            if( mid < end) { // 分裂
                leftcount =  querySegmentTree(root.left, start, mid);
            } else { // 包含
                leftcount = querySegmentTree(root.left, start, end);
            }
        }
        // 右子区
        if(mid < end) { // 分裂 3
            if(start <= mid) {
                rightcount = querySegmentTree(root.right, mid+1, end);
            } else { //  包含
                rightcount = querySegmentTree(root.right, start, end);
            }
        }
        // else 就是不相交
        return leftcount + rightcount;
    }
    public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        // write your code here
        if(root.start == index && root.end == index) { // 查找到
            root.count += value;
            return;
        }

        // 查询
        int mid = (root.start + root.end) / 2;
        if(root.start <= index && index <=mid) {
            modifySegmentTree(root.left, index, value);
        }

        if(mid < index && index <= root.end) {
            modifySegmentTree(root.right, index, value);
        }
        //更新
        root.count = root.left.count + root.right.count;
    }
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        root = build(0, 10000);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int res;
        for(int i = 0; i < A.length; i++) {
            modifySegmentTree(root, A[i], 1);
        }
        for(int i = 0; i < queries.length; i++) {
            res = 0;
            if(queries[i] > 0)
                res = querySegmentTree(root, 0, queries[i] - 1);
            ans.add(res);
        }
        return ans;
    }




    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0){
            return -1;
        }
        int[][] sum = new int[triangle.length][triangle[trangle.length - 1].length];
        for (int i = 0; i < triangle.length; i++){
            sum[triangle.length - 1][i] = triangle[triangle.length - 1][i];
        }
        for (int i = triangle.length - 2; i >= 0; i--){
            for (int j = 0; j < triangle[i] - 1; j++){
                sum[i][j] = Math.min(sum[i][j], triangle[i][j] + Math.min(sum[i + 1][j], sum[i + 1][j + 1]));
            }
        }
        sum[0][0];
    }


}

