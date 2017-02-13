public class QueenBoard{

    private int[][]board;
    private int solutionCount = 0;

    public QueenBoard(int size){
	board = new int[size][size];
	empty(size);
    }
	    
    private void empty(int num){
	for(int col = 0; col < num; col++){
	    for(int row = 0; row < num; row++){
		board[col][row] = 0;
	    }
	}
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
	for(int row = 0; row < board[].length(); row++){
	    if(board[col][row] == 0){
		addQueen(col,row);
		if(col == board[].length() - 1){
		    solutionCount ++;
		}
		solveH(col+1);
		removeQueen(col,row);
	    }
	}
	return solutionCount > 0;
    }
    private void addQueen(int col, int row){
	board[col][row] = -1;
	for (int i = 0; i < board[].length(); i++){
	    if(board[col][i] > -1){
		board[col][i] += 1;
	    }
	    if(board[i][row] > -1){
		board[i][row] += 1;
	    }
	}
	
    }

    private void removeQueen(int col, int row){
    }
    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
    	return solutionCount;
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
