package arrary;

import java.util.Arrays;

public class RemoveDuplicateNumbersinArray {
    /*

    先排序
    序后用双指针。一个快指针一直往前走，慢指针先不动。
    当快指针发现它指向的数和慢指针不一样，
    就把该数丢给慢指针的后一个位置。
    慢指针++。最后返回慢指针的值+1。**这个思路很不错。
     */
    public static int remove(int[] arr) {
        Arrays.sort(arr);
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[index]) {
                arr[++index] = arr[i];
            }
        }
        return index + 1;
    }

    public static int []arrary;
    public static void main(String[] args) {

        int[] f = {1, 3,1, 10, 2,1,3};
        System.out.println(remove(f));



    }

    public static void f(int [] arr){
       // arr=null;
        arr[0]=100;
        arrary=arr;
    }
}
