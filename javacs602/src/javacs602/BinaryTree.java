package javacs602;

public class BinaryTree {  
  
   
 public static class TreeNode  
 {  
  int data;  
  TreeNode left;  
  TreeNode right;  
  TreeNode(int data)  
  {  
   this.data=data;  
  }  
 }  
public void inOrder(TreeNode root) {  
if(root !=  null) {  
inOrder(root.left);  
//Visit the node by Printing the node data    
System.out.printf("%d ",root.data);  
inOrder(root.right);  
}  
}  

 public void postOrder(TreeNode root) {  
  if(root !=  null) {  
   postOrder(root.left);  
   postOrder(root.right);  
   //Visit the node by Printing the node data    
   System.out.printf("%d ",root.data);  
  }  
 }  
 public void preorder(TreeNode root) {  
	    if(root !=  null) {  
	   //Visit the node by Printing the node data    
	      System.out.printf("%d ",root.data);  
	      preorder(root.left);  
	      preorder(root.right);  
	    }  
	  }  

   
 public static void main(String[] args)  
 {  
  BinaryTree bi=new BinaryTree();  
  // Creating a binary tree  
  TreeNode rootNode=createBinaryTree();  
  System.out.println("Using Inorder solution:");  
  
  bi.inOrder(rootNode);  
  System.out.println();
  
  System.out.println("Using postorder solution:");
  bi.postOrder(rootNode);
  System.out.println();
  
  System.out.println("Using preorder solution:");
  bi.preorder(rootNode);
  System.out.println();
  System.out.println("MAX IS "+getMax(rootNode));
 }  
   
 public static TreeNode createBinaryTree()  
 {  
    
  TreeNode rootNode =new TreeNode(49);  
  TreeNode node28=new TreeNode(28);  
  TreeNode node83=new TreeNode(83);  
  TreeNode node11=new TreeNode(11);  
  TreeNode node18=new TreeNode(18);  
  TreeNode node19=new TreeNode(19);  
  TreeNode node40=new TreeNode(40);
  TreeNode node44=new TreeNode(44);
  TreeNode node69=new TreeNode(69);
  TreeNode node71=new TreeNode(71);
  TreeNode node72=new TreeNode(72);
  TreeNode node92=new TreeNode(92);
  TreeNode node97=new TreeNode(97);
  TreeNode node99=new TreeNode(99);
  TreeNode node32=new TreeNode(32);
    
  rootNode.left=node28;  
  rootNode.right=node83;  
    
  node28.left=node18;  
  node28.right=node40;  
    
  node18.left=node11;  
  node18.right=node19;
  node40.left=node32;  
  node40.right=node44;
  node83.left=node71;  
  node83.right=node97;
  node71.left=node69;  
  node71.right=node72;
  node97.left=node92;  
  node97.right=node99;
  
    
  return rootNode;  
 }  
 public static int getMax(TreeNode root) {
		if (root != null) {
			return max(root.data, getMax(root.left), getMax(root.right));
		}
		return 0;
	}

	public static int max(int a, int b, int c) {
		return (Math.max(a, Math.max(b, c)));
	}
}  
