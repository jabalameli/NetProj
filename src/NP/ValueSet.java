package NP;


import java.util.Iterator;
import java.util.TreeSet;

public class ValueSet<Key extends Comparable<Key>> implements Iterable<Key> {
	//container to store the neighbors of the nodes in the network
    private TreeSet<Key> valset;
    
    public ValueSet() {
        valset = new TreeSet<Key>();
    }

    public void add(Key key) {
        if (key == null) throw new NullPointerException("Null key, Cannot add it");
        valset.add(key);
    }
 
    public boolean contains(Key key) {
    	//contains a neighbor
        if (key == null) throw new NullPointerException("Null key, called contains() with a null key");
        return valset.contains(key);
    }

  
    public void delete(Key key) {
    	//remove a neighbor
        if (key == null) throw new NullPointerException("called delete() with a null key");
        if (!valset.contains(key)) throw new NullPointerException("No such key in the network");
        valset.remove(key);
    }

    public int size() {
    	//number of neighbors
        return valset.size();
    }

  
    public boolean isEmpty() {
        return size() == 0;
    }
 
   
    public Iterator<Key> iterator() {
        return valset.iterator();
    }


   
    public ValueSet<Key> union(ValueSet<Key> that) {
        if (that == null) throw new NullPointerException("called union() with a null argument");
        ValueSet<Key> c = new ValueSet<Key>();
        for (Key x : this) { c.add(x); }
        for (Key x : that) { c.add(x); }
        return c;
    }

    
    public ValueSet<Key> intersects(ValueSet<Key> that) {
        if (that == null) throw new NullPointerException("called intersects() with a null argument");
        ValueSet<Key> c = new ValueSet<Key>();
        if (this.size() < that.size()) {
            for (Key x : this) {
                if (that.contains(x)) c.add(x);
            }
        }
        else {
            for (Key x : that) {
                if (this.contains(x)) c.add(x);
            }
        }
        return c;
    }

 
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        ValueSet<Key> that = (ValueSet<Key>) y;
        if (this.size() != that.size()) return false;
        try {
            for (Key k : this)
                if (!that.contains(k)) return false;
        }
        catch (ClassCastException exception) {
            return false;
        }
        return true;
    }

 
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Key key : this)
            s.append(key + " ");
        return s.toString();
    }


     
    public static void main(String[] args) {
    	ValueSet<String> set = new ValueSet<String>();

        // insert some keys
        set.add("1");
        set.add("1");    // overwrite old value
        set.add("2");
        set.add("4");
        set.add("V");
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println();
  
        System.out.println(set.contains("1"));
        System.out.println(!set.contains("V"));
        System.out.println(set.contains("Z"));
        System.out.println();
        System.out.print("size is: ");
        System.out.println(set.size());
        System.out.println("delete a node");
        set.delete("1");
        System.out.print("size is: ");
        System.out.println(set.size());
        
        for (String s : set) {
            System.out.println(s);
        }
        
        set.delete("Z");
       
        // print out all keys in the set in lexicographic order
        for (String s : set) {
            System.out.println(s);
        }
        
        set.delete("1");
        
        
    }

}

