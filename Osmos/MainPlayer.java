public class MainPlayer implements Players{

    private double speed;
    private int radius;
    private int xcor;
    private int ycor;
    private int section;
    // 1(400, 500) 2(800, 500) 3(1200, 500) 4(1600, 500)
    // 5(400, 1000) 6(400, 1000) 7(1200, 1000) 8(1600, 1000)
    private boolean alive;

    public MainPlayer(){
	speed = 2;
	radius = 20;
	xcor = 800;
	ycor = 500;
	alive = true;
	section = 2;
	
       }
    public int getSection(){
	return section;}
    
    public boolean isAlive(){
	return alive;}
    
    public int getX(){
	return xcor;}
    
    public int getY(){
	return ycor;}

    public int getRadius(){
	return radius;}
    
    public double getSpeed(){
	return speed;}

    public void eat(Players x){
	if (isBigger(x)){
	    double amount = x.getRadius();
	    radius += amount/2;
	    speed -= amount/100;}

	else{die();}
    }
	
    public void moveTo (int x, int y){//fix later
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

    public boolean nearMe(EnemiesPlayer x){
	if (x.getSection() == section){return true;}
	return false;
    }
    

    


}