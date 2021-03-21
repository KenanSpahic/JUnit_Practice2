package com.codingchallenge.workload;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * WorkloadTest is a test for Workload class.
 * <p>
 * In WorkloadTest class we use JUnit 5 to test methods from Workload class
 * and some possible scenarios based on array that is passed to a method.
 * 
 * @author Kenan Spahiæ
 * @version 1.0
 * @since 2019-08-30
 */
@DisplayName("Testing Workload class")
public class WorkloadTest {

	Workload workload;

	@BeforeEach
	void init() {
		workload = new Workload();
	}

	/**
	 * A SearchWavesTest is a nested class used for testing different possible scenarios with SearchWaves method.
	 * Nested class is used because of the easier manipulation and for better transparency of all test methods.
	 * 
	 */
	@Nested
	@DisplayName("SearchWaves method test")
	class SearchWavesTest {

		String expectedTrue 	= "true, wave was ";
		String expectedFalse 	= "false, no wave with ";

		@Test
		@DisplayName("with correct waveform arrays")
		void testSearchWavesOnWaveform() {
			
			// Examples of arrays.
			int[] arr1 	= {0, 8, 15, 7, 13, 4, 1};
			int[] arr2 	= {1, 7, 10, 6, 11, 3, 2};
			int[] arr3 	= {0, 5, 9, 7, 12, 4, 2};
			assertAll("Should return: true, wave was ...", 
					() -> assertEquals(expectedTrue + Arrays.toString(arr1), workload.SearchWaves(arr1)),
					() -> assertEquals(expectedTrue + Arrays.toString(arr2), workload.SearchWaves(arr2)),
					() -> assertEquals(expectedTrue + Arrays.toString(arr3), workload.SearchWaves(arr3))
					);
		}
		
		@Test
		@DisplayName("with consecutive values in array")
		void testSearchWavesOnConsecutiveValues() {
						
			int[] arr1 	= {0, 3, 2, 4, 1, 1, 1};
			int[] arr2	= {0, 14, 8, 11, 13, 13, 13};
			int[] arr3	= {14, 12, 8, 11, 11, 13, 15};
			assertAll("Should return: false, no wave with ...", 
					() -> assertEquals(expectedFalse + Arrays.toString(arr1), workload.SearchWaves(arr1)),
					() -> assertEquals(expectedFalse + Arrays.toString(arr2), workload.SearchWaves(arr2)),
					() -> assertEquals(expectedFalse + Arrays.toString(arr3), workload.SearchWaves(arr3))
					);
		}

		@Test
		@DisplayName("with negative number in array")
		void testSearchWavesOnNegativeNumbers() {
			int[] arr1 	= {15, -14, 8, 11, 13, 10, 12};
			assertThrows(IllegalArgumentException.class, () -> workload.SearchWaves(arr1), "Should throw an exception");
		}		
		
		@Test
		@DisplayName("with empty array")
		void testSearchWavesOnEmptyArray() {
			int[] arr1 	= {};
			assertEquals(expectedFalse + Arrays.toString(arr1), workload.SearchWaves(arr1), "Should return: false, no wave with...");
		}				

	}

}
