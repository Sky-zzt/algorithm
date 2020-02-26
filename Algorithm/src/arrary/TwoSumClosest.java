package arrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class TwoSumClosest {
    public static int twosum(int arr[],int target) {
        Arrays.sort(arr);
        int begin = 0;
        int end = arr.length - 1;

        ArrayList<Integer> list = new ArrayList<>();
        while (begin < end) {
            if (arr[begin]+arr[end]>target) {
                list.add(Math.abs(target - (arr[begin] + arr[end])));
                end--;
            } else if (arr[begin]+arr[end]<target) {
                list.add(Math.abs(target - (arr[begin] + arr[end])));
            begin++;
        }
        }
        return Collections.max(list);  //也可以学习 maxsubarray那种方法进行求解最大值 会好一点
    }
}
