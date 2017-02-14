public class QueenBoard{

    private int[][]board;
    private int solutionCount = -1;
    private int side;

    public QueenBoard(int size){
	board = new int[size][size];
	empty(size);
	side = size;
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
	for(int row = 0; row < side; row++){    
	    if(board[col][row] == 0){
		addQueen(col,row);
		if(col == side-1){
		    return true;
		}
		else{
		    if(solveH(col+1)){
			return true;
		    }
		    else{
			removeQueen(col,row);
		    }
		}			
	    }
	}
	return false;
    }
    public void addQueen(int col, int row){
	board[col][row] = -1;
	for (int i = 0; i < side; i++){
	    if(board[col][i] > -1){
		board[col][i] += 1;
	    }
	    if(board[i][row] > -1){
		board[i][row] += 1;
	    }
	    try{
		if(board[col+i][row+i] > -1){
		    board[col+i][row+i] += 1;
		}
	    }
	    catch(IndexOutOfBoundsException e){
	    }
	    try{
		if(board[col-i][row-i] > -1){
		    board[col-i][row-i] += 1;
		}
	    }
	    catch(IndexOutOfBoundsException e){
	    }
	    try{
		if(board[col+i][row-i] > -1){
		    board[col+i][row-i] += 1;
		}
	    }
	    catch(IndexOutOfBoundsException e){
	    }
	    try{
		if(board[col-i][row+i] > -1){
		    board[col-i][row+i] += 1;
		}
	    }
	    catch(IndexOutOfBoundsException e){
	    }
	}
	
    }

    public void removeQueen(int col, int row){
	for (int i = 0; i < side; i++){
	    if(board[col][i] > -1){
		board[col][i] -= 1;
	    }
	    if(board[i][row] > -1){
		board[i][row] -= 1;
	    }
	    try{
		if(board[col+i][row+i] > -1){
		    board[col+i][row+i] -= 1;
		}
	    }
	    catch(IndexOutOfBoundsException e){
	    }
	    try{
		if(board[col-i][row-i] > -1){
		    board[col-i][row-i] -= 1;
		}
	    }
	    catch(IndexOutOfBoundsException e){
	    }
	    try{
		if(board[col+i][row-i] > -1){
		    board[col+i][row-i] -= 1;
		}
	    }
	    catch(IndexOutOfBoundsException e){
	    }
	    try{
		if(board[col-i][row+i] > -1){
		    board[col-i][row+i] -= 1;
		}
	    }
	    catch(IndexOutOfBoundsException e){
	    }
	    board[col][row] = 0;
	}
    }
    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public void countSolutions(){
	empty(side);
	solutionCount = 0;
	count(0);
    }
    public int getSolutionCount(){
    	return solutionCount;
    }
    private void count(int col){
	for(int row = 0; row < side; row++){    
	    if(board[col][row] == 0){
		addQueen(col,row);
		if(col == side-1){
		    solutionCount++;
		}
		else{
		    count(col + 1);
		}
		removeQueen(col,row);
		
	    }			
	}
    }

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	String ans = "";
	for(int col = 0; col<side;col++){
	    for(int row = 0; row<side;row++){
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
    public String toStringt(){
	String ans = "";
	for(int col = 0; col<side;col++){
	    for(int row = 0; row<side;row++){
		ans += board[col][row];
	    }
	    ans += "\n";
	}
	return ans;
    }
    public static void main(String[] args){
	QueenBoard a = new QueenBoard(5);
	//a.addQueen(5,6);
	//a.removeQueen(5,6);
        
        a.solve();
	System.out.println(a.toString());
        a.countSolutions();
	System.out.println(a.getSolutionCount());
    }
}
