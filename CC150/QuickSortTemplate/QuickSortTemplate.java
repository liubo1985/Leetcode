package CC150.QuickSortTemplate;

/**
 * Created by bliu on 5/23/16.
 */
public class QuickSortTemplate {
    public void sort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }

        int left = start;
        int right = end;
        int mid = start + (end - start)/2;
        int pivot = nums[mid];


        while(left <= right){
           while(left <= right && nums[left] < pivot) {
               left++;
           }
            while(left <= right && nums[right] > pivot){
                       right--;
            }

            if(left <= right){
                swap(nums, left, right);
                left++;
                right--;
            }

        }
        quickSort(nums, start, right);
        quickSort(nums, left, end);

    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
