package estructuras;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{

	private Node first;
	private Node last;
	private int n;
	
	private class Node
	{
		Item item;
		Node next;
	}
	
	public boolean isEmpty()
	{
		return first==null;
	}
	
	public int size()
	{
		return n;
	}
	
	public void enqueue(Item item)
	{
		Node oldlast = last;
		last = new Node();
		last.item=item;
		last.next=null;
		
		if(isEmpty())
		{
			first=last;
		}
		else 
		{
			oldlast.next=last;
		}
		n++;
	}

	public Item dequeue()
	{
		Item item= first.item;
		first=first.next;
		if(isEmpty())
		{
			last=null;
		}
		n--;
		return item;
	}
	public Iterator<Item> iterator() 
	{
		return new LisIterator();
	}
	
	private class LisIterator implements Iterator<Item>
	{
		Node current=first;
		public boolean hasNext() {
			return current!=null;
		}

		public Item next() 
		{
			Item item = current.item;
			current=current.next;
			return item;
		}
		
	}
	
		
	
}
