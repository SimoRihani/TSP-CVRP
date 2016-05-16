package cvrp;
import java.util.*;

public class ClarkeWright implements HeuristicCVRP {
  private double[][] matrix;
  private double[][] savings;
  private int nbCities;
  ArrayList<Round> rounds;
  private int[] d;
  	public double computeSolution(double[][] matrix, int[] d, int c, List<Integer> solution) {
    	double value = 0.0;


    	this.matrix = matrix;
    	this.d = d;
    	this.nbCities = matrix.length-1;
    	savingsInit();
    	roundsInit();
    	int i,a;
    	int controlVar=1;
    	double maxSaving = -1.0;
	    int maxFirst = 0;
	    int maxSecond = 0;


    	while(controlVar==1){
    		maxSaving = -1.0;
	    	maxFirst = 0;
	    	maxSecond = 0;

	    	for(a = 0; a < rounds.size(); a++) {
				Round firstRound = rounds.get(a);

				int c1 = firstRound.getCurrentWeight();
	        	int first1 = firstRound.getCitiesList().getFirst();
				int last1 = firstRound.getCitiesList().getLast();
				int b;


				for(b=a+1; b < rounds.size(); b++) {
		    		Round secondRound = rounds.get(b);
		    		int c2 = secondRound.getCurrentWeight();
		    		int first2 = secondRound.getCitiesList().getFirst();
		    		int last2 = secondRound.getCitiesList().getLast();


		  	  		if(c1+c2 < c) {
						if(maxSaving < savings[last1][first2]) {
			    			maxFirst = a;
			    			maxSecond = b;
			    			maxSaving = savings[last1][first2];
						}
						if(maxSaving < savings[last2][first1]) {
			    			maxFirst = b;
			    			maxSecond = a;
			    			maxSaving = savings[last2][first1];
						}
		    	}
			}
	    }

	     if(maxSaving >= 0.0) {
			Round first = rounds.get(maxFirst);
			Round second = rounds.get(maxSecond);
			first.append(second);
			rounds.set(maxFirst, first);
			rounds.remove(maxSecond);
	    	}
	    	else {
				controlVar=0;
	    		}
	    	maxSaving = -1.0;
		}

  		int b;
		for(i = 0; i < rounds.size(); i++) {
	    	CustomList<Integer> list = rounds.get(i).getCitiesList();
	    	Iterator<Integer> itr = list.iterator();
	    	a = 0;
	    	solution.add(0);
	    	while(itr.hasNext()) {
	        	b = itr.next();
				solution.add(b);
				value = value + matrix[a][b];
			a = b;
	    	}
	    	value = value + matrix[a][0];
		}

		System.out.println("Number of rounds : " + rounds.size());
		solution.add(0);
		return value;
    }

  	private void savingsInit () {
  		int i, j;
  		savings = new double[nbCities+1][nbCities+1];
		for(i = 1; i < nbCities+1; i++) {
		    for(j = 1; j < nbCities+1; j++) {
			savings[i][j] = matrix[i][0] + matrix[0][j] - matrix[i][j];
	    	}
		}

  	}

  	private void roundsInit() {
  		int i;
  		rounds = new ArrayList<Round>();
  		for(i = 1; i < nbCities+1; i++) {
	    	CustomList<Integer> list = new CustomList<Integer>();
	    	list.add(i);
	    	rounds.add(new Round(list, d[i]));
		}

  	}
}
