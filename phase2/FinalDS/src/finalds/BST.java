package finalds;






public  class BST<K extends Comparable<K>,T> {

    class BSTNode <K extends Comparable<K>,T> {
            public K key;  
            public T data;
            public BSTNode<K,T> left, right;


            public BSTNode() {
                    left = right = null;
            }

            public BSTNode(K key, T data) {
                    this.key = key  ;  
                    this.data = data;
                    left = right = null;
            }

            public BSTNode(K key, T data, BSTNode<K,T> l, BSTNode<K,T> r){
                    this.key = key  ;  
                    this.data = data;
                    left = l;
                    right = r;
            }
            
        @Override
        public String toString() {
            return " ["+ "key=" + key + ", data=" + data + "] ";
        }

    }

    BSTNode<K,T> root, current;


    public  BST() {
            root = current = null;
    }

    public boolean empty() {
            return root == null;
    }

    public boolean full() {
            return false;
    }

    public T retrieve () {
            return current.data;
    }

    public boolean findkey(K tkey) {
            BSTNode<K,T>  p = root;
            BSTNode<K,T>  q = root;

            if(empty())
                    return false;

            while(p != null) {
                    q = p;
                    if(p.key.compareTo(tkey) == 0) {
                            current = p;
                            return true;
                    }
                    else if(tkey.compareTo(p.key) < 0)
                            p = p.left;
                    else
                            p = p.right;
            }
            current = q;
            return false;
    }
    public boolean insert(K k, T val) {
            BSTNode<K,T>  p;
            BSTNode<K,T>  q = current;

            if(findkey(k)) {
                    current = q;  
                    return false; 
            }

            p = new BSTNode<K,T> (k, val);
            if (empty()) {
                    root = current = p;
                    return true;
            }
            else {

                    if (k.compareTo(current.key) < 0)
                            current.left = p;
                    else
                            current.right = p;
                    current = p;
                    return true;
            }
    }

    private BSTNode<K,T>  find_min(BSTNode<K,T>  p)
    {
            if(p == null)
                    return null;

            while(p.left != null){
                    p = p.left;
            }

            return p;
    }
    
    public boolean update(K key, T data)
    {
                removeKey(current.key);
                return insert(key, data);
    }

    //Method removeKey:  
    public boolean removeKey(K k) {
    // Search 
    K k1 = k;      
    BSTNode<K,T>  p = root;      
    BSTNode<K,T>  q = null;    
    
    while (p != null) 
    {
        if (k1.compareTo(p.key) <0) 
        {
            q =p;
            p = p.left;
        }
        else if (k1.compareTo(p.key) >0) 
        {
            q = p;
            p = p.right;
        } 
        else { 

            if ((p.left != null) && (p.right != null)) 
            { 

                    BSTNode<K,T>  min = p.right;
                    q = p;
                    while (min.left != null) 
                    {
                        q = min;
                        min = min.left;
                    }
                    p.key = min.key;               
                    p.data = min.data;
                    k1 = min.key;
                    p = min;
                    
            }
             
            if (p.left != null) 
            { 
                
                p = p.left;
            } 
            else 
            { 
                
                p = p.right;
            }
            
            if (q == null) 
            { 
                
                root = p;
            } 
            else 
            {
                if (k1.compareTo(q.key) <0) 
                {
                    q.left = p;
                } 
                else 
                {
                    q.right = p;
                }
            }
            current = root;
            return true;
        }
    }
    return false; 
    }


    @Override
    public String toString() 
    {
        String str = "";
        if ( root == null)
            return str;
        str = recin_order_Traversal ( root , str );
        return str;
    }
    
    private String recin_order_Traversal (BSTNode <K, T> p ,String str)
    {
        if (p == null)
            return "";
        else
        {
            str = recin_order_Traversal(p.left , str);
            str += p.data.toString() + "    ";
            str += recin_order_Traversal(p.right, str);
        }
        return str;
    }


    public boolean SearchPhone(String phone)
    {
        return SearchPhone_rec (root, phone);
    }
    private boolean SearchPhone_rec (BSTNode <K, T> p, String phone)
    {
        if (p == null)
            return false;
        else    if (((Contact)p.data).compareToPhone(phone) == 0)
        {
            current = p;
            
            return true;
        }
        
        return (SearchPhone_rec(p.left , phone) || SearchPhone_rec(p.right, phone));
    }


    public boolean SearchEmail(String email)
    {
       return SearchEmail_rec (root, email);
    }
    private boolean SearchEmail_rec (BSTNode <K, T> p, String email)
    {
        if (p == null)
            return false;
        
        else    if (((Contact)p.data).compareToEmail(email) == 0)
         {
            current = p;
            
            return true;
        }
        
      return  SearchEmail_rec(p.left , email)|| SearchEmail_rec(p.right, email);
    }
    

    public boolean SearchAddress(String address)
    {
       return SearchAddress_rec (root, address);
    
    }
    private boolean SearchAddress_rec (BSTNode <K, T> p, String address)
    {
        if (p == null)
            return false ;
        else    if (((Contact)p.data).compareToAddress(address) == 0)
        {
            current = p;
            
            return true;
        }
        
        return SearchAddress_rec(p.left , address)||SearchAddress_rec(p.right, address);
    }
    

    public boolean SearchBirthday(String birthday)
    {
        return SearchBirthday_rec (root, birthday);
    }
    private boolean SearchBirthday_rec (BSTNode <K, T> p, String birthday)
    {
        if (p == null)
            return false ;
        else    if (((Contact)p.data).compareToBirthday(birthday) == 0)
        {
            current = p;
            
            return true;
        }
        
        return SearchBirthday_rec(p.left , birthday)|| SearchBirthday_rec(p.right, birthday);
    }


    public  void SearchSameFirstName(String name)
            
    {
        
        SearchSameFirstName_rec (root, name);
    }
    private  void SearchSameFirstName_rec (BSTNode <K, T> p, String name)
    {
        if (p == null){

           return ;}
        else    if (((Contact)p.data).compareFirstName(name) == 0)
            System.out.println(p.data);
       
        SearchSameFirstName_rec(p.left , name);
        SearchSameFirstName_rec(p.right, name);
    }


    public boolean SearchSameEvent(Event event)
    {
        return SearchSameEvent_rec (root, event);
    }
    private boolean SearchSameEvent_rec (BSTNode <K, T> p, Event event)
    {
        if (p == null)
            return false;
        else    if (((Event)p.data).compareToSameEvent(event))
        {
            current = p;
            return true;
        }
        return (SearchSameEvent_rec(p.left , event) || SearchSameEvent_rec(p.right, event));
    }
}
