
package sevenseas;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Eddie
 */
public class Actor {
    int x,y;
    private static final String LEFT = "A";
    private static final String RIGHT = "D";
    private static final String UP = "W";
    private static final String DOWN = "S";
    private static final String FIRE = "F";
    boolean death = false;

    public boolean isDeath() {
        return death;
    }

    public void setDeath(boolean death) {
        this.death = death;
    }
    
    
    
    public Actor(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public static int enemyMoves(Actor enemy){
        
        Random ran = new Random();
        int x = ran.nextInt(4) + 1;
        switch(x){
            case 1:
                enemy.moveUp();
                break;
            case 2:
                enemy.moveDown();
                break;
            case 3:
                enemy.moveLeft();
                break;
            case 4:
                enemy.moveRight();
                break;
        }
        return x;
        }
        
    
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    
    
    
    public void moveUp(){
        if (x>0){
        this.setX(this.x -1);
        this.setY(this.y);
        }
    }
    
    public void moveDown(){
        if(x<4){
        this.setX(this.x +1);
        this.setY(this.y);
        }
    }
    
    public void moveLeft(){
        if(y>0){
        this.setX(this.x);
        this.setY(this.y - 1);
        }
    }
    
    public void moveRight(){
        if(y<4){
        this.setX(this.x);
        this.setY(this.y +1);
        }
    }
    
    

    
    
    
    
    
}
