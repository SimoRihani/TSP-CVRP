package tsp;

class Arc {
	private int source;
	private int target;

	public Arc(int source, int target) {
		this.source = source;
		this.target = target;
	}

	public int getSource() {
		return source;
	}

	public int getTarget() {
		return target;
	}

	public String toString() {
		return "(" + source + "," + target + ")";
	}

}