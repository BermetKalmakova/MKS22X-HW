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
	try{
	    File x = new File(filename);
	    Scanner file = new Scanner(x).useDelimiter("\\r?\\n");
	    ArrayList<String> lines = new ArrayList<String>();
	    while (file.hasNext()){
		String[] a = file.next().split("\\s+")
		lines.add(a);
	    }
	}
	R = parseInt(lines.get(0).get(0));
	C = parseInt(lines.get(0).get(1));
	E = parseInt(lines.get(0).get(2));
	N = parseInt(lines.get(0).get(3));
	grid = new int[R][C];
	for(int i = 1; i < R + 1; i++){
	    for(int j = 0; j < C; j++){
		grid[i][j] = parseInt(lines.get(i).get(j));
	    }
	}
    }
    public int silver(String filename){
    }

}
