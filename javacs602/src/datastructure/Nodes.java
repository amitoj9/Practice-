package datastructure;

public class Nodes {
	int data;
	Nodes right,left;
	boolean isrootNode;
	
	public boolean isIsrootNode() {
		return isrootNode;
	}
	public void setIsrootNode(boolean isrootNode) {
		this.isrootNode = isrootNode;
	}
	Nodes()
	{
		data=0;
		right=null;
		left=null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Nodes getRight() {
		return right;
	}
	public void setRight(Nodes right) {
		this.right = right;
	}
	public Nodes getLeft() {
		return left;
	}
	public void setLeft(Nodes left) {
		this.left = left;
	}
	
}
