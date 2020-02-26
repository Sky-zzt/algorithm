package daypractice;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        /**
         * 申请一个以两个数组中最大的数与最小数差为长度的第三个数组，
         * 然后按照占位的方法来判断，如果一个位置被两次申请，则认为此位置上的数字为重复的
         *
         */

        int[] arr = new int[]{1, 3, 56, 76, 89, 100};
        int[] arr1 = new int[]{-2, 3, 21, 49, 56};
        search(arr1, arr);


    }

    public static void search(int array1[], int array2[]) {
        int[] array3;
        int max = array1[array1.length - 1] > array2[array2.length - 1] ? array1[array1.length - 1] : array2[array2.length - 1];
        int min = array1[0] < array2[0] ? array1[0] : array2[0];
        array3 = new int[max - min + 1];
        for (int i = 0; i < (array1.length <= array2.length ? array2.length : array1.length); i++) {
            if (i < array1.length) {
                if (array3[array1[i] - min] == 0) {
                    array3[array1[i] - min] = array1[i];
                } else {
                    System.out.println(array3[array1[i] - min]);
                }
            }
            if (i < array2.length) {
                if (array3[array2[i] - min] == 0) {
                    array3[array2[i] - min] = array2[i];
                } else {
                    System.out.println(array3[array2[i] - min]);
                }
            }
        }

    }


}
