import java.util.*;
public class EnemiesPlayer implements Players{
    private Random a = new Random();
    private double speed;
    private int radius;
    private int xcor;
    private int ycor;
    private boolean alive;
    private int section;
	

    public EnemiesPlayer(){
	speed = 2.5;//start at two decrease by 0.05
	radius = 10;
	xcor = a.nextInt(1600);//to be changed
	ycor = a.nextInt(800);//to be changed
	alive = true;
	section = 2;
    }
    public void setX(int x){
      xcor = x;
    }
    public void setY(int y){
      ycor = y;
    }

    public int getSection(){
	return section;}
    
    public boolean isAlive(){
	return alive;}
    
    public int getX(){
	return xcor;
    }

    public int getY(){
	return ycor;
    }

    public int getRadius(){
	return radius;
    }

    public double getSpeed(){
	return speed;
    }

    public void eat(Players x){
	if (isBigger(x)){
	    double amount = x.getRadius();
	    radius += amount;
	    speed -= 0.05;}
	else{die();}
    }
	
    public void moveTo (int x, int y){
if(x>xcor){
      xcor += speed;
    }
    else{
      if(x<xcor){
        xcor -= speed;
      }
    }
    if(y>ycor){
      ycor += speed;
    }
    else{
      if(y<ycor){
        ycor -= speed;
      }
    }

  if ((x<50) && (y<50)){
      section = 1;
  }
  else if ((x<100) && (y<50)){
      section = 2;
  }
  else if ((x<50) && (y<100)){
      section = 3;
  }
  else if ((x<100) && (y<100)){
      section = 4;
  }
  
    }

    public void die(){
	alive = false;
  xcor = -1000;
  ycor = -1000;
    }

    public boolean isBigger(Players x){
	double sizeup =  x.getRadius();
	if (sizeup < radius){ return true;}
	return false;
    }
    
  public boolean nearMe(Players x){
      if (x.getSection() == section){return true;}
	return false;
    }
    

    

    
}