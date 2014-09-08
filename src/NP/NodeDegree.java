package NP;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class NodeDegree implements NSFinterface{
	
	public NodeDegree(){
		System.out.println("Computing the Degree of each node in the Network");
	}
	
	
	
	public Map<String, String> analyze(Network sampleNetwork) {
		Map<String, String> map = new HashMap<String, String>();
		
		for (String v : sampleNetwork.vertices()) {	
			map.put(v, String.valueOf(sampleNetwork.degree(v)));

			
			
		} 
		
		
		return map;
	
	}


}

