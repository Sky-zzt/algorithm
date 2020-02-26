package Test;

import Sort.QuickSort;

import java.util.Arrays;

public class testsorttime {

    public static void main(String[] args) {
        long timeMillis = System.currentTimeMillis();
        int[] ints = {1,2};
        Arrays.sort(ints);
        System.out.println(System.currentTimeMillis()-timeMillis+"毫秒");

        long l = System.currentTimeMillis();
        QuickSort.quicksort(ints,0,ints.length-1);
        System.out.println(System.currentTimeMillis()-l+"毫秒");

    }
}
