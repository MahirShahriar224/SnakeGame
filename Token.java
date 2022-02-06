package SnakeGameV1;

import java.awt.*;

public class Token {
    private int x, y, score;
    private Snake snake;
    private Graphics g;

    public Token(Snake s) {
        x = (int) (Math.random() * 490);
        y = (int) (Math.random() * 490);
        snake = s;
    }

    public void changePosition() {
        x = (int) (Math.random() * 490);
        y = (int) (Math.random() * 490);
    }

    public int getScore() {
        return score;
    }

    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(x, y, 6, 6);
    }

    public boolean snakeCollision() {
        int snakeX = snake.getX() + 2;
        int snakeY = snake.getY() + 2;

        if (snakeX >= x - 1 && snakeX <= x + 7 && snakeY >= y - 1 && snakeY <= y + 7) {
            changePosition();
            score++;
            snake.setElongate(true);
            return true;
        }
        return false;
    }

}
