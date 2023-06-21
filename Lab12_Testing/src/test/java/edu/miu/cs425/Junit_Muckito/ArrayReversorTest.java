package edu.miu.cs425.Junit_Muckito;

import edu.miu.cs425.Junit_Muckito.service.ArrayFlattenerService;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArrayReversorTest {
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
        public void testReverseArray() {
            int[][] a_in = new int[][]{{1, 3}, {0}, {4, 5, 9}};

            when(arrayFlattenerService.flattenArray(a_in)).thenReturn(new int[]{1, 3, 0, 4, 5, 9});
            int[] actual = arrayReversor.reverseArray(a_in);
            int[] expected = new int[]{9, 5, 4, 0, 3, 1};
            assertArrayEquals(expected, actual);
            verify(arrayFlattenerService).flattenArray(a_in);
    }

}
