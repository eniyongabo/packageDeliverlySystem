package edu.miu.cs425.Junit_Muckito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayFlattener {
    public Integer[] flattenArray(int[][] a_in) {
        if (a_in == null)
            return null;
        List<Integer> list = new ArrayList<>();
        for (int[] arr : a_in) {
            for (int i : arr) {
                list.add(i);
            }
        }
        return (Integer[]) list.toArray(new Integer[list.size()]);
    }
    public int[] flattenArray2(int[][] a_in) {
        if (a_in == null)
            return null;
        return Arrays.stream(a_in)
                .flatMapToInt(arr -> Arrays.stream(arr))
                .toArray();
    }
}
