package cvrp;

public class Round {
    private CustomList<Integer> citiesList;
    private int currentWeight;

    public Round (CustomList<Integer> list, int c) {
    	this.citiesList = list;
    	this.currentWeight = c;
    }
  	public int getCurrentWeight() {
  		return this.currentWeight;
  	}
  	public CustomList<Integer> getCitiesList(){
  		return citiesList;
  	}
	public void append(Round r) {
		citiesList.append(r.getCitiesList());
		currentWeight += r.getCurrentWeight();
    }

  }
