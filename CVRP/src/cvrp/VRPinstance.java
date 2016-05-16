package cvrp;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


/**
 * VRPinstance
 */

public class VRPinstance {


	/* distance matrix */
	private double matrix[][] = null;

	/* demand table */
	private int demands[] = null;

	/* Capacity of a vehicle */
	private int capacity = -1;

	// private String name=null;
	private int size;

	public VRPinstance(FileReader f) {
		Scanner scan = new Scanner(f);
		scan.nextLine(); // name
		scan.nextLine(); // comment
		scan.nextLine(); // type
		scan.next(); // dimension
		size = scan.nextInt();
		scan.nextLine(); // passage a la ligne
		scan.nextLine(); // edge type
		scan.next(); // capacity:
		capacity = scan.nextInt();
		scan.nextLine(); // node coord section

		matrix = new double[size][];
		for (int i = 0; i < size; i++) {
			matrix[i] = new double[size];
		}

		double x[] = new double[size];
		double y[] = new double[size];

		scan.next();

		for (int i = 0; i < size; i++) {
			scan.nextInt();
			x[i] = scan.nextInt();
			y[i] = scan.nextInt();
		}

		scan.nextLine(); // demand section
		scan.nextLine(); // demand section

		demands = new int[size];
		for (int i = 0; i < size; i++) {
			scan.nextInt(); // line number
			demands[i] = scan.nextInt();
		}

		scan.close();

		// for(int i=0;i<size;i++){
		// System.out.print(x[i] + " " );
		// System.out.println(y[i] + " " );
		// }

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) {
					matrix[i][j] = Double.MAX_VALUE;
				} else {
					matrix[i][j] = Math.sqrt((x[i] - x[j]) * (x[i] - x[j])
							+ (y[i] - y[j]) * (y[i] - y[j]));
					matrix[i][j] = Math.round(matrix[i][j]);
				}
			}
		}

	}

	public VRPinstance(File f) throws java.io.FileNotFoundException {
		this(new FileReader(f));
	}

	public VRPinstance(String filename) throws java.io.FileNotFoundException {
		this(new FileReader(filename));
	}




	/**
	 * Creates a VRP instance "by hand"
	 * Data are supposed to be consistent (size, etc.).
	 * @param matrix The distance matrix (size * size)
	 * @param demands The demand for each customer.
	 * @param capacity The capacity of the vehicles.
	 * @param size The size of the instance (number of customers)
	 */
	public VRPinstance(double[][] matrix, int[] demands, int capacity, int size) {
		super();
		this.matrix = matrix;
		this.demands = demands;
		this.capacity = capacity;
		this.size = size;
	}

	/**
	 * returns the matrix read
	 *
	 * @return the matrix
	 */
	public double[][] getMatrix() {
		return matrix;
	}

	/**
	 * returns the number $n$ of customers (including the depot)
	 *
	 * @return N
	 */
	public int getN() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}

	public int[] getDemands() {
		return demands;
	}

	public int getDemand(int customer) {
		return demands[customer];
	}


//	public static void main(String args[]) {
//
//		VRPinstance instance = null;
//		try {
//			instance = new VRPinstance("Augerat/A-n32-k5.vrp");
//		} catch (java.io.FileNotFoundException e) {
//			System.out.println("File not found");
//		}
//
//		System.out.println("Matrice de distances");
//		double[][] matrix = instance.getMatrix();
//		for (int i = 0; i < instance.getN(); i++) {
//			System.out.print(matrix[i][0] + " ");
//		}
//		System.out.println();
//
//		int[] demands = instance.getDemands();
//		System.out.println("Demandes");
//		for(int d : demands) System.out.print(d + " ");
//		System.out.println();
//
//		System.out.println("Capacite : " + instance.getCapacity());
//
//	}

}
