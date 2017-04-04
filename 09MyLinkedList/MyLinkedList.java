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


    private void remove(LNode target){/*complete this*/}



    public String toString(){ /*complete this*/  }

    public boolean add(int value){
	add(size,value);
	return true;
    }

    public int get(int index){
        return getNthNode(index).value;
    }

    public int set(int index, int value){
	getNthNode(index).value = this.value;
    }

    public int indexOf(int value){/*complete this*/}

    public int remove(int index){
	remove(getNthNode(index));
    }

    public void add(int index,int value){/*complete this*/}
}
