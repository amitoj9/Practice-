package datastructure;

public class LinkedListNode {
	int data;
	LinkedListNode next;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkedListNode getNext() {
		return next;
	}
	public void setNext(LinkedListNode next) {
		this.next = next;
	}
	public LinkedListNode(int data) {
		super();
		this.data = data;
	}
	
}
