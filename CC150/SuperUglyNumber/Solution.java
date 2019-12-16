public class Solution {
    /**
     * @param n: a positive integer
     * @param primes: the given prime list
     * @return: the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        // write your code here
        if (n == 1){
            return 1;
        }

        Queue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        Set<Long> set = new HashSet<>();
        set.add(1L);
        Long current = 1L;
        for (int i = 0; i < n; i++){
            current = pq.poll();
            for (int j = 0; j < primes.length; j++){
                Long newNumber = primes[j] * current;

                if (!set.contains(newNumber)){
                    pq.offer(newNumber);
                    set.add(newNumber);
                }
            }

        }

        return current.intValue();

    }
}