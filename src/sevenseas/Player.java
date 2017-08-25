
package sevenseas;

/**
 *
 * @author Eddie
 */
public class Player extends Actor{
    String oriental = "|";
    String cross = "|";
    String line = "_";
    
    public Player(int x, int y) {
        super(x, y);
    }
    
    @Override
    public void moveUp(){
        this.setX(this.x -1);
        this.setY(this.y);
        this.setOriental("|");
    }
    
    @Override
    public void moveDown(){
        this.setX(this.x +1);
        this.setY(this.y);
        this.setOriental("|");
    }
    
    @Override
    public void moveLeft(){
        this.setX(this.x);
        this.setY(this.y - 1);
        this.setOriental("_");
    }
    
    @Override
    public void moveRight(){
        this.setX(this.x);
        this.setY(this.y +1);
        this.setOriental("_");
    }
    
    public String getOriental() {
        return oriental;
    }

    public void setOriental(String oriental) {
        this.oriental = oriental;
    }
    
    public void fire(Player player, Shot LShot, Shot RShot ){
         
        if (oriental == cross){
            LShot.setX(player.getX());
            LShot.setY(player.getY() -1);
            
            RShot.setX(player.getX());
            RShot.setY(player.getY() + 1);
            
            
        }else if(oriental == line){
            LShot.setX(player.getX()+1);
            LShot.setY(player.getY());
            
            RShot.setX((player.getX() - 1));
            RShot.setY(player.getY());
        }
    }
}
