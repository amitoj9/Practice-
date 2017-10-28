package practice;

import java.util.Scanner;

@SuppressWarnings("serial")
public class BinaryTreeMain {



	// Launch the application.
	public static void main(String[] args) {
					BinaryTreeMain frame = new BinaryTreeMain();
	}

	// Create the frame.
public BinaryTreeMain() 
{

	System.out.println("CS 610- Binary Expression Tree");
	System.out.println("Implementation of a Binary Tree ADT **");
	System.out.println("Enter a valid Expression");
	Scanner sc = new Scanner(System.in);
	String validExpression=sc.next();
	
	
	CArithmeticTree tree = new CArithmeticTree();
	tree.buildTree(validExpression);
	System.out.println("The evaluate expression by traversing the tree is");
	System.out.println(tree.evalTree());

 }

}