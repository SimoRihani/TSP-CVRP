package cvrp;
import java.util.*;

public class MainCVRP {

	private static char stringtoCode(String s){
		if(s.equals("-h1") || s.equals("--heuristic1")) return 'h';
		if(s.equals("-h2") || s.equals("--heuristic2")) return 'H';
		return '0';
	}


	 /** run the test
 	 *
 	 * Syntax : TestCRVP -{h1,h2} instanceName
 	 *
 	 * h1 : Clarke and Wright
 	 * h2 : Giant tour
 	 *
 	 * */
	public static void main(String args[]) {
		TestCVRP tt = new TestCVRP();
		tt.loadFile(args[1]);

		double res; // result

		if(args.length < 2){
				System.out.println("Argument Error\nSyntax : TestCVRP -{h1,h2} instanceName");
		    return;
		}

		switch(stringtoCode(args[0])){
		case 'h' : // heuristic
		    System.out.print("Heuristic Clarke and Wright : ");
		    res = tt.testHeuristic(new ClarkeWright());
			break;
		case 'H' : // heuristic
		    System.out.print("Heuristic Giant tour : ");
		    res = tt.testHeuristic(new GiantTour());
			break;
		default :  // error
			System.out.println("Argument Error\nSyntax : TestCRVP -{h1,h2} instanceName");
		}
	}
}
