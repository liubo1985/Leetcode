/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {

    List<Integer> flatten;
    int index = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        List<Integer> res = new ArrayList<>();
        helper(nestedList, res);
        flatten = res;
    }

    public void helper(List<NestedInteger> nestedList, List<Integer> res) {
        for (int i = 0; i < nestedList.size(); i++){
            NestedInteger element = nestedList.get(i);
            if (element.isInteger()){
                res.add(element.getInteger());
            } else {
                helper(element.getList(), res);
            }
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        return flatten.get(index++);

    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        return index < flatten.size();
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */