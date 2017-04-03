public class LNode extends MyLinkedList{
    public LNode nextNode;
    public int val;
    public LNode(int value){
	val = value;
    }
    public LNode(int value, LNode next){
	val = value;
	nextNode = next;
    }
    public int get(){
	return val;
    }
    public void set(int data){
	val = data;
    }
    
}
