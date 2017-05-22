package ens.dtu.machine;

import java.util.ArrayList;

public class KMeans {
	public ArrayList<Cluster> cs;
	public ArrayList<Double> obsList;

	public KMeans(int n, double[] obs) {
		this.cs = new ArrayList<Cluster>();
		this.obsList = new ArrayList<Double>();

		for (int i = 0; i < n; i++) {
			cs.add(new Cluster(obs[i]));
		}

		for (int i = 0; i < obs.length; i++) {
			this.obsList.add(obs[i]);
		}
	}

	public KMeans(double[] cLoc, double[] obs) {
		this.cs = new ArrayList<Cluster>();
		this.obsList = new ArrayList<Double>();

		for (int i = 0; i < cLoc.length; i++) {
			cs.add(new Cluster(cLoc[i]));
		}

		for (int i = 0; i < obs.length; i++) {
			this.obsList.add(obs[i]);
		}
	}

	public ArrayList<Cluster> run() {
		boolean repeat = false;
		do {
			Cluster optimalC = null;
			for (double obs : obsList) {
				double minLength = Double.POSITIVE_INFINITY;
				for (Cluster c : cs) {
					double dist = c.dist(obs);
					if (dist < minLength) {
						minLength = dist;
						optimalC = c;
					}
				}
				optimalC.stageObs(obs);
			}

			repeat = false;
			for (Cluster c : cs) {
				repeat = c.addStaged() || repeat;
				c.updateLoc();
			}
		} while (repeat);

		return cs;
	}
}
