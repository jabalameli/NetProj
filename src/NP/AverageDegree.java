package NP;

import java.util.HashMap;
import java.util.Map;

public class AverageDegree implements NSFinterface {
	
	public AverageDegree (){
		System.out.println ("Computing the Average Degree of the Network");
	}

	public Map<String, String>  analyze(Network sampleNetwork) {
		Map<String, String> map = new HashMap<String, String>();
		
		int nodeNumber= sampleNetwork.NodesNumber();
		int edgeNumber= sampleNetwork.E();
		double averagedegree=(2.0*edgeNumber)/nodeNumber;
		map.put("Average Degree of ThisNetwork", String.valueOf(averagedegree));
		return map;
	}

}



