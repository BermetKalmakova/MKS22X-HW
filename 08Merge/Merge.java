public class Merge{
    public static void merge(int[]a, int[]b, int[]destination){
	int i = 0;
	int x = 0;
	int y = 0;
	while(x < a.length && y < b.length){
	    if(a[x] <= b[y]){
		destination[i] = a[x];
		x++;
	    }
	    else{
		destination[i] = b[y];
		y++;
	    }
	    i++;
	}
	int q;
	int[] w;
	if(x<a.length){
	    q = x;
	    w= a;
	}
	else{
	    q = y;
	    w = b;
	}
	for(int j = q; j < w.length; j++){
	    destination[i] = w[j];
	    i++;
	}
    }
    public st
    public static void main(String[] args){
	int[] ex1 = {1,2,3,3,4,4,7,9};
	int[] ex2 = {3,3,5,6,7,10};
	int[] end = new int[14];
	merge(ex1,ex2,end);
	System.out.println(end);
    }
}
