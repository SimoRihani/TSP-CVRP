package tsp;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * This heuristic iteratively appends a customer
 * to the currentent solution until a already is obtained
 *
 */

public class InsertHeuristicTSP implements HeuristicTSP {

	public double computeSolution(double[][] matrix, List<Integer> solution) {
		int n = matrix.length, i = 0, previous = 0, current = 0, index = 0, node = 0, alreadyIndex = 0;
		double res = 0.0;
		ArrayList<Integer> notYet = new ArrayList<Integer>(n);//not inserted yet
		ArrayList<Integer> already = new ArrayList<Integer>(n);//already inserted
		Iterator alreadyItr;
		//init
		already.add(0);
		for(i = 1; i < n; i++)
		  notYet.add(i);

		//Add the farthest node to the solution
		for(i = 1; i < n; i++) {
		  index = farthest(matrix, notYet, already);
		  node = notYet.get(index).intValue();
		  alreadyIndex = insert(matrix, already, node);
		  already.add(alreadyIndex, node);
		  notYet.remove(index);
		}

		alreadyItr = already.iterator();
		previous = already.get(already.size() - 1).intValue();
		while(alreadyItr.hasNext()) {
		  current = ((Integer)alreadyItr.next()).intValue();
		  solution.add(current);
		  res += matrix[previous][current];
		  previous = current;
		}
		//form the cycle
		solution.add(solution.get(0));
		System.out.println("Solution : " + solution);
		return res;
	}

  private int farthest(double[][] matrix, ArrayList<Integer> notYet, ArrayList<Integer> already){
		double max = -1., min = -1., tmp = 0.;
		int maxNotYet = -1, notYetIndex = -1;
		int currentNotYet, currentAlready;
		Iterator notYetItr = notYet.iterator(), alreadyItr;

		while(notYetItr.hasNext()) {
		    notYetIndex++;
		    currentNotYet = ((Integer)notYetItr.next()).intValue();
		    alreadyItr = already.iterator();
		    while(alreadyItr.hasNext()) {
					currentAlready = ((Integer)alreadyItr.next()).intValue();
					tmp = matrix[currentAlready][currentNotYet] + matrix[currentNotYet][currentAlready];
					if(tmp < min || min == -1)
					  min = tmp;
		    }
		    if(max < min) {
					max = min;
					maxNotYet = notYetIndex;
		    }
			}
		return maxNotYet;
	}

  private int insert(double[][] matrix, ArrayList<Integer> already, int node) {
		Iterator alreadyItr = already.iterator();
		int index = -1, alreadyIndex = -1, current = 0;
		double min = -1., tmp = 0.;
		int previous = already.get(already.size() - 1).intValue();

		while(alreadyItr.hasNext()) {
		    alreadyIndex++;
		    current = ((Integer)alreadyItr.next()).intValue();
		    if(previous == current)
					tmp = matrix[current][node] + matrix[node][current];
		    else
					tmp = matrix[previous][node] + matrix[node][current] - matrix[previous][current];
		    if(tmp < min || min == -1) {
					min = tmp;
					index = alreadyIndex;
				}
		    previous = current;
		}
		return index;
	}
}
