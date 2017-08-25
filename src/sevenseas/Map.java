
package sevenseas;



/**
 *
 * @author Eddie
 */
public class Map {
    private String[][] location = new String[5][5];
    
    
    
    public Map(){
        
        
        for (int i =0; i< location.length; i++){
            for(int j=0; j<location.length;j++){
                location[i][j] = ".";
            }
        }
    }
    
    public void Display(){
        for (int i =0; i< location.length; i++){
            for(int j=0; j<location.length;j++){
                
                System.out.print(location[i][j] + "  ");
            }
            System.out.println();
        }
    }
    
    //add location of Actors to the map:
    public void inSeas(Player player, Actor enemy1,Actor enemy2){
        
        
        location[player.getX()][player.getY()] = player.getOriental();
        
        
        location[enemy1.getX()][enemy1.getY()] = "E";
        location[enemy2.getX()][enemy2.getY()] = "E";
       
        
    } //end.
    
   
    //update:
    public void update(Player player, Actor enemy1, Actor enemy2){
        for (int i=0;i<location.length;i++){
            for(int j=0;j<location.length;j++){
                if(location[i][j] == "|" || location[i][j] == "_" || location[i][j] == "E"){
                    location[i][j] = ".";
                }
            }
        }
        
        
        if (enemy1.isDeath() == true){
            location[enemy1.getX()][enemy1.getY()] = ".";
        } else {location[enemy1.getX()][enemy1.getY()] = "E";
        }
        
        if (enemy2.isDeath() == true){
            location[enemy2.getX()][enemy2.getY()] = ".";
        } else {location[enemy2.getX()][enemy2.getY()] = "E";
        }
        
        if(player.isDeath() == true){
            location[player.getX()][player.getY()] = "E";
        } else {location[player.getX()][player.getY()] = player.getOriental();
        }
        
    }//end.
    
    
    //check if shot enemy:
    public boolean checkShot(Shot LShot, Shot RShot, Actor Enemy){
        for(int i =0;i<location.length;i++){
            for(int j=0;j<location.length;j++){
                if( (LShot.getX() == Enemy.getX() && LShot.getY() == Enemy.getY()) 
                        || (RShot.getX() == Enemy.getX() && RShot.getY() == Enemy.getY()) ){
                    location[Enemy.getX()][Enemy.getY()] =".";
                    return true;
                    
                }
            }
        } return false;
    }//end.
    
    //check if hitted by an enemy:
    public boolean checkHit(Actor Enemy, Player player){
        for(int i =0;i<location.length;i++){
            for(int j=0;j<location.length;j++){
                if (Enemy.death == false){
                    if( Enemy.getX() == player.getX() && Enemy.getY() == player.getY() ){
                        player.setDeath(true);
                        return true;
                    }
                }
            }
        } return false;
    }//end.
    
    //check if an object is hit wall:
        public boolean hitWall(Actor actor){
            for(int i =0;i<location.length;i++){
                for(int j=0;j<location.length;j++){
                    if( (actor.getX() > 4) || (actor.getY() >4) ||(actor.getX()<0) || (actor.getY()<0) ){
                        return true;
                    }
                }
            } return false;
    }//end.
    
    
    
    
}
