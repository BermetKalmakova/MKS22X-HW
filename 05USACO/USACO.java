import java.util.*;
import java.io.*;
public class USACO{
    public void USACO(){
    }
    public int bronze(String filename){
	int R = -1;
	int C = -1;
	int E = -1;
	int N = -1;
	int[][] grid;
	int[][] instructions;
	int sum = 0;
	try{
	    File x = new File(filename);
	    Scanner file = new Scanner(x).useDelimiter("\\r?\\n");
	    ArrayList<String[]> lines = new ArrayList<String[]>();
	    while (file.hasNext()){
		String[] a = file.next().split("\\s+");
		lines.add(a);
	    }
	
	    R = Integer.parseInt(lines.get(0)[0]);
	    C = Integer.parseInt(lines.get(0)[1]);
	    E = Integer.parseInt(lines.get(0)[2]);
	    N = Integer.parseInt(lines.get(0)[3]);
	    grid = new int[R][C];
	    for(int i = 1; i < R + 1; i++){
		for(int j = 0; j < C ; j++){
		    grid[i-1][j] = Integer.parseInt(lines.get(i)[j]);
		}
	    }
	    for (int n = R+1; n < R + N + 1; n++){
		int max = -1;
		for (int q = Integer.parseInt(lines.get(n)[0])-1; q < Integer.parseInt(lines.get(n)[0]) + 2; q++){
		    for (int w = Integer.parseInt(lines.get(n)[1])-1; w < Integer.parseInt(lines.get(n)[1]) + 2; w++){
			try{
			    if (max == -1){
				max = grid[q][w];
			    }
			    else{
				if (grid[q][w] > max){
				    max = grid[q][w];
				}
			    }
			    
			}
			catch (IndexOutOfBoundsException e){
			}
		    }
		}
		for (int s = Integer.parseInt(lines.get(n)[0])-1; s < Integer.parseInt(lines.get(n)[0]) + 2; s++){
		    for (int y = Integer.parseInt(lines.get(n)[1])-1; y < Integer.parseInt(lines.get(n)[1]) + 2; y++){
			try{
			    if(grid[s][y] > max-Integer.parseInt(lines.get(n)[2])){
				grid[s][y] = max-Integer.parseInt(lines.get(n)[2]);
			    }
			}
			catch (IndexOutOfBoundsException e){
			}
		    }
		}
	    }

	    for(int i = 1; i < R + 1; i++){
		for(int j = 0; j < C; j++){
		    grid[i-1][j] = E - grid[i-1][j];
		    if (grid[i-1][j] > 0){
			sum += grid[i-1][j];
		    }
		}
	    }
	}
	catch(FileNotFoundException s){
	}
	
	return sum * 72 * 72;
    }
    public int silver(String filename){
	int N = -1;
	int M = -1;
	int T = -1;
	int R1 = -1;
	int C1 = -1;
	int R2 = -1;
	int C2 = -1;
	char[][] grid;
	int[][][] moves;
	int ans = 0;
	try{
	    File x = new File(filename);
	    Scanner file = new Scanner(x).useDelimiter("\\r?\\n");
	    ArrayList<String> lines = new ArrayList<String>();
	    while (file.hasNext()){
		lines.add(file.next());
	    }
	    String[] line1 = lines.get(0).split("\\s+");
	    N = Integer.parseInt(line1[0]);
	    M = Integer.parseInt(line1[1]);
	    T = Integer.parseInt(line1[2]);

	    String[] linecoord = lines.get(N+1).split("\\s+");
	    R1 = Integer.parseInt(linecoord[0]);
	    C1 = Integer.parseInt(linecoord[1]);
	    R2 = Integer.parseInt(linecoord[2]);
	    C2 = Integer.parseInt(linecoord[3]);

	    grid = new char[N][M];
	    moves = new int[T][N][M];
	    for(int i = 0;i < N; i++){
		for(int j = 0; j < M; j++){
		    grid[i][j] = lines.get(i+1).charAt(j);
		    if(grid[i][j] == '.'){
			moves[0][i][j] = 0;
		    }
		    else{
			moves[0][i][j] = -1;
		    }
		}
	    }
	    moves[0][R1-1][C1-1] = 1;
	    for(int a = 1; a < T+1; a++){
		for(int b = 0; b < N; b++){
		    for(int c = 0; c < M; c++){
			int sum = 0;
			try{
			    if(moves[a-1][b+1][c] > -1){
				sum += moves[a-1][b+1][c];
			    }
			}
			catch(IndexOutOfBoundsException e){
			}
			try{
			    if(moves[a-1][b-1][c] > -1){
				sum += moves[a-1][b-1][c];
			    }
			}
			catch(IndexOutOfBoundsException e){
			}
			try{
			    if(moves[a-1][b][c+1] > -1){
				sum += moves[a-1][b][c+1];
			    }
			}
			catch(IndexOutOfBoundsException e){
			}
			try{
			    if(moves[a-1][b][c-1] > -1){
				sum += moves[a-1][b][c-1];
			    }
			}
			catch(IndexOutOfBoundsException e){
			}
			moves[a][b][c] = sum;
			System.out.println(toString(moves));
		    }
		}
	    }
	    ans = moves[T][R2-1][C2-1];
	}
	catch(FileNotFoundException d){
	}
	return ans;
    }
    public String toString(int[][][] ex){
    	String ans = "";
	for (int t = 0; t < ex.length;t++){
	    for(int col = 0; col<ex[0].length;col++){
		for(int row = 0; row<ex[0][0].length;row++){
		    ans += ex[t][col][row];
		}
		ans += "\n";
	    }
	}
    	return ans;
    }
    public static void main(String[] args){
    	USACO x = new USACO(); //does not have to do anything. 

    	System.out.println (x.silver("ctravel.in"));
    }
}
