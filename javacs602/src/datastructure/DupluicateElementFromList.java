package datastructure;

import java.util.HashSet;

public class DupluicateElementFromList {

	public static void main(String args[])
	{
	
		LinkedListNode node=new  LinkedListNode(1);
		LinkedListNode node2=new  LinkedListNode(2);
		LinkedListNode node3=new  LinkedListNode(1);
		LinkedListNode node4=new  LinkedListNode(11);
		LinkedListNode node5=new  LinkedListNode(1);
		LinkedListNode node6=new  LinkedListNode(12);
		LinkedListNode node7=new  LinkedListNode(3);
		LinkedListNode node8=new  LinkedListNode(2);
		node.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		node7.setNext(node8);
		
	/*	do
		{
			System.out.println(node.data);
			node=node.next;
		}while(node!=null);*/
		/*LinkedListNode previous=deleteDuplicateElemnent(node);
		do
		{
			System.out.println(previous.data);
			previous=previous.next;
		}while(previous!=null);*/
		printKthIndex(node,2);
	}
	
/*	public static LinkedListNode deleteDuplicateElemnent(LinkedListNode node)
	{
		LinkedListNode previous=null;
		HashSet<Integer> integers=new HashSet<Integer>(); 
		while(node!=null)
		{
			if(integers.contains(node.data))
			{
				previous.next=node.next;
			}
			else{
				integers.add(node.data);
				previous=node;
			}
			node=node.next;
		}
		return previous;
	}*/
	//Without hashset
	public static LinkedListNode deleteDuplicateElemnent(LinkedListNode node)
	{
		LinkedListNode previous=node;
		while(node!=null){
			LinkedListNode runner=node;
			while(runner.next!=null){
				if(runner.next.data==node.data){
					runner.next=runner.next.next;
				}
				else{
					runner=runner.next;
				}
				
			}
			node=node.next;
		}
		return previous;
	}
	
	public static int printKthIndex(LinkedListNode node,int k)
	{
		if(node==null)
		{
			return 0;
		}
		else
		{
			int index=	printKthIndex(node.next, k)+1;
			if(index==k)
			{
				System.out.println(node.data+"  "+k);
			}
		
		return index;
		}
	}
	
}
