class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes == null || barcodes.length == 0){
            return new int[]{};
        }
        final int n = barcodes.length;
        int[] tem = new int[n];
        for (int i = 0; i < n; i++) {
            tem[i] = barcodes[i];
        }
        int mid = findKth(barcodes, 0, barcodes.length - 1, (barcodes.length + 1)/2);
        System.out.println(mid);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = mid;
        }
        int counter = 0;
        for (int i = 0; i < n; i++){
            if (barcodes[i] == mid){
                counter++;
            }
        }

        int l = 1;
        int r;
        if (n % 2 == 1){
            if (counter > n/2){
                r = n -2;
            } else {
                r = n -1;
            }
        } else{
            r = n - 2;
        }
        for (int i = 0; i < n; i++) {
            if (barcodes[i] < mid) {
                ans[l] = barcodes[i];
                l += 2;
            }else if (barcodes[i] > mid) {
                ans[r] = barcodes[i];
                r -= 2;
            }
        }

        for (int i = 0; i < n; i++) {
            barcodes[i] = ans[i];
        }
        return barcodes;
    }

    public int findKth(int[] nums, int start, int end, int kth){
        int i = start - 1;
        int j = end + 1;
        int mid = start + (end - start)/2;
        int pivot = nums[mid];
        int iterator = start;
        while(iterator < j){
            if (nums[iterator] < pivot){
                i++;
                swap(nums, iterator, i);
                iterator++;
            } else if(nums[iterator] > pivot){
                j--;
                swap(nums, iterator, j);
            } else {
                iterator++;
            }

        }
        if (i - start + 1 >= kth){
            return findKth(nums, start, i, kth);
        }else if (j - start >= kth){
            return nums[j - 1];
        }else {
            return findKth(nums, j, end, kth - (j - start));
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}