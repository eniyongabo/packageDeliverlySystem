package edu.miu.cs425.Junit_Muckito;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayFlattenerTest {

    private ArrayFlattener arrayFlattener = null;

    @Before
    public void setUp() throws Exception {
        this.arrayFlattener = new ArrayFlattener();
    }

    @After
    public void tearDown() throws Exception {
        this.arrayFlattener = null;
    }

    @Test
    public void testFlattenArray() {
        int[][] a_in = { {1,3}, {0}, {4,5,9} };
        Integer[] a_out = arrayFlattener.flattenArray(a_in);
        Integer[] expected_a_out = { 1, 3, 0, 4, 5, 9 };
        boolean areArraysEqual = Arrays.equals(a_out, expected_a_out);
        assertTrue(areArraysEqual);
    }

    @Test
    public void testFlattenArray2() {
        int[][] a_in = { {1,3}, {0}, {4,5,9} };
        int[] a_out = arrayFlattener.flattenArray2(a_in);
        int[] expected_a_out = { 1, 3, 0, 4, 5, 9 };
        boolean areArraysEqual = Arrays.equals(a_out, expected_a_out);
        assertTrue(areArraysEqual);
    }

}
