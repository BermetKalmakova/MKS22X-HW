import java.util.*;
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
    public static void mergesort(int[]ary){
	if (ary.length >= 1){
	    return;
	}
	else{
	    int[]left = Arrays.copyOfRange(ary,0,ary.length/2);
	    int[]right = Arrays.copyOfRange(ary,ary.length/2,ary.length);
	    mergesort(left);
	    mergesort(right);
	    merge(left,right,ary);
	}
    }
    public static void main(String[] args){
	int[] ex1 = {7,4,90,3,6,12,4,75,34,0,7,4,5,7,3,2,564,756,47,896,3,2,4,56,54};
	int[] ex2 = {3,3,5,6,7,10};
	int[] end = new int[14];
	//rge(ex1,ex2,end);
	mergesort(ex1);
	for(int i = 0; i < ex1.length; i++){
	    System.out.println(ex1[i]);
	}
    }
}
