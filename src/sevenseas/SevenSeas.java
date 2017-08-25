/*
 * todo:
- enemies move into same location


 */
package sevenseas;


import java.util.Scanner;

/**
 *
 * @author Eddie
 */

// itsavavt@gmail.com
public class SevenSeas {
    
    public SevenSeas(){
       
    }
    
    public static void main(String[] args) {
         Map seas = new Map();
         
         Player p = new Player(2, 2);
         Shot lshot = new Shot(0,0);
         Shot rshot = new Shot(0, 0);
         
         Actor e1 = new Actor(4,3);
         Actor e2 = new Actor(4,1);
         
         boolean gameOn = true;
         
         int enemiesleft = 2;
         
         seas.inSeas(p, e1,e2);
         do{
             
             
             
             seas.Display();
             
             Scanner inp = new Scanner(System.in);
             System.out.println("your Move? (W,A,S,D,F)");
             String playerMove = inp.nextLine();
             
             switch(playerMove){
                 case "w":
                     p.moveUp();
                     if(seas.hitWall(p) == true ){
                         p.moveDown();
                         System.out.println("You'll be stunt if you hit the wall.");
                     }
                     
                     
                     break;
                 case "a":
                     p.moveLeft();
                     if(seas.hitWall(p) == true ){
                         p.moveRight();
                         System.out.println("You'll be stunt if you hit the wall.");
                     }
                     break;
                 case "s":
                     p.moveDown();
                     if(seas.hitWall(p) == true ){
                         p.moveUp();
                         System.out.println("You'll be stunt if you hit the wall.");
                     }
                     
                     break;
                 case "d":
                     p.moveRight();
                     if(seas.hitWall(p) == true ){
                         p.moveLeft();
                         System.out.println("You'll be stunt if you hit the wall.");
                     }
                     
                     break;
                     
                     
                 case "f":
                     p.fire(p, lshot, rshot);
                     
                     if (seas.checkShot(lshot, rshot, e1) == true){
                        System.out.println("You've destroyed an enemy!");
                        e1.setDeath(true);
                        enemiesleft = enemiesleft -1;
                        e1.setDeath(true);
                        
                    }
                     if (seas.checkShot(lshot, rshot, e2) == true){
                        System.out.println("You've destroyed an enemy!");
                         enemiesleft = enemiesleft -1;
                         e2.setDeath(true);
                        
                    }
                     
                     if(enemiesleft == 0){
                        System.out.println("You Win!");
                        gameOn = false;
                        seas.update(p, e1,e2);
                        seas.Display();
                        continue;
                    }
                     break;
                 default:
                     System.out.println("ERROR MOVE!");
                     break;
             }
             
             
             Actor.enemyMoves(e1);
             
             Actor.enemyMoves(e2);
             
                     
                
             //check hit twice
                if(seas.checkHit(e1, p) == true){
                    System.out.println("You Lose!");
                    gameOn = false;
                    seas.update(p, e1,e2);
                    seas.Display();
                }
                if(seas.checkHit(e2, p) == true){
                    System.out.println("You Lose!");
                    gameOn = false;
                    seas.update(p, e1,e2);
                    seas.Display();
                }
                
                
             seas.update(p, e1,e2);
             
         }
         while(gameOn == true);
         
    }
    
}
