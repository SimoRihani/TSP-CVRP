package cvrp;

import java.util.List;
import java.util.ArrayList;
import java.io.File;


/**
 *
 * Utility class to test algorithms for the CVRP.
 * Instances are loaded using methods load*.
 * The different methods can then be run on all these instances.
 *
 */

public class TestCVRP {

    private File file;

    public TestCVRP() {
    }

    /**
     * Load file f into the list of instances.
     * @param f the file to load
     */
    private void loadFile(File f) {
    	if(f.exists() && f.getName().endsWith(".vrp"))
        file = f;
    	else
        System.out.println("File " + f.getName() + " not loaded (does not exist or extension is not .vrp)");
    }

    /**
     * Load the file of name fileName into the list of instances
     * @param fileName the name of the file to load
     */
    public void loadFile(String fileName){
	     loadFile(new File(fileName));
    }

    /**
  	 *
  	 * @return the name of the file loaded
  	 */
  	public String getFileNames(){
  		String fileName = file.getName();
  		return fileName;
  	}

    /**
     * Test the heuristic procedure.
     * The method will be run on each instance previously loaded.
     * The value found for each instance is put in the list in the same order the instances were entered.
     */
    public double testHeuristic(HeuristicCVRP h) {
      double value;

    	List<Integer> soluce = new ArrayList<Integer>();
    	VRPinstance data = null;
    	try {
    	    data = new VRPinstance(file);
    	} catch (java.io.FileNotFoundException e) {
    	    System.out.println("File not found... Strange.");
    	}
      long start = System.currentTimeMillis();
    	value = h.computeSolution(data.getMatrix(), data.getDemands(), data.getCapacity(), soluce);
      long stop = System.currentTimeMillis();
			long duration = stop - start;
			System.out.println("\033[31m TIME : " + duration + "\033[0m");
      System.out.println(value);
    	return value;
    }
}
