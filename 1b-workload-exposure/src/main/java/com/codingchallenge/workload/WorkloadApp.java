package com.codingchallenge.workload;

/**
 * WorkloadApp contains main method and represents the entry point of this
 * program.
 * <p>
 * The WorkloadApp implements the main method and through her parameters and
 * Workload object, application executes the task of finding if the array passed
 * as a main method argument, is arranged in a wave pattern.
 * 
 * @author Kenan Spahiæ
 * @version 1.0
 * @since 2019-08-30
 */
public class WorkloadApp {

	static int EXIT_STATUS_PARAMETER_IS_NOT_A_NUMBER = 2;
	static int EXIT_STATUS_PARAMETER_IS_NEGATIVE_NUMBER = 3;

	/**
	 * This is the main method which makes use of Workload object and his method
	 * SearchWaves(int[]), to execute the process of finding if the array is
	 * arranged in wave pattern.
	 * 
	 * @param args Represents an parameter in form of an array that you want to be
	 *             processed. It can only contain numbers or it will throw an
	 *             exception. You can pass it to a method through command line.
	 *             Example: <b>mvn exec:java
	 *             -Dexec.mainClass=com.codingchallenge.algorithm.AlgorithmApp
	 *             -Dexec.args="0 3 9 5 7 10 1 4 8"</b>
	 */
	public static void main(String[] args) {

		/*
		 * This part of code is taking the args parameter and converting it to int type
		 * and than making a new array that contains only numbers. If the arguments
		 * contain something that is not a number, the program will throw an exception
		 * and appropriate message.
		 */
		int[] arr = new int[args.length];
		int i = 0;
		for (String str : args) {
			try {
				arr[i] = Integer.parseInt(str);
				i++;
			} catch (NumberFormatException e) {
				System.err.println("The parameter that you have passed is not a number! " + "Parameter was: [" + str
						+ " at index " + i + "]");
				System.exit(EXIT_STATUS_PARAMETER_IS_NOT_A_NUMBER);
			}
		}

		/*
		 * Making Workload object and printing the appropriate message based on the
		 * array that is passed to SearchWaves method.
		 */
		Workload workload = new Workload();
		try {
			System.out.println(workload.SearchWaves(arr));
		} catch (IllegalArgumentException e) {
			System.err.println("Execution failed: " + e.getMessage());
			System.exit(EXIT_STATUS_PARAMETER_IS_NEGATIVE_NUMBER);
		}

	}

}
