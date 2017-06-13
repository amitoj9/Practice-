package datastructure;

import java.util.Stack;

public class PreOrderTraversal {
	public static void main(String args[])
	{
		BinaryTreeNode binaryTreeNode1= new BinaryTreeNode(1);
		BinaryTreeNode binaryTreeNode2= new BinaryTreeNode(2);
		BinaryTreeNode binaryTreeNode3= new BinaryTreeNode(3);
		BinaryTreeNode binaryTreeNode4= new BinaryTreeNode(4);
		BinaryTreeNode binaryTreeNode5= new BinaryTreeNode(5);
		BinaryTreeNode binaryTreeNode6= new BinaryTreeNode(6);
		BinaryTreeNode binaryTreeNode7= new BinaryTreeNode(7);
		binaryTreeNode1.setLeft(binaryTreeNode2);
		binaryTreeNode1.setRight(binaryTreeNode3);
		binaryTreeNode2.setLeft(binaryTreeNode4);
		binaryTreeNode2.setRight(binaryTreeNode5);
		binaryTreeNode3.setLeft(binaryTreeNode6);
		binaryTreeNode3.setRight(binaryTreeNode7);
		preOrderTraversal(binaryTreeNode1);
		System.out.println();
		preOrderTraversalIterative(binaryTreeNode1);
	}
	
	public static void preOrderTraversal(BinaryTreeNode root)
	{
		if(root!=null)
		{
			System.out.print(root.getData()+" ");
			preOrderTraversal(root.getLeft());
			
			
			preOrderTraversal(root.getRight());
		}
	}
	
	public static void preOrderTraversalIterative(BinaryTreeNode root)
	{
		Stack<BinaryTreeNode> stak=new Stack<BinaryTreeNode>();
		
		stak.push(root);
		
		while(!stak.isEmpty())
		{
			root=stak.pop();
			System.out.print(root.getData()+" ");
			if(root.getRight()!=null)
				stak.push(root.getRight());
			if(root.getLeft()!=null)
				stak.push(root.getLeft());
		}
		
	}

}
