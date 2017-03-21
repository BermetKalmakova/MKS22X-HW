import java.util.Random;
public class Quick{
    public static int part(int[] data, int start, int end){
	Random rand = new Random();
	int x = rand.nextInt(end-start+1) + start;

	int s = start + 1;
	int i = start + 1;
	int e = end;
	swap(data, 0, x);
	int v = data[0];
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
	}
	return data[s];
    }
    public static int quickselect(int[] data, int k){
	return quickselectH(data,k,0,data.length-1);
    }
    public static int quickselectH(int[] data, int k, int start, int end){
	int x = part(data,start,end);
	if(x == k){
	    return data[k];
	}
	if(x < k){
	    return quickselectH(data,k+1,x,end);
	}
	return quickselectH(data,k,start,k-1);
    }
    public static void main(String[]args){
    	int[] ex = {0, 7, 6, 9, 2, 1, 5};
    	System.out.println(quickselect(ex, 0));
    	for(int i = 0; i < ex.length; i++){
    	    System.out.println(ex[i]);
    	}
    }
		
}
