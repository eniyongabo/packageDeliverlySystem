package edu.miu.cs425.Junit_Muckito;

import edu.miu.cs425.Junit_Muckito.service.ArrayFlattenerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArrayReversorNullTest {
    private ArrayReversor arrayReversor;
    private ArrayFlattenerService arrayFlattenerService = mock(ArrayFlattenerService.class);

    @Before
    public void setUp() throws Exception {
        this.arrayReversor = new ArrayReversor(arrayFlattenerService);
    }

    @After
    public void tearDown() throws Exception {
        this.arrayReversor = null;
    }

    @Test
    public void testReverseArrayNull() {
        int[][] a_in = null;
        when(arrayFlattenerService.flattenArray(a_in)).thenReturn(null);
        int[] actual = arrayReversor.reverseArray(a_in);
        int[] expected = null;
        assertArrayEquals(expected, actual);
        verify(arrayFlattenerService).flattenArray(a_in);
    }
}