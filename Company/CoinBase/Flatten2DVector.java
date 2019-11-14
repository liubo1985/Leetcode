
public class Vector2D implements Iterator<Integer> {

    int row, col;
    List<List<Integer>> vec2d;

    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        row = 0;
        col = 0;
        this.vec2d = vec2d;
    }

    @Override
    public Integer next() {
        // Write your code here
        if (!hasNext()){
            return null;
        }
        return vec2d.get(row).get(col++);
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while (row < vec2d.size() && col == vec2d.get(row).size()){
            row++;
            col = 0;
        }
        return row < vec2d.size() && col <vec2d.get(row).size();
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */