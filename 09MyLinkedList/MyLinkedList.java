import java.util.*;
public class MyLinkedList implements Iterable<Integer>{
    private class LNode{
	LNode next,prev;
	int value;
	public LNode(int value){
	    this.value = value;
	}
	public String toString(){
	    return value + "";
	}
	//get set
    }
    private class LinkedListIterator implements Iterator<Integer>{
	private LNode x;
	private int i;
	public LinkedListIterator(MyLinkedList a){
	    x = a.head;
	    i = 0;
	}
	public boolean hasNext(){
	    return x.next != null;
	}
	public Integer next(){
	    if(i == 0){
		i ++;
		return x.value;
	    }
	    if(hasNext()){
		i++;
		x = x.next;
		return x.value;
	    }
	    else{
		throw new NoSuchElementException();
	    }
	}
	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    LNode head,tail;
    int size;
    public MyLinkedList(){
	size = 0;
    }
    public int size(){
	return size;
    }
    private LNode getNthNode(int n){
	if(n > size - 1){
	    throw new IndexOutOfBoundsException();
	}
	LNode node = head;
	int i = 0;
	while (node != null && i < n){
	    if(i == n){
		return node;
	    }
	    i++;
	    node = node.next;
	}
	return node;
    }
    private void addAfter(LNode location, LNode toBeAdded){
	toBeAdded.prev = location;
	toBeAdded.next = location.next;
	location.next.prev = toBeAdded;
	location.next = toBeAdded;
    }


    private void remove(LNode target){
	if(size == 1){
	    head = null;
	    tail = null;
	    size --;
	}
	else if(target == head){
	    head = head.next;
	    head.prev = null;
	    size --;
	}
	else if(target == tail){
	    tail = tail.prev;
	    tail.next = null;
	    size--;
	}
	else{
	    target.prev.next = target.next;
	    target.next.prev = target.prev;
	    size --;
	}
    }



    public String toString(){
	String ans = "[";
	for(int i = 0; i < size; i++){
	    if(i < size - 1){
		ans += getNthNode(i).value + ",";
	    }
	    else{
		ans += getNthNode(i).value;
	    }
	}
	return ans + "]" ;
    }

    public boolean add(int value){
	add(size,value);
	return true;
    }

    public int get(int index){
        return getNthNode(index).value;
    }

    public int set(int index, int valuen){
	int ans = getNthNode(index).value;
	getNthNode(index).value = valuen;
        return ans;
    }

    public int indexOf(int value){
        for(int i = 0; i < size; i++){
	    if(getNthNode(i).value == value){
		return i;
	    }
	}
	return -1;
    }

    public int remove(int index){
	int ans = getNthNode(index).value;
	remove(getNthNode(index));
	return ans;
    }

    public void add(int index,int value){
        if(index > size){
	    throw new IndexOutOfBoundsException();
	}
	LNode tba = new LNode(value);
	if(size == 0){
	    head = tba;
	    tail = tba;
	    size ++;
	}
	else if(index < size && index > 0){
	    tba.next = getNthNode(index);
	    tba.prev = getNthNode(index-1);
	    getNthNode(index).prev = tba;
	    getNthNode(index-1).next = tba;
	    size ++;
	}
	else if(index == 0){
	    head.prev = tba;
	    tba.next = head;
	    head = tba;
	    size ++;
	}
	else if(index == size){
	    tba.prev = tail;
	    tail.next = tba;
	    tail = tba;
	    size ++;
	}
    }
    public Iterator<Integer> iterator(){
	return new LinkedListIterator(this);
    }
    // public static void main(String[] args){
    // 	MyLinkedList ex = new MyLinkedList();
    // 	System.out.println(ex.toString());
    // 	ex.add(3);
    // 	ex.add(0,5);
    //     ex.add(7);
    // 	ex.add(1,6);
    // 	ex.set(0,1);
    //     Iterator a = ex.iterator();
    // 	while(a.hasNext()){
    // 	    System.out.println(a.next());
    // 	}
    // }
}
