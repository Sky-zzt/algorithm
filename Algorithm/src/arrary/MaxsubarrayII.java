package arrary;

import java.util.ArrayList;

public class MaxsubarrayII {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(1);
        list.add(0);
        list.add(3);
        list.add(2);
        list.add(4);
        maxTwoSubArrays(list);
    }
    /*
    给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大。
每个子数组的数字在数组中的位置应该是连续的。
返回最大的和。

子数组最少包含一个数
     */
    public static  int maxTwoSubArrays(ArrayList<Integer> nums) {
        //分割线左向有扫描一遍 右向左扫描一遍  不重叠意味着有分割线
        //给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大。
        //每个子数组的数字在数组中的位置应该是连续的。
        //返回最大的和
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left[i] = max;
        }
        //不重叠意味着你就要把每一个max放进数组里 最后进行比对  而不是求一个全局值
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {  //遍历分割线
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }

    public static int maxTwoSubArrays1(ArrayList<Integer> nums) {
        int prefixSum=0;
        int max=Integer.MIN_VALUE;
        int minSum=0;
        int leftarr[]=new int[nums.size()];
        int rightarr[]=new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            prefixSum+=nums.get(i);
            max=Math.max(max,prefixSum-minSum);
            minSum=Math.min(minSum,prefixSum);
            leftarr[i]=max;
        }
        prefixSum=0;
        max=Integer.MIN_VALUE;
        minSum=0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            prefixSum+=nums.get(i);
            max=Math.max(max,prefixSum-minSum);
            minSum=Math.min(minSum,prefixSum);
            rightarr[i]=max;
        }
        max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.size()-1; i++) {//搞明白为什么-1
            max=Math.max(max,leftarr[i]+rightarr[i+1]);//搞明白为什加1
        }
        return max;
    }
}


