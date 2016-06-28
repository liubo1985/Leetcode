package practice.ZeroOne;

/**
 * Created by bliu on 5/18/16.
 */
public class Solution {
    public void solution(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            while(nums[i] == 0){
                i++;
            }
            while(nums[j] == 1){
                j--;
            }
            swap(nums, i, j);
            i++;
            j--;

        }
        //return nums;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] nums = new int[]{0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1};
        Solution result = new Solution();
        result.solution(nums);
        System.out.println("The results are: ");
        for(int i = 0; i < nums.length; i++){

            System.out.println(nums[i] + ',');
        }
        System.out.println();
        System.out.println("The end ");
    }
}
