package Sorting;

import java.util.Arrays;

public class ArraySortingSample {
    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 5, 2, 3};
        int[] b = new int[]{1, 4, 5, 2, 3};
        Arrays.sort(a);
        Arrays.parallelSort(b);//faster for ~>2500
        for (int aEl: a) {
            System.out.println(aEl);
        }
        for (int bEl: b) {
            System.out.println(bEl);
        }
    }
}
