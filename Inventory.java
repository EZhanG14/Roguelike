/* - only item available will be a sword
  - sword will change how much damage u do ( for enemies.java)
  - find a way to generate sword location on map
  - print text indicating that the plyer found a sword
  - preferably use "!" as a symbol to represent sword
  - use ~ to oepn up "inventory tab"
  - ARe we going to have more than 1 sword?
  - is the collision detection for sword on core, map or inventory?
  - how to check if player has sword?
  Cooridinated variables (enemy):
   - sword = SwordOne.
   Coordinate variables (Core):
   - checking if user ran over vcertain coordinates. core will say a certain variable is true or false. = boolean getSword.
   
*/
package mondayDemo;
import java.util.Scanner;

public class Inventory extends Core{
  private char swordOne = "!";
  private char inventButton = "~";
  private char invSword[] = new char[1];
  
  public char[] SwordCheck(){
    if getSword = true{
      invSword.add("!");
    }
    return invSword[];
  } //How would i be able to change the array value with swordCheck so I could move it to swordBattle??

  public boolean swordBattle(){
    boolean swordBattle;
    if invSword[0] == "!"{
      swordBattle = true;
    }else{
      swordBattle = false;
    }
    return swordBattle;
  }

// I think this should go into whatever class deals with taking thesuers input for moving. 
  /*if player presses "~"
      if player has sword{
        system.out.println("You have one sword.")
      }else{
        system.out.println("You do not have a sword.")
      }
  }*/ 
  public static void main(String[] args){}
}
