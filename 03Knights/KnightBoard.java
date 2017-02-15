public class KnightBoard{
    private int[][]board;
    
    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	fill(startingRows,startingCols);
    }
    private void fill(int a, int b){
	for(int i = 0; i < a; i ++){
	    for(int j = 0; j < b; j ++){
		board[i][j] = 0;
	    }
	}
    }
    
    public String toString(){
    }
    public void solve(){
	solveH(0,0,1)
    }
    private boolean solveH(int row, int col, int level){
	private int[] a = {1,2};
	private int[] b = {1,2};
	if(level > board.length * board[].length){
	    return true;
	}
	if(board[row][col] == 0){
	    board[row][col] = level;
	    
	}
    }
}
