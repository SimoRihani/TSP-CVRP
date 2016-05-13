package tsp;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * This heuristic iteratively appends a customer
 * to the current solution until a tour is obtained
 *
 */

public class InsertHeuristicTSP implements HeuristicTSP {

	public double computeSolution(double[][] matrix, List<Integer> solution) {
		double value = 1.1;
		int nodeIndex = 1;
		int nodes = matrix.length;
		ArrayList<Integer> tour = new ArrayList<Integer>(nodes);//List of the inserted nodes
		tour.add(0);
		//Looking for the farthest node (adding it to the solution)
		for(int i = 1; i < nodes; i++)
		    nodeIndex = this.farthest(matrix, tour, nodes);
		return (double) nodeIndex;
}

	private int farthest(double[][] matrix, ArrayList<Integer> tour, int nodes) {
		int current = 0;
		double max = -1.;
		int maxNode = -1, nodeIndex = -1;
		int currNode, currTour;
		while(current < nodes) {
				nodeIndex++;
				currNode = current;
				Iterator tourItr = tour.iterator();
				double tmpMin = -1.;
				while(tourItr.hasNext()) {
					currTour = ((Integer)tourItr.next()).intValue();
					double tmp = matrix[currTour][currNode] + matrix[currNode][currTour];
					if(tmp < tmpMin || tmpMin == -1) {
							tmpMin = tmp;
					}
				}
				if(max < tmpMin) {
					max = tmpMin;
					maxNode = nodeIndex;
				}
				current++;
		}
		return maxNode;
	}

}
