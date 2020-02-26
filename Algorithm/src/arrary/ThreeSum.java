package arrary;

import java.util.Arrays;

public class ThreeSum {


    /*
    用hash的话 也可以 不太好

    用三根指针
    对数组挨个遍历使用twosum


    给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
     */
///不对  在思考一下   这个只能找到一个
    public static int[] threesum(int arr[], int target) {
        Arrays.sort(arr);
        int begin = 0;
        int end = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            while (begin <= end) {
                if (arr[i] + arr[begin] + arr[end] > target) {
                    end--;
                } else if (arr[i] + arr[begin] + arr[end] < target) {
                    begin++;
                } else {
                    return new int[]{arr[i],arr[begin],arr[end]};
                }
            }
            begin = 0;
            end = arr.length - 1;

        }
        return null;
    }

    public static void main(String[] args) {
        int[] threesum = threesum(new int[]{1, 23, 5, 6, 2, 9, 0}, 23*3);
        for (int i : threesum) {
            System.out.println(i);
        }

        String s="aaBbaAC";
        char[] chars = s.toCharArray();
       Arrays.sort(chars);
        System.out.println((int)'a');
        System.out.println((int )'A');

    }
}
