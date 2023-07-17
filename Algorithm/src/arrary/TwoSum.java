package arrary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class TwoSum {

    /*
    给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。

你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。

可以用hash表 我们用值做key index做v，加入target为9。 遍历数组依次放入hash表，每次遍历到一个数如7
看 在hash表中是否包含9-7，这个数 包含就返回他的index

事实上要返回他的index O（n）的空间必不可少
但是若只返回他的两个值  则可以用两根指针做
前提是要排好序



两根指针可以避免 额外的空间复杂度
     */
    public static int[] twosum(int arr[], int target) {

        TreeSet<Integer> integers = new TreeSet<>();

        integers.first();
        Arrays.sort(arr);
        int begin = 0;
        int end = arr.length - 1;
        while (begin < end) {
            if (arr[begin] + arr[end] > target) {
                end--;
            } else if (arr[begin] + arr[end] < target) {
                begin++;
            } else {
                return new int[]{begin, end};//返回的是排好序的数组的下标   所以这种做法是没有办法返回
                //下标的  只能返回对应的值
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(twosum(new int[]{1, 0, -1}, 1));
    }

    public int[] twoSum(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);

        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target-arr[i])){
                Integer integer = map.get(target - arr[i]);
                if (integer<i){
                    return new int []{integer,i};
                }else {
                    return new int[]{i,integer};
                }

            }
        }
return null;

    }

}
