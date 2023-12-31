
package finalds;



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

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }



}


public class LinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> current;
    int size ;

    public LinkedList() {
        head = current = null;
        size = 0 ;

    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean last() {
        return current.next == null;
    }

    public boolean full() {
        return false;
    }

    public void findFirst() {
        current = head;
    }

    public void findNext() {
        current = current.next;
    }

    public T retrieve() {
        return current.data;
    }

    public void update(T val) {
        current.data = val;
    }

    public boolean insertSort(T val) {

 
            Node<T> tmp;
            if (isEmpty()) {
                    current = head = new Node (val);
            }
            else {
                if ( head.data.compareTo(val) >0)
                {
                    tmp = new Node(val);
                    tmp.next=head;
                    head = tmp;
                }
                else
                {
                    Node<T> prev = null;
                    current = head;
                    
                    while (( current != null ) && (current.data.compareTo(val) <= 0))
                    {
                        prev = current;
                        current = current.next;
                    }
                    tmp = new Node (val);
                    if ( current != null)
                    {
                        tmp.next = current;
                        prev.next = tmp;
                        current = tmp;
                    }
                    else
                        current = prev.next =tmp;
                }
            }
            size++;
            return true;

    }

    public boolean search(T val) {

        Node<T> tmp = head;

        if (this.isEmpty() == true) {
            return false;
        }

        while (tmp != null) {
            if (tmp.data.compareTo((T) val) == 0) {
                current = tmp;
                return true; // Value found in the list
            }
            tmp = tmp.next;
        }
        return false; // Value not found in the list

    }

public T remove (T val) {
            
        if (search (val) == false)
         return null;

        T data = current.getData();
        
        if (current == head) {
                head = head.next;
        }
        else {
                Node tmp = head;

                while (tmp.next != current)
                        tmp = tmp.next;
               tmp.next = current.next;
        }
        if (current.next == null)
                current = head;
        else
                current = current.next;
        size -- ;
        return data;    
    }
    public  String  print()  {
        

            
            Node<T>  p = head;
            String str = "" ;
            
            while ( p != null)
            {
                str += p.data.toString();
                str +=  "\n";
                p = p .next;
            }
            return str;
        
    		 
    	 
    	 
    }

    @Override
    public String toString() 
    {
           Node<T>  p = head;
            String str = "" ;
            
            while ( p != null)
            {
                str += p.getData().toString();
                str +=  "\n";
                p = p .next;
            }
            return str;
        }


    

}//End class

    

