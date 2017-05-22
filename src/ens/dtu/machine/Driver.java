package ens.dtu.machine;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		double[] obs = {2, 4, 8, 11, 15, 19, 20, 27, 30, 31};
		
		
		KMeans km = new KMeans(3, obs);
		
		ArrayList<Cluster> result = km.run();
		 
		for (Cluster c : result) {
			System.out.println(c.clusteredObs + " : " + c.loc);
		}
	}
	
	
}
