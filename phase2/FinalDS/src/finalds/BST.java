public class BSTNode <K extends compareable<K>, T> {
public K key;
public T data;
public BSTNode<K, T> left, right;
public BSTNode() {
left = right = null;
}
public BSTNode(K key , T data) {
this.key = key;
this.data= data;
left = right = null;
}

public BSTNode(K key, T data, BSTNode<K,T> l, BSTNode<K,T> r) {
this.key = key;
this.data= data;
left = l;
right = r;
}
@Override
        public String toString() {
            return " ["+ "key=" + key + ", data=" + data + "] ";
        }
}

public class BST <T> {
BSTNode<K, T> root, current;
/** Creates a new instance of BST */
public BST() {
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
BSTNode<T> p = root , q = root;
if(empty())
return false;
while(p != null) {
q = p;
if(p.key.compareTo(tkey)=0) {
current = p;
return true;
}
else if(tkey.compareTo(p.key)<0)
p = p.left;
else
p = p.right;
}
current = q;
return false;
}


public boolean insert(K k, T val) {
BSTNode<K,T> p, q = current;
if(findkey(k)) {
current = q; // findkey() modified current
return false; // key already in the BST
}
p = new BSTNode<K, T>(k, val);
if (empty()) {
root = current = p;
return true;
}
else {
// current is pointing to parent of the new key
if (k.compareTo(current.key)<0)
current.left = p;
else
current.right = p;
current = p;
return true;
}
}


public boolean remove_key (K tkey){
Boolean removed = new Boolean(false);
BSTNode<T> p;
p = remove_aux(tkey, root, removed);
current = root = p;
return removed;
}

public boolean removeKey(K k) {
int k1 = k;
BSTNode<K,T> p = root;
BSTNode<K,T> q = null; // Parent of p
while (p != null) {
if (k1.compareTo(p.key)<0) {
q = p;
p = p.left;
} else if (k1.compareTo(p.key)>0) {
q = p;
p = p.right;
} else { 
if ((p.left != null) && (p.right != null)) { 
BSTNode<K,T> min = p.right;
q = p;
while (min.left != null) {
q = min;
min = min.left;
}
p.key = min.key;
p.data = min.data;
k1 = min.key;
p = min;
}
if (p.left != null) 
p = p.left;
else 
p = p.right;
if (q == null)
root = p;
else 
if (k1.compareTo(q.key)<0)
q.left = p;
else
q.right = p;
current = root;
return true;
} 
}
return false; // Not found
}


private BSTNode<K,T> find_min(BSTNode<T> p){
if(p == null)
return null;
while(p.left != null){
p = p.left;
}
return p;
}
public boolean update(K key, T data){
remove_key(current.key);
return insert(key, data);
}
}
