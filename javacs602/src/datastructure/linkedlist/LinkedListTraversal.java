package datastructure.linkedlist;

import java.util.HashSet;

public class LinkedListTraversal {
	
	public static void main(String args[])
	{
		Node head= new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(1);
//		printLinkedList(head);
//		insertNodeAtLast(head,34);
		
//		printLinkedList(head);
		
//		deleteNode(head,34);
//		printLinkedList(head);
//		deleteNode(head,2);
//		printLinkedList(head);
//		insertNodeAtParticularPosition(head, 234, 2);
//		printLinkedList(head);
//		System.out.println(length(head));
//		System.out.println(search(head, 55));
//		swapNodes(head,3,234);
//		printLinkedList(head);
//		printLinkedList(reverseLinkList(head));
//		System.out.println(detectCycle(head));
//		detectCycleFloyd(head);
		System.out.println(isPalindrome(head));
		printLinkedList(mergerSortedLinkedList(head,new Node(33)));
	}
	
	public static void printLinkedList(Node head)
	{
		while(head!= null)
		{
			System.out.println(head.data);
			head=head.next;
		}
	}
	
	public static void insertNodeAtLast(Node head,int data)
	{
		if(head==null)
		{
			Node n=new Node(data);
			head=n;
		}
		else
		{
				while (head.next!=null)
				{
					head=head.next;
				}
				head.next=new Node(data);
				return;
		}
	}
	
	public static void insertNodeAtParticularPosition(Node head, int data,int position)
	{
		if(head==null)
		{
			head=new Node(data);
			return;
		}
		int i=0;
		while(i<position-1)
		{
		head=head.next;
		i++;
		}
		Node n=new Node(data);
		n.next=head.next;
		head.next=n;
		
		
	}
	public static void deleteNode(Node head,int data)
	{
	
			Node previous=null;
			while(head!=null&&head.data!=data)
			{
				previous=head;
				head=head.next;
			}
			if(head==null)
			{
				return;
			}
			previous.next=head.next;
	}
	
	public static void deleteNodeAtPosition(Node head,int position)
	{
		if(head==null)
		{
			return;
		}
		
		Node previous=null;
		int i=0;
		
		while(head.next!=null&&(i<position-1))
		{
			head=head.next;
			i++;
		}
		if(head==null ||head.next!=null)
		{
			return;
		}
		head.next=head.next.next;
	}
	
	public static int length(Node head)
	{
		int count=0;
		
		while(head!=null)
		{
			head=head.next;
			count++;
		}
		return count;
	}
	
	public static boolean search(Node head, int x)
	{
		while(head!=null)
		{
			if(head.data==x)
			{
				return true;
			}
			head=head.next;
		}
		return false;
	}
	 public static void swapNodes(Node head,int x, int y)
	    {
	        // Nothing to do if x and y are same
	        if (x == y) return;
	 
	        // Search for x (keep track of prevX and CurrX)
	        Node prevX = null, currX = head;
	        while (currX != null && currX.data != x)
	        {
	            prevX = currX;
	            currX = currX.next;
	        }
	 
	        // Search for y (keep track of prevY and currY)
	        Node prevY = null, currY = head;
	        while (currY != null && currY.data != y)
	        {
	            prevY = currY;
	            currY = currY.next;
	        }
	 
	        // If either x or y is not present, nothing to do
	        if (currX == null || currY == null)
	            return;
	 
	        // If x is not head of linked list
	        if (prevX != null)
	            prevX.next = currY;
	        else //make y the new head
	            head = currY;
	 
	        // If y is not head of linked list
	        if (prevY != null)
	            prevY.next = currX;
	        else // make x the new head
	            head = currX;
	 
	        // Swap next pointers
	        Node temp = currX.next;
	        currX.next = currY.next;
	        currY.next = temp;
	    }
	 
	 public static Node reverseLinkList(Node node)
	 {
		 Node prev = null;
	        Node current = node;
	        Node next = null;
	        while (current != null) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        node = prev;
	        return node;
	 }
	 
	 public static boolean detectCycle(Node head)
	 {
		 HashSet<Node> nn=new HashSet<Node>();
		 
		 while(head!=null)
		 {
			 if(nn.contains(head))
				 {
				 return true;
				 }
			 nn.add(head);	 
			 head=head.next;
				 
		 }
		 
		 return false;
	 }
	 
	 public static int detectCycleFloyd(Node head)
	 {
		 Node fastNode=head;
		 Node slowNode=head;
		 while(slowNode!=null && fastNode!=null && fastNode.next!=null)
		 {
			 slowNode=slowNode.next;
			 fastNode=fastNode.next.next;
			 if(slowNode==fastNode)
			 {
				 System.out.println("Loop found at "+slowNode.data);
				 return 0;
			 }
		 }
		 return -1;
	 }
	 
	 public static Node mergerSortedLinkedList(Node l1,Node l2)
	 {
		  Node head = new Node(0);
		    Node p = head;
		 
		    while(l1!=null||l2!=null){
		        if(l1!=null&&l2!=null){
		            if(l1.data < l2.data){
		                p.next = l1;
		                l1=l1.next;
		            }else{
		                p.next=l2;
		                l2=l2.next;
		            }
		            p = p.next;
		        }else if(l1==null){
		            p.next = l2;
		            break;
		        }else if(l2==null){
		            p.next = l1;
		            break;
		        }
		    }
		 
		    return head.next;
	 }
	 
	 public static boolean isPalindrome(Node head)
	 {
		 if(head == null || head.next==null)
		        return true;
		 
		    //find list center
		 Node fast = head;
		 Node slow = head;
		 
		    while(fast.next!=null && fast.next.next!=null){
		        fast = fast.next.next;
		        slow = slow.next;
		    }
		 
		    Node secondHead = slow.next;
		    slow.next = null;
		 
		    //reverse second part of the list
		    Node p1 = secondHead;
		    Node p2 = p1.next;
		 
		    while(p1!=null && p2!=null){
		    	Node temp = p2.next;
		        p2.next = p1;
		        p1 = p2;
		        p2 = temp;
		    }
		 
		    secondHead.next = null;
		 
		    //compare two sublists now
		    Node p = (p2==null?p1:p2);
		    Node q = head;
		    while(p!=null){
		        if(p.data != q.data)
		            return false;
		 
		        p = p.next;
		        q = q.next;
		 
		    }
		 
		    return true;
	 }
	 
	 public static boolean compareList(Node list1,Node list2)
	 {
		 Node temp1=list1;
		 Node temp2=list2;
		 while(temp1.next!=null && temp2.next!=null)
		 {
			 if(temp1.data==temp2.data)
			 {
				 temp1=temp1.next;
				 temp2=temp2.next;
			 }
			 else 
				 {
				 return false;
				 }
				 
		 }
		 return true;
	 }
}
