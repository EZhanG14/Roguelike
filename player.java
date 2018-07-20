/**
 * zhaoning meng
 * 
 */

public class player extends core {
  String name;
  int power;
  int health=5;
  public player(int x,int y)
  {
	  super(x,y);
  }
 

   


public void setname(String n)
  {
	this.name=n;
	
   }

  public String getname()
 {
	return name;

  }
  public void setpower(int p)
  {
	power=p;
	
   }
   public int getpower()
   {
	return power;
   }
    public void sethealth(int h)
   {
	this.health=h;
    }

   public int gethealth()
    {
	return health;
    }









}



