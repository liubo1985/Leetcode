

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> pancakeSort(int[] A) {
        if (A == null || A.length == 0){
            return res;
        }
        for (int i = A.length; i > 0; i--){
            int index = 0;
            while (index < A.length && A[index] != i){
                index++;
            }
            if (index == i - 1)
                continue;
            // put this value to the head of array
            flip(A, 0, index );
            // then swap the head with the proper position
            flip(A, 0, i - 1);

            System.out.println(A[i - 1]);

        }
        return res;
    }

    public void flip(int[] A, int start, int end){
        res.add(end + 1);
        while (start < end){
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }

    }
}