package cvrp;
import java.util.List;

/**
   Interface defining the behavior of a CVRP heuristic

 */

public interface HeuristicCVRP {

	/** apply the heuristic to the CVRP problem given as a matrix
	 *
	 * @param matrix : clients distances
	 * @param d : clients demands
   * @param c : vehicles capacity
	 * @param solution an empty list that will be filled with the solution by the method
	 * @return the value of the solution found
	 */
    double computeSolution(double[][] matrix, int[] d, int c, List<Integer> solution);

}
