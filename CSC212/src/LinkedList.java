import java.util.ArrayList;

class Node<T>{
	public T data; 
	public Node<T>next ;
	
	public Node() {
		data = null;
		next = null;
	}
	
	public Node(T val) {
		data = val;
		next = null;
	}


}
public class LinkedList<T> implements Comparable<String> {
 private Node<T> head;
 private Node<T> current;
 
public LinkedList() {
	head=current = null;

}

public boolean isEmpty() {
	return head==null;
}

public boolean last() {
	return current.next==null;
}
		
public boolean full() {
	return false;
}	

public void findFirst() {
	current= head;
}

public void findNext() {
	current= current.next;
}

public T retrieve () {
	return current.data ; 
}

public void update(T val) {
	current.data = val;
}


public void insert(T val) {
Node<T> tmp;

if(isEmpty()) {
	head=current= new Node<T>(val);
}
else {
	tmp=current.next;
	current.next = new Node<T>(val);
	current = current.next;
	current.next=tmp; 
}
}//insert

public void delete() {
	if (head==current) {
		head = head.next; 
	}
	else {
		Node <T> tmp = head ; 
		
		while (tmp.next != current)
			tmp=tmp.next;
		
		tmp.next=current.next ;
		
	}
	if (current.next==null)
		current = head; 
	else
		current = current.next; 
}//remove


public static <T> boolean search(ArrayList<T> l, T key) {
	if (l.isEmpty()==false) {
		l.findFirst();
		
	while (l.last()== false) {
		if (l.retrieve().equals(key))
			return true;
		else
			l.findNext() ; 
		
	}//while
	if (l.retrieve().equals(key))
	return true;
	
	}
	return false;
}//search


public void Adding (T Val) {
	Node<T> p = new Node<T>(Val);
	
	if (head==null) {
		head=current=p;
		return;
	}
	else {
		//smaller than the head
		if(((Contact)Val).compareTo((Contact)head.data)<0) {
			p.next=head;
			head=p; 
			return;
		}//if
		else {
		Node<T> A =head, q=null; 
		
		while (A!=null&& (((Contact)A.data).compareTo((Contact)Val)<=0))
		{
			q=A;
			A=A.next;
		
		}//while
		//inserting middle or last
		
		q.next=p;
		p.next=A;
		}//else
			
	}//outer else

}//adding

}//end class
