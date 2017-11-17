package datastructure.stacks;

import java.util.EmptyStackException;

public class Stack<T> {
	private static class StackNode<T>
	{
		private T data;
		private StackNode<T> next;
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public StackNode<T> getNext() {
			return next;
		}
		public void setNext(StackNode<T> next) {
			this.next = next;
		}
		public StackNode(T data) {
			super();
			this.data = data;
		}
			
	}
	private StackNode<T> top;
	public T pop()
	{
		if (top == null)
			throw new EmptyStackException();
		T item=top.data;
		top=top.next;
		return item;
	}
	
	public void push(T item)
	{
		StackNode<T> t= new StackNode<T>(item);
		t.next=top;
		top=t;
	}
	public T peek()
	{
		if(top==null)
			throw new EmptyStackException();
		return top.data;
	}
	public boolean isEmpty()
	{
		return top==null;
	}

}
