package ens.dtu.machine;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		
		if (args.length < 2) {
			System.out.println("Put in some arguments, yo!");
			System.exit(1);
		}
		
		double[] arg1Arr = parseArg(args[0]);
		double[] arg2Arr = parseArg(args[1]);
		
		
		KMeans km;
		
		if (arg1Arr.length == 1) {
			 km = new KMeans(arg1Arr[0], arg2Arr);			
		} else {
			km = new KMeans(arg1Arr, arg2Arr);	
		}
				
		ArrayList<Cluster> result = km.run();
		 
		for (Cluster c : result) {
			System.out.println(c.clusteredObs + " : " + c.loc);
		}
		
	}	

	private static double[] parseArg(String arg) {
		String[] argArr = arg.split(" ");
		
		double[] ret = new double[argArr.length];
		
		for (int i = 0; i < argArr.length; i++) {
			ret[i] = Double.parseDouble(argArr[i]);
		}
		
		return ret;
	}
}
