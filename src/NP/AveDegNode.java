package NP;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class AveDegNode implements NSFinterface{
	
	//average degree of node means the average degree of the neighbors of each node
	
	public AveDegNode(){
		System.out.println("Computing the Average Degree of each Node");
		System.out.println();
		
	}

	@Override
	public Map<String, String> analyze(Network sampleNetwork) {
		Map<String, String> map = new HashMap<String, String>();
		
		for (String v : sampleNetwork.vertices()) {	
			double size=0.0;
			double Sum=0.0;
			for (String w : sampleNetwork.adjacentTo(v)) {
				size++;
				Sum+= sampleNetwork.degree(w);
		} 
		double adn=(double)(Sum/size);
		DecimalFormat f = new DecimalFormat("##.00");		
		map.put(v, String.valueOf(f.format(adn)));
		}
		return map;
	}

}
