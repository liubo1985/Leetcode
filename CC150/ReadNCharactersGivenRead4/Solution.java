/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf destination buffer
     * @param n maximum number of characters to read
     * @return the number of characters read
     */
    Queue<Character> q = new LinkedList<>();
    boolean endOfFile = false;
    public int read(char[] buf, int n) {
        // Write your code here
        if (n == 0){
            return 0;
        }
        char[] temp = new char[4];
        while (q.size() < n && !endOfFile){
            int readNum = read4(temp);
            if (readNum < 4){
                endOfFile = true;
            }
            for(int i = 0; i < readNum; i++){
                q.offer(temp[i]);
            }
        }
        int i = 0;
        while(!q.isEmpty() && i < n){
            buf[i++] = q.poll();

        }
        return i;

    }
}


public class Solution extends Reader4 {

    public int read(char[] buf, int n) {

        int total = 0;
        char[] temp = new char[4];
        // 计算需要读几次
        for(int i = 0; i < n/4; ++i) {
            int count = read4(temp);
            System.arraycopy(temp, 0, buf, total, count);
            total += count;
            if(count < 4) {
                return total;
            }
        }
        if(n%4 > 0) {
            int remain = n%4;
            int count = read4(temp);
            count = Math.min(count, remain);
            System.arraycopy(temp, 0, buf, total, count);
            total += count;
        }
        return total;
    }
}