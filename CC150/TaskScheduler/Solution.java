public class Solution {
    /**
     * @param tasks: the given char array representing tasks CPU need to do
     * @param n: the non-negative cooling interval
     * @return: the least number of intervals the CPU will take to finish all the given tasks
     */
    public int leastInterval(char[] tasks, int n) {
        // write your code here
        if (tasks == null || tasks.length == 0){
            return 0;
        }
        int[] map = new int[26];
        // most frequent occurences
        int mostFreqCount = 0;
        // how many chars have same most frequent occurences
        int numOfMostFreq = 0;
        for (char ch : tasks){
            ++map[ch - 'A'];
            if (map[ch - 'A'] == mostFreqCount){
                numOfMostFreq++;
            } else if (map[ch - 'A'] > mostFreqCount){
                mostFreqCount = map[ch - 'A'];
                numOfMostFreq = 1;
            }
        }
        // split into number of blocks
        int numOfBlocks = mostFreqCount - 1;
        // how many empty slots per block
        int numOfEmptySlots = n + 1 - numOfMostFreq;
        int totolEmptySlots = numOfBlocks * numOfEmptySlots;
        // calculate how many tasks left excluding the most freq occurences chars
        int numOftasksLeft = tasks.length - mostFreqCount * numOfMostFreq;
        // calculate number of idles
        int numOfidles = Math.max(0, totolEmptySlots - numOftasksLeft);
        return tasks.length + numOfidles;
    }
}