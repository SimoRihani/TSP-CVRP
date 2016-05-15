package tsp;
import java.util.List;
import java.util.*;

/**
 * This heuristic sorts the arcs by increasing value and
 * considers each arc in turn for insertion
 * An arc is inserted if and only if it does not create a subtour.
 * The method stops when a tour is obtained.
 */

public class DecreasingArcHeuristicTSP implements HeuristicTSP {

	private double[][] matrix;

	public double computeSolution(double[][] matrix, List<Integer> solution) {

		this.matrix = matrix;
		int nbNodes = matrix.length;
		int nbArcs = nbNodes*(nbNodes-1);
		Arc arcs[] = getArcs();
		int[] path = new int[nbNodes];
		int i, j, k=0;

		for(i = 0; i < nbNodes; i++)
	    	path[i] = -1;


		for(i = 0; i < nbArcs && k < nbNodes; i++){
	    	if(isValidArc(path, arcs[i])){
				path[arcs[i].getSource()] = arcs[i].getTarget();
				k++;
			}
		}

		solution.add(0);
		int target = path[0];
		while(target != 0){
	    	solution.add(target);
	    	target = path[target];
		}
		print(path);
		return pathValue(path);
    }



    double pathValue(int[] path) {
    	double value=0.0;
    	int l=path.length;
    	for(int i=0;i<l;i++){
    		value+=matrix[i][path[i]];
    	}
    	return value;
    }

    private Arc [] arcsInit (int n) {
		//System.out.println(n);
		int nbArcs = n*(n-1);
		//System.out.println(nbArcs);
		Arc arcs[] = new Arc[nbArcs];
		int cmp=0;
		int i,j;
		for(i = 0; i < n; i++)
		{
	    	for(j = 0; j < n; j++)
	    	{
				if (i!=j){
					//System.out.println("i : " + i + " j : " + j + " cmp : " + cmp);
					arcs[cmp] = new Arc(i, j);
					//System.out.println(arcs[cmp].source);
					cmp ++;
					//arcs[cmp].toString();
				}
				// arcs[cmp].toString();
				// arcs[cmp] = new Arc(j, i);
				// arcs[cmp].toString();
				// cmp ++;
	    	}
		}
	return arcs;
	}



	private double arcWeight (Arc a) {
		int s = a.getSource();
		int t = a.getTarget();
		return matrix[s][t];
	}
	private Arc [] getArcs () {
		// init the arcs
		Arc arcs[] = arcsInit(matrix.length);
		// sort the arcs

		int nbArcs = arcs.length;
		int i,j;
		double currentValue = arcWeight(arcs[0]);
		Arc tmp;
		int swapIndex=0;
		for(i=0;i<nbArcs-1;i++)
			{
			swapIndex = lowestWeightIndex(arcs, i);
			arcs = swapArcs(arcs, i, swapIndex);
		}


		return arcs;
	}
	private Arc[] swapArcs (Arc[] arcs, int i, int swapIndex){
		Arc tmp = arcs[i];
		arcs[i] = arcs[swapIndex];
		arcs[swapIndex] = tmp;
		return arcs;
	}
	private int lowestWeightIndex(Arc[] arcs, int pos) {
		int i;
		int l=arcs.length;

		double currentValue = arcWeight(arcs[pos]);


		int index = pos;
		for (i=pos+1;i<l;i++){
			if (arcWeight(arcs[i])<currentValue){
				index = i;
				currentValue = arcWeight(arcs[i]);
			}

		}
		return index;
	}

	private boolean isValidArc(int[] path, Arc arc){
		int source = arc.getSource();
		int target = arc.getTarget();
		if(path[source] != -1)
	    	return false;
		int i;
		for(i = 0; i < path.length; i++)
	   	 if(path[i] == target)
				return false;
		i = 1;
		while(path[target] != -1 && i < path.length - 1) {
	   		 target = path[target];
	    	if(target == source)
				return false;
	    	i++;
		}
		return true;
	}

	void print(int[] t) {
		int l=t.length;
		int i=0;
		String s;
		String path = "(";
		for(i=0;i<l;i++){
			s=" "+t[i];
			path+=s;
		}
		path+=")";
		System.out.println(path);
	}
}
