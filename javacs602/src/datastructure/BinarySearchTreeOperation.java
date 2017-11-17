package datastructure;

import java.util.Stack;

public class BinarySearchTreeOperation {
	
	static BinarySearchTree root;
	public static void main(String args[])
	{
		insert(5);

		insert(3);
		insert(4);
		insert(1);
		
		insert(2);
		
		
		insert(6);
		insert(7);
		System.out.println();
		inOrderTraversal(root);
		System.out.println();
		inOrderTraversalIterative(root);
		System.out.println();
		preOrderTraversal(root);
	}
	public static void insert(int data)
	{
		root=insertNodeInBinaryTree(root, data);
	}
	
	public static BinarySearchTree insertNodeInBinaryTree(BinarySearchTree root, int data)
	{
		if(root==null)
		{
			root=new BinarySearchTree();
			root.setData(data);
			root.setLeft(null);
			root.setRight(null);
			
		}
		else {
			if(root.getData()<data)
			{
				root.setRight(insertNodeInBinaryTree(root.getRight(), data));
			}
			else if(root.getData()>data)
			{
				root.setLeft(insertNodeInBinaryTree(root.getLeft(), data));
			}
			
		}
		return root;
	}
	
	public static void inOrderTraversal(BinarySearchTree root)
	{
		if(root!=null)
		{
			
			inOrderTraversal(root.left);
			System.out.print(root.getData());
			inOrderTraversal(root.right);
		}
		
	}
	
	public static void preOrderTraversal(BinarySearchTree root)
	{
		if(root!=null)
		{
			System.out.print(root.data);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	
	public static void preOrderTraversalIterative(BinarySearchTree root)
	{
		Stack<BinarySearchTree> st= new Stack<BinarySearchTree>();
		
		st.push(root);
		while(!st.isEmpty())
		{
			root=st.pop();
			System.out.print(root.data);
			if(root.right!=null)
			st.push(root.right);
			if(root.left!=null)
			st.push(root.left);
		}
	}
	public static void inOrderTraversalIterative(BinarySearchTree root)
	{
		
	}


}
