package NP;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ClusterringCoef implements NSFinterface{
	
	public ClusterringCoef(){
		System.out.println("Computing the Clustering Coefficient of thE Network");
	}

	@Override
	public  Map<String, String> analyze(Network sampleNetwork) {
		Map<String, String> map = new HashMap<String, String>();
	
		for (String v : sampleNetwork.vertices()) {	
			double counter=0.0;
			int degreeofNode= sampleNetwork.degree(v);
			for (String w1 : sampleNetwork.adjacentTo(v)) {
				for (String w2:sampleNetwork.adjacentTo(v)){
					if (sampleNetwork.hasEdge(w1, w2)) {
						counter++;
					}
				}
			
				
			}
			double triangle = counter/2;
			double maxTriangle = degreeofNode*(degreeofNode-1)/2;
			double cc = triangle/maxTriangle;
			DecimalFormat f = new DecimalFormat("##.00");
			map.put(v, String.valueOf(f.format(cc)));}
	
		return map;
	}

}
