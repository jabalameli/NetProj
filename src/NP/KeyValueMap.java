package NP;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.TreeMap;


public class KeyValueMap<Key extends Comparable<Key>, Value> implements Iterable<Key> {
	//KeyValueMap is a TreeMap, based on compareTo() implementation, O(log(N)) runtime complexity for inserting and searching, sorted

    private TreeMap<Key, Value> net;

    public KeyValueMap() {
    	//default constructor
    	
        net = new TreeMap<Key, Value>();
    }

    
    public Value get(Key key) {
    	// return the neighbors if a node

        if (key == null) throw new NullPointerException("The key is Null. No Value!");
        return net.get(key);
    }


    public void put(Key key, Value val) {
    	//add a node to the network
        if (key == null) throw new NullPointerException("Null Key. Can't put a null key into the network");
        if (val == null) net.remove(key);
        else             net.put(key, val);

    }
    
    public int size() {
    	//number of nodes in the network
        return net.size();
    }


    public void delete(Key key) {
    	//remove a node from the network

        if (key == null) throw new NullPointerException("Null Key. Can't remove a null key into the network");
        net.remove(key);
    }

    public boolean contains(Key key) {
    	//checks if the network contains a node

        if (key == null) throw new NullPointerException("Null Key!!");
        return net.containsKey(key);

    }

    public boolean isEmpty() {

        return size() == 0;

    }


    public Iterable<Key> keys() {
    	//returns a set of nodes in a network
        return net.keySet();
    }


    public Iterator<Key> iterator() {

        return net.keySet().iterator();

    }
 
    
   //This main is to test KeyValueMap data structure

    public static void main(String[] args) {

    	KeyValueMap<String, String> net = new KeyValueMap<String, String>();

        net.put("1", "2");
        net.put("1", "3");    // overwrite old value
        net.put("3", "2");
        net.put("2", "V");
        net.put("3", "V");
        net.put("3", "4");
        net.put("4", "5");
        net.put("5", "V");
        net.put("V", "7");
        net.put("5", "6");
        net.put("6", "7");
        
        System.out.println(net.get("6"));
        System.out.println(net.get("3"));
        System.out.println(net.get("V"));
        System.out.println();
        System.out.println("size of the network is:    " + net.size());
        System.out.println();
        System.out.println(net.contains("V"));
        System.out.println(net.isEmpty());
        
        for (String s : net.keys())
        	System.out.println(s + " " + net.get(s)); 
        
        
        net.delete("1");
        System.out.println("size of the network is:    " + net.size());
                
    }
}
