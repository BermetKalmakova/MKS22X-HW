public class KnightBoard{
    private int[][]board;
    private int[][]numPossible;
    
    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	numPossible = new int[startingRows][startingCols];
	fill(startingRows,startingCols);
    }
    private void fill(int a, int b){
	for(int i = 0; i < a; i ++){
	    for(int j = 0; j < b; j ++){
		board[i][j] = 0;
		numPossible[i][j] = 0;
		countPossible[i][j];
	    }
	}
    }

    private void countPossible(int a, int b){
	try{
	    if(board[a+2][b+1] == 0){
		numPossible[a][b] ++;
	    }
	}
	try{
	    if(board[a+2][b-1] == 0){
		numPossible[a][b] ++;
	    }
	}
	try{
	    if(board[a-2][b+1] == 0){
		numPossible[a][b] ++;
	    }
	}
	try{
	    if(board[a-2][b-1] == 0){
		numPossible[a][b] ++;
	    }
	}
	try{
	    if(board[a+1][b+2] == 0){
		numPossible[a][b] ++;
	    }
	}
	try{
	    if(board[a-1][b+2] == 0){
		numPossible[a][b] ++;
	    }
	}
	try{
	    if(board[a+1][b-2] == 0){
		numPossible[a][b] ++;
	    }
	}
	try{
	    if(board[a-1][b-2] == 0){
		numPossible[a][b] ++;
	    }
	}
    }
    
    public String toString(){
    }
    public void solve(){
	solveH(0,0,1)
    }
    private int newR;
    private int newC;
    private boolean solveH(int row, int col, int level){
	private int[] a = {1,2};
	private int[] b = {1,2};
	if(level > board.length * board[].length){
	    return true;
	}
	if(board[row][col] == 0){
	    board[row][col] = level;
	    if(tryMoves(row,col)){
		if(solveH(newR,newC,level+1)){
		    return true;
		}
	    }
	    board[row][col] = 0;
	    
	}
	return false;
    }
    //figure out which choice has the least possiblities and change numPossible to reflect that nvm
    private boolean tryMoves(int a,int b){
	try{
	    if(board[a+2][b+1] == 0){
		numPossible[a][b] ++;
		newR = a+2;
		newC = b+1;
		return true;
	    }
	}
	try{
	    if(board[a+2][b-1] == 0){
		numPossible[a][b] ++;
		newR = a+2;
		newC = b+1;
		return true;
	    }
	}
	try{
	    if(board[a-2][b+1] == 0){
		numPossible[a][b] ++;
		newR = a+2;
		newC = b+1;
		return true;
	    }
	}
	try{
	    if(board[a-2][b-1] == 0){
		numPossible[a][b] ++;
	    }
	}
	try{
	    if(board[a+1][b+2] == 0){
		numPossible[a][b] ++;
	    }
	}
	try{
	    if(board[a-1][b+2] == 0){
		numPossible[a][b] ++;
	    }
	}
	try{
	    if(board[a+1][b-2] == 0){
		numPossible[a][b] ++;
	    }
	}
	try{
	    if(board[a-1][b-2] == 0){
		numPossible[a][b] ++;
	    }
	}
	return false;
    }
}
