package tsp;

import java.io.*;
import java.util.Scanner;

/**
 * TPPData : utilities to load TSPData into a matrix from a TSP instance in the
 * format TSPLIB with euclidian distances
 * 
 * Data are stored as doubles. Infinite distances are stored as Double.MAX_VALUE
 */
public class TSPData {

	private double matrix[][] = null;
	// private String name=null;
	private int size;

	public TSPData(FileReader f) {
		Scanner scan = new Scanner(f);
		scan.nextLine(); // name
		scan.nextLine(); // comment
		scan.nextLine(); // type
		scan.next(); // dimension
		size = scan.nextInt();
		scan.nextLine(); // passage a la ligne
		scan.nextLine(); // edge type
		scan.nextLine(); // node coord section

		matrix = new double[size][];
		for (int i = 0; i < size; i++) {
			matrix[i] = new double[size];
		}

		double x[] = new double[size];
		double y[] = new double[size];

		for (int i = 0; i < size; i++) {
			scan.nextInt();
			x[i] = scan.nextInt();
			y[i] = scan.nextInt();
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
					matrix[i][j] = Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
				}
			}
		}

	}

	public TSPData(File f) throws java.io.FileNotFoundException {
		this(new FileReader(f));
	}

	public TSPData(String filename) throws java.io.FileNotFoundException {
		this(new FileReader(filename));
	}
	
	
	
	
	public TSPData(double[][] matrix, int size) {
		this.matrix = matrix;
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
	 * returns the number $n$ of customers
	 * 
	 * @return N
	 */
	public int getN() {
		return size;
	}

//	public static void main(String args[]) {
//
//		TSPData tspd = null;
//		try {
//			tspd = new TSPData("../data/instances/a280.tsp");
//		} catch (java.io.FileNotFoundException e) {
//			System.out.println("File not found");
//		}
//
//		double[][] matrix = tspd.getMatrix();
//		for (int i = 0; i < tspd.getN(); i++) {
//			System.out.print(matrix[i][0] + " ");
//		}
//
//	}

}