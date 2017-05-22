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
	//remove top and replace w last and pushDown
    }
    public String peek(){
	if(arr.size() < 2){
	    throw new NoSuchElementException();
	}
	return arr.get(1);
    }
    private void pushUp(){
	//compare last w parent and switch if wrong
    }
    private void pushDown(){
	//compare top w children and switch w bigger/smaller if wrong
    }
}
