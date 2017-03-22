import java.util.Random;
public class Quick{
    public static int[] part(int[] data, int start, int end){
	Random rand = new Random();
	int x = rand.nextInt(end-start+1) + start;
	int[] ans = new int[2];
	int s = start;
	int i = start + 1;
	int e = end;
	int v = data[x];
	swap(data, start, x);

	while(i <= e){
	    if(data[i] == v){
		i ++;
	    }
	    else if(data[i] < v){
		swap(data, s, i);
		s++;
		i++;
	    }
	    else{
		swap(data, i, e);
		e--;
	    }
	}
	ans[0] = s;
	ans[1] = e;
	return ans;
    }
    public static void swap(int[] array, int i, int j) {
	int temp = array[i];
	array[i] = array[j];
	array[j] = temp;
    }
    public static int quickselect(int[] data, int k){
    	return quickselectH(data,k,0,data.length-1);
    }
    public static int quickselectH(int[] data, int k, int start, int end){
    	int[] x = part(data,start,end);
    	if(k >= x[0] && k <= x[1]){
    	    return data[k];
    	}
    	if(x[1] < k){
    	    return quickselectH(data,k,x[1]+1,end);
    	}
    	return quickselectH(data,k,start,x[0]-1);
    }
    public static void main(String[]args){
    	int[] ex = {0, 7, 6, 9, 2, 1, 5};
    	System.out.println(quickselect(ex,5));
    	for(int i = 0; i < ex.length; i++){
    	    System.out.println(ex[i]);
    	}
    }
    
		
}
