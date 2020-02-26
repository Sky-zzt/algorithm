package Test;

import java.util.Random;

public class helanfla {
    public static void main(String[] args) {
        int[] ints = {1, 5, 12, 6, 3, 0, 34, -1};
        //  int[] flag = flag(ints, 0, 7, 5);
     quicksort(ints,0,7);
        for (int i = 0; i < 1000000000; i++) {
         //   System.out.println(ints[i]);
            System.out.print((int )(Math.random() * 4)+" "); ;
        }

    }

    /*
    给定一个数组arr，和一个数num，请把小于等于num的数放在数
组的左边，大于num的数放在数组的右边。

    对于一个数组，当我们遇到一个等于num的数时，less不动，当前位置加加，
    遇到一个比num小的让他和less的下一个交换less加加，当前位置加加。遇到一个大于num的
    跟more的前一个交换，more--，换过来后在与这个num比 。同理的过程
     */
    public static void quicksort(int arr[], int left, int right) {
     //   int len = arr.length;
        if (left<right) {
           // swap(arr, (int) (Math.random() * right + 1), right);
            int[] p = partion(arr, left, right, arr[left+(int) (Math.random() * (right-left + 1))]);
            quicksort(arr, left, p[0]-1);
            quicksort(arr, p[1]+1, right);
        }
    }
    public static int[] partion(int arr[], int left, int right, int num) {
        int less = left - 1;
        int more = right + 1;
        while (left < more) {
            if (arr[left] < num) {
                swap(arr, ++less, left++);
            } else if (num < arr[left]) {
                swap(arr, left, --more);
            } else {
                left++;   //等于的情况
            }



        }
        return new int[]{less + 1, --more};


    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
