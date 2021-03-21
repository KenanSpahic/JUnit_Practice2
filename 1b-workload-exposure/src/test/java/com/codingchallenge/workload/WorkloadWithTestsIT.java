package com.codingchallenge.workload;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Integration test for the WorkloadApp program.
 * <p>
 * An integration test verifies the workings of a complete program or a module.
 */
@DisplayName("Integration test for WorkloadApp program")
public class WorkloadWithTestsIT {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void before() {
        // By putting our own PrintStream in the place of the normal System.out,
        // the output produced by the application can be verified.
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    public void cleanUp() {
        // Restore the original System.out to prevent weirdness in any following tests.
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("when the parameter is in waveform")
    public void doesItPrintTrue() {
        String[] arr1 	= {"0", "8", "15", "7", "13", "4", "1"};
        String result1	= "true, wave was " + Arrays.toString(arr1);
        WorkloadApp.main(arr1);
        String printResult = String.format("%s%s", result1, System.lineSeparator());
        assertThat(out.toString(), is(printResult));
    }

    @Test
    @DisplayName("when the parameter is not in waveform")
    public void doesItPrintMismatch() {
        String[] arr1 	= {"0", "14", "8", "11", "13", "13", "13"};
        String result1	= "false, no wave with " + Arrays.toString(arr1);
        WorkloadApp.main(arr1);

        String expectedOut = String.format("%s%s", result1, System.lineSeparator());
        assertThat(out.toString(), is(expectedOut));
    }
}
