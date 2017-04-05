java.util.*;
public class MyLinkedList{
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
    LNode head,tail;
    int size;
    public MyLinkedList(){
	size = 0;
    }
    public int size(){
	return size;
    }
    private LNode getNthNode(int n){
	//throw exception
	LNode node = head;
	int i = 0;
	while (node != null && i < index){
	    if(i == index){
		return node;
	    }
	    i++;
	    node = node.next;
	} 
    }


    private void addAfter(LNode location, LNode toBeAdded){/*complete this*/  }


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
    }



    public String toString(){ /*complete this*/  }

    public boolean add(int value){
	add(size,value);
	return true;
    }

    public int get(int index){
        return getNthNode(index).value;
    }

    public int set(int index, int value){
	getNthNode(index).value = value;
	//look at this again
	//return int
    }

    public int indexOf(int value){/*complete this*/}

    public int remove(int index){
	int ans = getNthNode(index).value;
	remove(getNthNode(index));
	return ans;
    }

    public void add(int index,int value){
	//throw exception
	LNode tba = LNode(value);
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
	    tba.next = head;
	    head = tba;
	    size ++;
	}
	else if(index == size){
	    tail.next = tba;
	    tail = tba;
	    size ++;
	}
    }
}
