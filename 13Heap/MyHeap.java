public class MyHeap{
    ArrayList<String> arr;
    boolean max;
    
    public MyHeap(){
	arr = new ArrayList<String>;
	arr.add("");
	max = true;
    }
    public MyHeap(boolean b){
	arr = new ArrayList<String>;
	arr.add("");
	max = b;
    }
    public void add(String s){
        arr.add(s);
	if(arr.size() > 2){
	    pushUp();
	}
    }
    public String remove(){
	if(arr.size() < 2){
	    throw new NoSuchElementException();
	}
	String x = arr.get(arr.size()-1);
	arr.remove(1);
	arr.remove(arr.size()-1);
	arr.add(1,x);
	pushDown();
    }
    public String peek(){
	if(arr.size() < 2){
	    throw new NoSuchElementException();
	}
	return arr.get(1);
    }
    private void pushUp(){
	int i = arr.size()-1;
	while (i > 1){
	    if(max){
		if(arr.get(i) <= arr.get(i/2)){
		    i = 0;
		}
		else{
		    String x = arr.get(i/2);
		    String y = arr.get(i);
		    arr.remove(i/2);
		    arr.add(i/2,y);
		    arr.remove(i);
		    arr.add(x);
		    i = i/2;
		}
	    }
	    else{
		if(arr.get(i) >= arr.get(i/2)){
		    i = 0;
		}
		else{
		    String x = arr.get(i/2);
		    String y = arr.get(i);
		    arr.remove(i/2);
		    arr.add(i/2,y);
		    arr.remove(i);
		    arr.add(i,x);
		    i = i/2;
		}
	    }
	}
    }
    private void pushDown(){
	int i = 1;
	while(i < arr.size()/2){
	    try{
		if(max){
		    if(arr.get(i) >= arr.get(2*i) && arr.get(i) >= arr.get(2*i+1)){
			return;
		    }
		    else{
			if(arr.get(2*i) > arr.get(2*i+1)){
			    String x = arr.get(2*i);
			    String y = arr.get(i);
			    arr.remove(2*i);
			    arr.add(2*i,y);
			    arr.remove(i);
			    arr.add(i,x);
			    i = i*2;
			}
			else{
			    String x = arr.get(2*i+1);
			    String y = arr.get(i);
			    arr.remove(2*i+1);
			    arr.add(2*i+1,y);
			    arr.remove(i);
			    arr.add(i,x);
			    i = i*2+1;
			}
		    }
		}
		else{
		    if(arr.get(i) <= arr.get(2*i) && arr.get(i) <= arr.get(2*i+1)){
			return;
		    }
		    else{
			if(arr.get(2*i) < arr.get(2*i+1)){
			    String x = arr.get(2*i);
			    String y = arr.get(i);
			    arr.remove(2*i);
			    arr.add(2*i,y);
			    arr.remove(i);
			    arr.add(i,x);
			    i = i*2;
			}
			else{
			    String x = arr.get(2*i+1);
			    String y = arr.get(i);
			    arr.remove(2*i+1);
			    arr.add(2*i+1,y);
			    arr.remove(i);
			    arr.add(i,x);
			    i = i*2+1;
			}
		    }
		}
	    }
	}
    }
    public String toString(){
	String ans = "";
	int i = Math.log(arr.size())/Math.log(2);
	int l = 1;
	while(l < arr.size()){
	    for (int j = 1; j < i; j++){
		for(int x = 0; x < (i - j)*2-1; x ++){
		    ans += " ";
		}
		while(
	}
    }
}
