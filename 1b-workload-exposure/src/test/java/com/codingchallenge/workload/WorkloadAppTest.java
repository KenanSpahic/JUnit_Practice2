package com.codingchallenge.workload;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import com.codingchallenge.workload.WorkloadApp;
import com.codingchallenge.workload.TestingSecurityManager.TestExitException;

/**
 * WorkloadAppTest is a unit test for WorkloadApp class.
 * <p>
 * In WorkloadAppTest class we use JUnit 5 to test methods from WorkloadApp
 * class and some possible scenarios.
 * This is a unit test that aims to test all code and code paths of a WorkloadApp class.
 */
@DisplayName("Testing WorkloadApp class")
public class WorkloadAppTest {

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	static SecurityManager originalSecurityManager;

	@BeforeAll
	public static void setup() {
		// Insert our own custom SecurityManager that throws an exception when
		// System.exit() is called.
		originalSecurityManager = System.getSecurityManager();
		System.setSecurityManager(new TestingSecurityManager());
	}

	@AfterAll
	public static void tearDown() {
		// Reinsert the original SecurityManager now that we are done with these tests.
		System.setSecurityManager(originalSecurityManager);
	}

	/**
	 * Using nested class for better grouping and testing different scenarios that can be passed to main
	 * method as an argument. 
	 */
	@Nested
	@DisplayName("Main method test")
	class MainTest {

		@Test
		@DisplayName("with correct waveform arrays")
		void testMainOnWaveform() {
			
			String[] arr1 = { "0", "3", "9", "5", "7", "10", "1", "4", "8" };
			WorkloadApp.main(arr1);
		}

		@Test
		@DisplayName("with consecutive values in array")
		void testMainOnConsecutiveValues() {
			
			String[] arr1 = { "0", "14", "8", "11", "13", "13", "13" };
			WorkloadApp.main(arr1);
		}

		@Test
		@DisplayName("with letters in array")
		void testMainOnLetters() {
			
			String[] arr1 = { "0", "8", "15", "7", "13", "A", "4", "1" };
			try {
				WorkloadApp.main(arr1);
				// Our custom SecurityManager should have thrown an exception when WorkloadApp
				// exited.
				// This means this line below cannot be reached. To make sure that our custom
				// SecurityManager
				// works as expected, we fail the test if this line is ever reached:
				fail("Unreachable.");
			} catch (TestExitException e) {
				assertThat(e.getStatus(), is(WorkloadApp.EXIT_STATUS_PARAMETER_IS_NOT_A_NUMBER));
			}
		}
		
	    @Test
	    @DisplayName("with negative number in array")
	    public void testMainOnNegativeNumber() {
	    	
	        String[] arr1 = { "0", "15", "-4", "9", "11", "12", "8" };;
	        try {
	            WorkloadApp.main(arr1);
	            fail("Unreachable.");
	        } catch (TestExitException e) {
	            // Did the program exit with the expected error code?
	            assertThat(e.getStatus(), is(WorkloadApp.EXIT_STATUS_PARAMETER_IS_NEGATIVE_NUMBER));
	        }
	    }
		
	    @Test
	    @DisplayName("with empty array")
	    public void testMainOnEmptyArray() {
	        // Passing no arguments should work.
	        String[] arr1 = {};
	        WorkloadApp.main(arr1);
	    }

	}	
}
