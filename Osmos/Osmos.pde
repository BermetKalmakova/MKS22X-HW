MainPlayer main = new MainPlayer();
EnemiesPlayer[] enemies = new EnemiesPlayer[10];
void setup(){
  fullScreen();
  background(0);
  stroke(219,2,9);
  fill(219,2,9);
  for(int i = 0; i < enemies.length; i++){
    enemies[i] = new EnemiesPlayer();
    ellipse(enemies[i].getX(),enemies[i].getY(),enemies[i].getRadius(),enemies[i].getRadius());
  }
}
void draw(){
  stroke(141,54,167);
  fill(141,54,167);
  background(0);
  ellipse(main.getX(),main.getY(),main.getRadius(),main.getRadius());
  main.moveTo(mouseX,mouseY);
  stroke(219,2,9);
  fill(219,2,9);
  for(int i = 0; i < enemies.length; i++){
    ellipse(enemies[i].getX(),enemies[i].getY(),enemies[i].getRadius(),enemies[i].getRadius());
    enemies[i].moveTo();
  }
  for(EnemiesPlayer x: enemies){
    if(x.getX() > main.getX()-main.getRadius() && x.getX() < main.getX()+main.getRadius() && x.getY() > main.getY()-main.getRadius() && x.getY() < main.getY()+main.getRadius()){
      main.eat(x);
      x.eat(main);
    }
  }
}