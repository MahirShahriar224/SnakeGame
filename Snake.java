package SnakeGameV1 ;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    List<Point> snakePoints;
    int xDir, yDir;
    Boolean isMoving, elongate;
    final int STARTSIZE =20, STARTX=150,STARTY=150;

    public Snake(){
        snakePoints = new ArrayList<Point>();
        xDir = 0;
        yDir = 0;
        isMoving = false;
        elongate = false;
        snakePoints.add(new Point(STARTX,STARTY));
        for (int i = 1; i < STARTSIZE; i++) {
            snakePoints.add(new Point(STARTX-i*4,STARTY));
        }

    }

    public void draw(Graphics g){
        g.setColor(Color.YELLOW);
        for(Point p : snakePoints){
            g.fillRect(p.getX(), p.getY(), 4, 5);
        }
    }
    public void move(){
        if (isMoving){
            Point temp= snakePoints.get(0);
            Point last = snakePoints.get(snakePoints.size()-1);
            Point newStart = new Point(temp.getX()+xDir*4,temp.getY()+yDir*4);
            for (int i=snakePoints.size()-1;i>=1;i--){
                snakePoints.set(i, snakePoints.get(i-1));
            }
            snakePoints.set(0,newStart);
            if (elongate){
                snakePoints.add(last);
                elongate = false;
            }
        }


    }
    public boolean snakeCollision(){
        int x= this.getX();
        int y= this.getY();
        for(int i=1; i < snakePoints.size(); i++){
            if(x == snakePoints.get(i).getX() && y == snakePoints.get(i).getY()) {
                return true; }
            }
        return false;
        }

    public boolean isMoving(){
        return isMoving;
    }
    public void setMoving(boolean moving){
        isMoving = moving;
    }

    public int getXDir() {
        return xDir;
    }

    public int getYDir() {
        return yDir;
    }

    public void setXDir(int xDir) {
        this.xDir = xDir;
    }

    public void setYDir(int yDir) {
        this.yDir = yDir;
    }
    public int getX(){
        return snakePoints.get(0).getX();
    }
    public int getY(){
        return snakePoints.get(0).getY();
    }

    public void setElongate(boolean b){
        elongate= b;
    }











}
