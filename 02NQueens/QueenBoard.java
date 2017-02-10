public class QueenBoard{

    private int[][]board;
    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public boolean solve()
    {
	return solveH(0);
    }

    private boolean solveH(int col){
	return false;
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
    	return -1;
    }

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	String ans = "";
	if (solve()){
	    for(int col = 0; col<board[].length();col++){
		for(int row = 0; row<board[].length();row++){
		    if (board[row][col] == -1){
			ans += "Q";
		    }
		    else{
			ans += "_";
		    }
		}
		ans += "\n";
	    }
	    return ans;
	}
        return "none";
    }
}
