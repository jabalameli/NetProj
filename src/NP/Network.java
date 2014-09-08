package NP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Network {
	//Network is a key-value data structure in which key is a vertex and value is a set of neighbors
    private KeyValueMap<String, ValueSet<String>> net;
    //number of edges
    private int E;

    public Network() {
    	//default constructor
    	System.out.println("Making a new Network using stdinput");
        net = new KeyValueMap<String, ValueSet<String>>();
    }

   /**
     * Create the network from an input file given the delimiter.
     */
    
    public Network(In in, String delimiter) {
    	System.out.println("Making a new Network using an input text file");
        net = new KeyValueMap<String, ValueSet<String>>();
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] names = line.split(delimiter);
            //names[0] refers to the node and names[i] refers to the neighbors where i>=1
            for (int i = 1; i < names.length; i++) {
                addEdge(names[0], names[i]);
            }
        }
    }

//number of nodes 
    public int NodesNumber() {
        return net.size();
    }
//number of edges
    public int E() {
        return E;
    }

   /**
     * Degree of this vertex.
     */
    public int degree(String v) {
        if (!net.contains(v)) throw new RuntimeException(v + " is not a vertex");
        else return net.get(v).size();
    }

   /**
     * Add edge v-w to this graph (if it is not already an edge)
     */
    public void addEdge(String v, String w) {
        if (!hasEdge(v, w)) E++;
        if (!hasVertex(v)) addVertex(v);
        if (!hasVertex(w)) addVertex(w);
        net.get(v).add(w);
        net.get(w).add(v);
    }

   /**
     * Add vertex v to this graph (if it is not already a vertex)
     */
    public void addVertex(String v) {
        if (!hasVertex(v)) net.put(v, new ValueSet<String>());
    }


   /**
     * Return the set of vertices as an Iterable.
     */
    public Iterable<String> vertices() {
    	
        return net; // net:hasmap
    }

   /**
     * Return the set of neighbors of vertex v as an Iterable.
     */
    public Iterable<String> adjacentTo(String v) {
        // return empty set if vertex isn't in graph
        if (!hasVertex(v)) return new ValueSet<String>();
        else               return net.get(v);
    }

   /**
     * Is v a vertex in this graph?
     */
    public boolean hasVertex(String v) {
        return net.contains(v);
    }

   /**
     * Is v-w an edge in this graph?
     */
    public boolean hasEdge(String v, String w) {
        if (!hasVertex(v)) return false;
        return net.get(v).contains(w);
    }

   /**
     * Return a string representation of the graph.
     */
    public String toString() {
        String s = "";
        for (String v : net) {
            s += v + ": ";
            for (String w : net.get(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
	
	public static void main(String[] args) throws IOException {
		String outputfile="ComputationResults.txt";
		BufferedWriter out = new BufferedWriter(new FileWriter(outputfile));
		Map<String, String> avmap = new HashMap<String, String>();
		Map<String, String> ndmap = new HashMap<String, String>();
		Map<String, String> avdmap = new HashMap<String, String>();
		Map<String, String> ccmap = new HashMap<String, String>();
		

        In input = new In("input.txt");
		Network GfromInput = new Network(input,",");
		
		AverageDegree Ad=new AverageDegree();
		avmap= Ad.analyze(GfromInput); 
		for (Iterator<String> iterator = avmap.keySet().iterator(); iterator.hasNext();) {
		    String key = (String) iterator.next();
		    System.out.print(key+" "); 
		    System.out.println(avmap.get(key));
		}
		
		NodeDegree ND = new NodeDegree();
		ndmap=ND.analyze(GfromInput);
	
		
		AveDegNode AVD = new AveDegNode();
		avdmap=AVD.analyze(GfromInput);
	
		ClusterringCoef CC  = new ClusterringCoef();
		ccmap=CC.analyze(GfromInput);
		try{
			out.write("Node  "+ "Degree "+"AvDegree "+" CC ");
			out.newLine();
			System.out.println("Node  "+ "Degree "+"AvDegree "+" CC ");
			for (String v : GfromInput.vertices()) {
			out.write(v + ":     ");
            System.out.print(v + ":     ");
            out.write(ndmap.get(v)+"     ");
            System.out.print(ndmap.get(v)+"     ");
            out.write(avdmap.get(v)+"     ");
            System.out.print(avdmap.get(v)+"     ");
            out.write(ccmap.get(v)+"     ");
            System.out.print(ccmap.get(v)+"     ");
            System.out.println();
            out.newLine();
          
            }
			System.out.printf("The output of Computation is in %s", outputfile);}
		catch(IOException e1) {
			System.out.println("Error during reading/writing");
	    } 
		finally {
	        out.close();
	       
	    }

		
	}
	
}


 
/*        
        D.analyze(G, 1);
        GraphAverage Ad=new GraphAverage();
        double AvD= Ad.analyze(G, 1);
        System.out.println(AvD);
        AveDegNode Dnode=new AveDegNode();
        Dnode.analyze(G, 1);
        ClusterringCoef CC=new ClusterringCoef();
        CC.analyze(G, 1);*/
      
        
        // we defined an object so we can use what we have already implemented in another class
        //  G.addVertex("H");

        // print out graph
        //StdOut.println(G);

        // print out graph again by iterating over vertices and edges
 /*       for (String v : G.vertices()) {
            StdOut.print(v + ": ");
            for (String w : G.adjacentTo(v)) {
                StdOut.print(w + " ");
            }
            StdOut.println();
        }
*/
    



