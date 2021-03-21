package com.codingchallenge.workload;

import java.util.Arrays;

/**
 * Workload is the base class for processing arrays and returning appropriate
 * String if the array is arranged in wave pattern or if it is not.
 * 
 * <p>
 * Workload class contains a {@link #SearchWaves(int[])}SearchWave(int[] arr)
 * method which accepts array of numbers as parameter and returns String value.
 *
 * @author Kenan Spahiæ
 * @version 1.0
 * @since 2019-08-30
 */
public class Workload {

	private String falseText = "false, no wave with ";
	private String trueText = "true, wave was ";

	/**
	 * This method accepts array of numbers as parameter and performs a task of
	 * finding if array is arranged in wave pattern or not. Depending on different
	 * outcome, the method returns a different String value.
	 * 
	 * @param arr
	 * @return
	 */
	public String SearchWaves(int[] arr) {

		int growth = 0;
		int decrease = 0;
		// Logic for finding how many wave patterns are in array.
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] >= 0 && arr[i + 1] >= 0) {
				if (arr[i] > arr[i + 1]) {
					decrease++;
				} else if (arr[i] < arr[i + 1]) {
					growth++;
				} else {
					return falseText + Arrays.toString(arr);
				}
			} else {
				throw new IllegalArgumentException("Parameter «arr» should contain only positive numbers.");
			}
		}

		// Returning different value depending on a different outcome.
		if (decrease >= 2 && growth >= 2) {
			return trueText + Arrays.toString(arr);
		} else {
			return falseText + Arrays.toString(arr);
		}
	}

}
