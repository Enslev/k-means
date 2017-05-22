package ens.dtu.machine;

import java.util.ArrayList;

public class Cluster {
	double loc;
	ArrayList<Double> clusteredObs;
	ArrayList<Double> staged;
	
	public Cluster(double location) {
		this.loc = location;
		this.clusteredObs = new ArrayList<Double>();
		this.staged = new ArrayList<Double>();
	}
	
	public double dist(double obs) {
		return Math.abs(this.loc - obs);
	}

	public void stageObs(double obs) {
		staged.add(obs);		
	}

	public boolean addStaged() {
		boolean bool = false;
		
		for (Double obs : staged) {
			if (!this.clusteredObs.contains(obs)) {
				bool = true;
			}
		}
		clusteredObs.clear();
		clusteredObs.addAll(staged);
		staged.clear();
		return bool;
	}

	public void updateLoc() {
		double sum = 0;
		
		for (double obs : clusteredObs) {
			sum += obs;
		}
		this.loc = sum/clusteredObs.size();		
	}

}
