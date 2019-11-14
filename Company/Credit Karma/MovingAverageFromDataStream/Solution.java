
public class MovingAverage {

    Queue<Integer> q;
    double sum;
    int size;
    /*
     * @param size: An integer
     */public MovingAverage(int size) {
        // do intialization if necessary
        this.size = size;
        sum = 0.0;
        q = new LinkedList<>();
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        // write your code here
        sum += val;
        if (q.size() == size){
            int head = q.poll();
            sum -= head;
        }
        q.offer(val);
        return sum / q.size();
    }
}