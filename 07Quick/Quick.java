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
    public static void quicksort(int[] data){
	quicksorth(data,0,data.length-1);
    }
    public static void quicksorth(int[] data, int start, int end){
	if(start<end){
	    int[] x = part(data, start, end);
	    quicksorth(data,start,x[0]-1);
	    quicksorth(data,x[1]+1,end);
	}
    }
    // public static void main(String[]args){
    // 	int[] ex = {0, 7, 6,5,5,5,5,2,9,11,1,1,1,1,1,1,1,5,3,2,4,6,7,9,6,1,1,1,5,3,2,3,4,5,9,0,7,35,68,35,98,24,46,054, 6, 6, 2, 1, 9, 2, 1, 5};
    // 	System.out.println(quickselect(ex,6));
    // 	//quicksort(ex);
    // 	for(int i = 0; i < ex.length; i++){
    // 	    System.out.println(ex[i]);
    // 	}
    // }
    
		
}
