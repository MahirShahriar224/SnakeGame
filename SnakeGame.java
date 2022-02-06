package SnakeGameV1;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.Thread.*;

public class SnakeGame extends Applet implements Runnable, KeyListener {

    Graphics gfx;
    Image img;
    Thread thread;
    Snake snake;
    Boolean gameOver;
    Token token;

    public void init() {
        this.resize(500,500);
        gameOver= false;
        img = createImage(500,500);
        gfx = img.getGraphics();
        this.addKeyListener(this);
        snake = new Snake();
        token = new Token(snake);
        thread = new Thread(this);
        thread.start();

    }
    public void paint(Graphics g) {
        g.setColor(java.awt.Color.black);
        g.fillRect(0,0,500,500);
        if(!gameOver){
            snake.draw(gfx);
            token.draw(gfx);
        }
        else {
            gfx.setColor(java.awt.Color.white);
            gfx.drawString("Game Over", 250, 250);
            gfx.drawString("Score: " + token.getScore(), 250, 270);
        }
        snake.draw(gfx);

        g.drawImage(img,0,0,null);

    }

    public void update(Graphics g) {
        paint(g);
    }
    public void repaint(Graphics g) {
        paint(g);
    }

    public void run() {
        for (;;) {

            if (!gameOver) {
                snake.move();
                this.checkGameOver();
                token.snakeCollision();
            }

            this.repaint();
            try {
            sleep(40);}
            catch (InterruptedException e) {
                try {
                    sleep(40);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            }
    }
    public void checkGameOver(){
        if(snake.getX() < 0 || snake.getX() > 495 || snake.getY() < 0 || snake.getY() > 495){
            gameOver = true;}
        if(snake.snakeCollision() == true) {
            gameOver = true; }
    }


    public void keyPressed(KeyEvent e) {
        if (!snake.isMoving()) {
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN ||
            e.getKeyCode()== KeyEvent.VK_RIGHT) {
                snake.setMoving(true);
            }

        }



        if(e.getKeyCode() == KeyEvent.VK_UP) {
            if(snake.getYDir() != 1){
                snake.setYDir(-1);
                snake.setXDir(0);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(snake.getYDir() != -1){
                snake.setYDir(1);
                snake.setXDir(0);
            }

        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(snake.getXDir() != 1){
                snake.setXDir(-1);
                snake.setYDir(0);
            }

        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(snake.getXDir() != -1){
                snake.setXDir(1);
                snake.setYDir(0);
            }

        }



    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }
}

