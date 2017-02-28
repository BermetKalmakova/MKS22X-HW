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
		countPossible(i,j);
	    }
	}
    }

    private void countPossible(int a, int b){
	try{
	    if(board[a+2][b+1] == 0){
		numPossible[a][b] ++;
	    }
	}
	catch(IndexOutOfBoundsException e){
	}
	try{
	    if(board[a+2][b-1] == 0){
		numPossible[a][b] ++;
	    }
	}
	catch(IndexOutOfBoundsException e){
	}
	try{
	    if(board[a-2][b+1] == 0){
		numPossible[a][b] ++;
	    }
	}
	catch(IndexOutOfBoundsException e){
	}
	try{
	    if(board[a-2][b-1] == 0){
		numPossible[a][b] ++;
	    }
	}
	catch(IndexOutOfBoundsException e){
	}
	try{
	    if(board[a+1][b+2] == 0){
		numPossible[a][b] ++;
	    }
	}
	catch(IndexOutOfBoundsException e){
	}
	try{
	    if(board[a-1][b+2] == 0){
		numPossible[a][b] ++;
	    }
	}
	catch(IndexOutOfBoundsException e){
	}
	try{
	    if(board[a+1][b-2] == 0){
		numPossible[a][b] ++;
	    }
	}
	catch(IndexOutOfBoundsException e){
	}
	try{
	    if(board[a-1][b-2] == 0){
		numPossible[a][b] ++;
	    }
	}
	catch(IndexOutOfBoundsException e){
	}
    }
    
    public String toString(){
	String ans = "";
	for(int col = 0; col<board[0].length;col++){
	    for(int row = 0; row<board.length;row++){
		if(board[row][col] < 10){
		    ans += " ";
		}
		ans += board[row][col] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }
    public void solve(){
	solveH(0,0,1);
    }
    private int newR;
    private int newC;
    private boolean solveH(int row, int col, int level){
	if(level > board.length * board[0].length){
	    return true;
	}
	if(board[row][col] == 0){
	    board[row][col] = level;
	    
	    if(tryMoves(row,col,level) || level == board.length * board[0].length){
		return true;
	    }
	    else{
		board[row][col] = 0;
		//level--;
	    }
	    
	}
	return false;
    }
    //figure out which choice has the least possiblities and change numPossible to reflect that nvm
    private boolean tryMoves(int a,int b, int level){
	try{
	    if(board[a+2][b+1] == 0){
		numPossible[a][b] ++;
		newR = a+2;
		newC = b+1;
	        if(solveH(newR,newC,level+1)){
		    return true;
		}
	    }
	}
	catch(IndexOutOfBoundsException e){
	}
	try{
	    if(board[a+2][b-1] == 0){
		numPossible[a][b] ++;
		newR = a+2;
		newC = b-1;
		if(solveH(newR,newC,level+1)){
		    return true;
		}
	    }
	}
	catch(IndexOutOfBoundsException e){
	}
	try{
	    if(board[a-2][b+1] == 0){
		numPossible[a][b] ++;
		newR = a-2;
		newC = b+1;
		if(solveH(newR,newC,level+1)){
		    return true;
		}
	    }
	}
	catch(IndexOutOfBoundsException e){
	}
	try{
	    if(board[a-2][b-1] == 0){
		numPossible[a][b] ++;
		newR = a-2;
		newC = b-1;
		if(solveH(newR,newC,level+1)){
		    return true;
		}
	    }
	}
	catch(IndexOutOfBoundsException e){
	}
	try{
	    if(board[a+1][b+2] == 0){
		numPossible[a][b] ++;
		newR = a+1;
		newC = b+2;
		if(solveH(newR,newC,level+1)){
		    return true;
		}
	    }
	}
	catch(IndexOutOfBoundsException e){
	}
	try{
	    if(board[a-1][b+2] == 0){
		numPossible[a][b] ++;
		newR = a-1;
		newC = b+2;
		if(solveH(newR,newC,level+1)){
		    return true;
		}
	    }
	}
	catch(IndexOutOfBoundsException e){
	}
	try{
	    if(board[a+1][b-2] == 0){
		numPossible[a][b] ++;
		newR = a+1;
		newC = b-2;
		if(solveH(newR,newC,level+1)){
		    return true;
		}
	    }
	}
	catch(IndexOutOfBoundsException e){
	}
	try{
	    if(board[a-1][b-2] == 0){
		numPossible[a][b] ++;
		newR = a-1;
		newC = b-2;
		if(solveH(newR,newC,level+1)){
		    return true;
		}
	    }
	}
	catch(IndexOutOfBoundsException e){
	}
	return false;
    }
    public static void main(String[] args){
	KnightBoard a = new KnightBoard(7,7);
	a.solve();
	System.out.println(a.toString());
    }
}
