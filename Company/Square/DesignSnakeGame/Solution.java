class SnakeGame {
    int width;
    int height;
    boolean[][] board;
    int[][] food;
    int foodEaten;
    int score;
    int row;
    int col;
    Queue<Integer> snake;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.board = new boolean[height][width];
        this.board[0][0] = true;
        this.foodEaten = 0;
        this.food = food;
        this.score = 0;
        this.row = 0;
        this.col = 0;
        this.snake = new LinkedList<Integer>();
        this.snake.offer(0);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (score == -1){
            return -1;
        }
        if (direction.equals("U")){
            row--;
        }
        if (direction.equals("L")){
            col--;
        }
        if (direction.equals("R")){
            col++;
        }
        if (direction.equals("D")){
            row++;
        }

        if (row < 0 || row >= height || col < 0 || col >= width){
            return -1;
        }
        // update tail
        // not food
        if (foodEaten == food.length || !(row == food[foodEaten][0] && col == food[foodEaten][1])) {
            int id = snake.poll();
            board[id / width][id % width] = false;
        } else {

            score++;
            foodEaten++;
        }
        // update head
        if (board[row][col]){
            score = -1;
            return score;
        } else {
            snake.offer(row * width + col);
            board[row][col] = true;
        }
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */