package tsp;
import java.util.List;

/**
   Interface defining the behavior of a TSP heuristic

 */

public interface HeuristicTSP{

	/** apply the heuristic to the TSP problem given as a matrix
	 * 
	 * @param matrix : TSP data
	 * @param solution an empty list that will be filled with the solution by the method 
	 * @return the value of the solution found
	 */
    double computeSolution(double[][] matrix, List<Integer> solution);

}