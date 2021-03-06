import java.util.*;
import java.io.*;

public class Maze{


    private char[][]maze;
    private boolean animate;
    private int sr;
    private int sc;
    private int er;
    private int ec;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename){
	animate = false;

	boolean sthere = false;
	boolean ethere = false;
	try{
	    File x = new File(filename);
	    Scanner file = new Scanner(x).useDelimiter("\\r?\\n");
	    ArrayList<String> lines = new ArrayList<String>();
	    while (file.hasNext()){
		lines.add(file.next());
	    }
	    
	    
	    maze = new char[lines.size()][lines.get(0).length()];
	
	    for(int r = 0; r < lines.size();r ++){
		for(int c = 0; c < lines.get(0).length(); c++){
		    maze[r][c] = lines.get(r).charAt(c);
		    if(lines.get(r).charAt(c) == 'S'){
			sr = r;
			sc = c;
			sthere = true;
		    }
		    if(lines.get(r).charAt(c) == 'E'){
			er = r;
			ec = c;
			ethere = true;
		    }
		}
	    }
	    int counte = 0;
	    int counts = 0;
	    for(int i = 0; i < maze.length; i ++){
		for (int j = 0; j < maze[0].length; j ++){
		    if(maze[i][j] == 'S'){
			counts++;
		    }
		    if(maze[i][j] == 'E'){
			counte++;
		    }
		}
	    }
	    if(counte * counts != 1){
		throw new IllegalArgumentException("Does not have both start and end");
		//System.exit(0);
	    }
	}
	catch (FileNotFoundException e){
	}
	
        //COMPLETE CONSTRUCTOR
    }
    

    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startr=-1,startc=-1;

            //Initialize starting row and startint col with the location of the S. 
	    startr = sr;
	    startc = sc;
            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);

            wait(20);
        }
	if(maze[row][col] == 'E'){
	    return true;
	}
	if(maze[row][col] == ' '){
	    maze[row][col] = '@';
	    if(solve(row+1,col) || solve(row-1,col) || solve(row,col+1) || solve(row,col-1)){
		return true;
	    }
	    else{
		maze[row][col] = '.';
	    }
	}
	

        //COMPLETE SOLVE

        return false; //so it compiles
    }
    public String toString(){
	String ans = "";
	for(int col = 0; col<maze[0].length;col++){
	    for(int row = 0; row<maze.length;row++){
		if(maze[row][col] < 10){
		    ans += " ";
		}
		ans += maze[row][col];
	    }
	    ans += "\n";
	}
	return ans;
    }
    // private boolean tryMoves(int r, int c){
    // 	if(solve(r+1,c)){
    // 	  ;
	    




}


