public class Merge{
    public void merge(int[]a, int[]b, int[]destination){
	int i = 0;
	while(i < destination.length){
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
	  
	}
    }
}
