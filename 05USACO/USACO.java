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
	return 0;
    }
    // public String toString(int[][] ex){
    // 	String ans = "";
    // 	for(int col = 0; col<ex.length;col++){
    // 	    for(int row = 0; row<ex[0].length;row++){
    // 		ans += ex[col][row];
    // 	    }
    // 	    ans += "\n";
    // 	}
    // 	return ans;
    // }
    // public static void main(String[] args){
    // 	USACO x = new USACO(); //does not have to do anything. 

    // 	System.out.println (x.bronze("makelake.in"));
    // }
}
